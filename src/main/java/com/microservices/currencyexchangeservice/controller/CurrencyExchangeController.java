package com.microservices.currencyexchangeservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.CurrencyExchangeServiceApplication;
import com.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	static Logger logger = LogManager.getLogger(CurrencyExchangeServiceApplication.class);
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1001L,from,to,BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		if(currencyExchange ==null) {
			throw new RuntimeException("Unable to find data from "+from+"to"+to);
		}
		System.out.println("Narender Singh");
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		logger.trace("controller executing");
		return currencyExchange;
		
	}
	
}
