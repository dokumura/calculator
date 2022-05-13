package com.poc.calculator.controllers;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.poc.calculator.dtos.OperationDto;
import com.poc.calculator.exceptions.OperationException;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.services.OperationService;

import io.corp.calculator.TracerImpl;

public class OperationControllerTest {

	ResultResponse resultResponse;
	
	OperationDto operationDto;
	
	@Mock
	OperationService operationService;
	
	@Mock
	TracerImpl tracerImpl;
	
	@InjectMocks
	OperationController operationController;
	
	@Before
	public void init() throws OperationException {
		MockitoAnnotations.initMocks(this);
		resultResponse = new ResultResponse();
		operationDto = new OperationDto(new BigDecimal(1), new BigDecimal(2));
	}
	
	@Test
	public void givenOperationBO_whenMockAddition_thenVerifyResponse() throws OperationException{
		resultResponse.setResult(new BigDecimal(3));
		Mockito.when(operationService.getAddition(Mockito.any(OperationBO.class))).thenReturn(resultResponse);
		ResponseEntity<ResultResponse> response = operationController.operationAddition(operationDto);
		assertEquals(response.getBody().getResult(), new BigDecimal(3));
	}
	
	@Test
	public void givenOperationBO_whenMockSubstraction_thenVerifyResponse() throws OperationException{
		resultResponse.setResult(new BigDecimal(-1));
		Mockito.when(operationService.getSubstraction(Mockito.any(OperationBO.class))).thenReturn(resultResponse);
		ResponseEntity<ResultResponse> response = operationController.operationSubstraction(operationDto);
		assertEquals(response.getBody().getResult(), new BigDecimal(-1));
	}


}
