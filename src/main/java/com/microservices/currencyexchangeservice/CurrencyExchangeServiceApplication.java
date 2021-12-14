package com.microservices.currencyexchangeservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	 static Logger logger = LogManager.getLogger(CurrencyExchangeServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
		
	System.out.println("Hello");
	
	// level
	logger.trace("This is a tracing msg");
	logger.debug("This is a debug msg");
	logger.info("This is a info msg");
	logger.warn("This is a warn msg");
	logger.error("This is a error msg");
	logger.fatal("This is a fatal msg");
	
	
		
	}

}
