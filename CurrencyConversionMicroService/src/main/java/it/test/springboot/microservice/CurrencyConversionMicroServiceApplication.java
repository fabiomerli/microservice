package it.test.springboot.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("it.test.springboot.microservice")
@EnableDiscoveryClient
public class CurrencyConversionMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionMicroServiceApplication.class, args);
	}

}

