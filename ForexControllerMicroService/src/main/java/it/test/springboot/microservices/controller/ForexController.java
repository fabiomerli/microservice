package it.test.springboot.microservices.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.test.springboot.microservices.entity.ExchangeValue;
import it.test.springboot.microservices.repo.ExchangeValueRepository;

/**
 * 
 * @author Fabio Merli
 *
 */
@RestController
public class ForexController {
	
	private static final Logger LOGGER = LogManager.getLogger(ForexController.class);
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private ExchangeValueRepository repository;
  
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue
    (@PathVariable String from, @PathVariable String to){
    
    ExchangeValue exchangeValue = 
        repository.findByFromAndTo(from, to);
    
    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    
    LOGGER.info("INFO:  {}", exchangeValue);
    return exchangeValue;
  }
}
