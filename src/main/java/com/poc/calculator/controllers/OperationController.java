package com.poc.calculator.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.calculator.dtos.OperationDto;
import com.poc.calculator.exceptions.OperationException;
import com.poc.calculator.mappers.OperationDto2OperationBoMapper;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.services.OperationService;
import com.poc.calculator.utils.Constants;

import io.swagger.annotations.ApiOperation;

import io.corp.calculator.TracerImpl;

@RestController
public class OperationController {

	private final TracerImpl tracerAPI;

	private final OperationService operationService;

	public OperationController(OperationService operationService, TracerImpl tracerAPI) {
		this.tracerAPI = tracerAPI;
		this.operationService = operationService;
	}

	@ApiOperation(value = "Operation")
	@PostMapping(value = "/operation/"
			+ Constants.OPERATION_ADDITION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultResponse> operationAddition(@RequestBody @Valid OperationDto operationDto)
			throws OperationException {

		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto,
				Constants.OPERATION_ADDITION);
		ResultResponse resultResponse = operationService.getAddition(operationBO);
		tracerAPI.trace("The result of operation is: " + operationBO.getOperator1() + " + " + operationBO.getOperator2()
				+ " = " + operationBO.getResult());

		return new ResponseEntity<>(resultResponse, HttpStatus.OK);
	}

	@ApiOperation(value = "Operation")
	@PostMapping(value = "/operation/"
			+ Constants.OPERATION_SUBSTRACTION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultResponse> operationSubstraction(@RequestBody @Valid OperationDto operationDto)
			throws OperationException {

		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto,
				Constants.OPERATION_SUBSTRACTION);
		ResultResponse resultResponse = operationService.getSubstraction(operationBO);
		tracerAPI.trace("The result of operation is: " + operationBO.getOperator1() + " - " + operationBO.getOperator2()
				+ " = " + operationBO.getResult());

		return new ResponseEntity<>(resultResponse, HttpStatus.OK);
	}
}
