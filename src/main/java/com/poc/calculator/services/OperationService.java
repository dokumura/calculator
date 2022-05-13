package com.poc.calculator.services;

import com.poc.calculator.exceptions.OperationException;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;

public interface OperationService {

	ResultResponse getAddition(OperationBO operationBO) throws OperationException;
	
	ResultResponse getSubstraction(OperationBO operationBO) throws OperationException;
	
}
