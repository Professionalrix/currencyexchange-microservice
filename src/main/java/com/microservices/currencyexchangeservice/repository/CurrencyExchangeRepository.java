package com.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservices.currencyexchangeservice.bean.CurrencyExchange;


public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	@Query("SELECT s FROM CurrencyExchange s where s.from =:from and s.to =:to")
	CurrencyExchange findByFromAndTo(String from, String to);
	
	@Query("SELECT s FROM CurrencyExchange s where s.from =:from and s.to =:to")
	CurrencyExchange findByFromAndTos(@Param("from")String froms , @Param("to") String tos);
	
	
	@Query(value="SELECT s FROM CurrencyExchange s where s.from = ?1 and s.to = ?2")
	CurrencyExchange findByFromAndTosss(String from ,String to);
	
	@Query(value="SELECT * FROM Currency_Exchange s where s.currency_from = :from and s.currency_to = :to",nativeQuery = true)
	CurrencyExchange findByFromAndToss(@Param("from") String from , @Param("to") String to);
	
	//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	//User findUserByStatusAndName(Integer status, String name);
	
	
	//CurrencyExchange findByFromAndTo(String froms ,String to);
	//Optional<CurrencyExchange> findById(Long id);

	
}
