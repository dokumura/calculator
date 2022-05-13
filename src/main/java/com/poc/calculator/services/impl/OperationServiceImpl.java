package com.poc.calculator.services.impl;

import org.springframework.stereotype.Service;

import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.services.OperationService;

@Service
public class OperationServiceImpl implements OperationService{

	@Override
	public ResultResponse getAddition(OperationBO operationBO) {
		return null;
	}

	@Override
	public ResultResponse getSubstraction(OperationBO operationBO) {
		return null;
	}

}
