package it.test.springboot.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.test.springboot.microservices.entity.ExchangeValue;

/**
 * 
 * @author Fabio Merli
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}