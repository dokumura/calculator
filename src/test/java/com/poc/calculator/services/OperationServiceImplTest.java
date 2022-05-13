package com.poc.calculator.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.poc.calculator.exceptions.OperationException;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.services.impl.OperationServiceImpl;
import com.poc.calculator.utils.Constants;

public class OperationServiceImplTest {

	private OperationService service;
	private OperationBO operationBO;

	@Before
	public void setup() {
		service = new OperationServiceImpl();
		operationBO = new OperationBO(new BigDecimal(1), new BigDecimal(2), Constants.OPERATION_ADDITION, null);
	}

	@Test
	public void givenOperationBO_whenServiceAddition_thenVerifyResultResponse() {
		ResultResponse resultResponse = service.getAddition(operationBO);
	    assertEquals(resultResponse.getResult(),new BigDecimal(3));
	}
	
	@Test
	public void givenOperationBOExceedsLimit_whenServiceAddition_thenVerifyException() {
		operationBO.setOperator1(new BigDecimal(1000000000));
		OperationException exception = Assertions.assertThrows(OperationException.class, () -> {
			service.getAddition(operationBO);
	  });
	  Assertions.assertEquals("Result exceeds the limit", exception.getMessage());
	}
	
	@Test
	public void givenOperationBO_whenServiceSubstraction_thenVerifyResultResponse() {
		ResultResponse resultResponse = service.getSubstraction(operationBO);
		assertEquals(resultResponse.getResult(),new BigDecimal(-1));
	}
}
