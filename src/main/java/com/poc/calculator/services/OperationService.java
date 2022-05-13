package com.poc.calculator.services;

import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;

public interface OperationService {

	ResultResponse getAddition(OperationBO operationBO);
	
	ResultResponse getSubstraction(OperationBO operationBO);
	
}
