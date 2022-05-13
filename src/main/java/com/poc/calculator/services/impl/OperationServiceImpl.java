package com.poc.calculator.services.impl;

import org.springframework.stereotype.Service;

import com.poc.calculator.exceptions.OperationException;
import com.poc.calculator.mappers.OperationBO2ResultResponseMapper;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.services.OperationService;

@Service
public class OperationServiceImpl implements OperationService{

	@Override
	public ResultResponse getAddition(OperationBO operationBO) throws OperationException {
		operationBO.setResult(operationBO.getOperator1().add(operationBO.getOperator2()));
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);
		return resultResponse;
	}

	@Override
	public ResultResponse getSubstraction(OperationBO operationBO) throws OperationException {
		operationBO.setResult(operationBO.getOperator1().subtract(operationBO.getOperator2()));
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);
		return resultResponse;
	}

}
