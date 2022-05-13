package com.poc.calculator.controllers;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.calculator.dtos.OperationDto;
import com.poc.calculator.exceptions.OperationException;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.utils.Constants;

import io.swagger.annotations.ApiOperation;

@RestController
public class OperationController {

	@ApiOperation(value = "Operation")
	@PostMapping(value = "/operation/"
			+ Constants.OPERATION_ADDITION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultResponse> operationAddition(@RequestBody @Valid OperationDto operationDto)
			throws OperationException {
		return null;
	}

	@ApiOperation(value = "Operation")
	@PostMapping(value = "/operation/"
			+ Constants.OPERATION_SUBSTRACTION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultResponse> operationSubstraction(@RequestBody @Valid OperationDto operationDto)
			throws OperationException {
		return null;
	}
}
