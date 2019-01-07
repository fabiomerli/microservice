package it.test.springboot.microservices.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import it.test.springboot.microservices.controller.ForexController;
import it.test.springboot.microservices.entity.ExchangeValue;
import it.test.springboot.microservices.repo.ExchangeValueRepository;

@RunWith(MockitoJUnitRunner.class)
public class ForexControllerUnitTest {

	@Mock
	private ExchangeValueRepository exchangeValueRepositoryMock;

	@InjectMocks
	private ForexController forexController;

	@Test
	public void testRetrieveExchangeValue() {
		// ExchangeValueRepository exchangeValueRepositoryMock =
		// Mockito.mock(ExchangeValueRepository.class);
		Mockito.when(exchangeValueRepositoryMock.findByFromAndTo(Mockito.anyString(), any(String.class)))
				.thenReturn(new ExchangeValue(1L, "EUR", "POUND", new BigDecimal(2000)));

//		ForexController controller = new ForexController(exchangeValueRepositoryMock);
		ExchangeValue result = forexController.retrieveExchangeValue("EUR", "POUND");

		assertEquals(new Long(1), result.getId());
	}

	@Test
	public void testRetrieveExchangeValueMultipleReturn() {
		Mockito.when(exchangeValueRepositoryMock.findByFromAndTo("EUR", "POUND"))
				.thenReturn(new ExchangeValue(1L, "EUR", "POUND", new BigDecimal(2000)))
				.thenReturn(new ExchangeValue(2L, "EUR", "DOllAR", new BigDecimal(1000)));
		assertEquals(new BigDecimal(2000),
				forexController.retrieveExchangeValue("EUR", "POUND").getConversionMultiple());
		assertEquals(new BigDecimal(1000),
				forexController.retrieveExchangeValue("EUR", "POUND").getConversionMultiple());
	}

}
