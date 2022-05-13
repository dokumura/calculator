package com.poc.calculator.error;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.poc.calculator.exceptions.OperationException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	public ControllerAdvisor() {
		super();
	}

	@ExceptionHandler(OperationException.class)
	public ResponseEntity<Object> handleOperationException(OperationException ex, final WebRequest request) {

		Map<String, Object> bodyOfResponse = new LinkedHashMap<>();
		bodyOfResponse.put("timestamp", LocalDateTime.now());
		bodyOfResponse.put("message", ex.getMessage());

		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

		Map<String, Object> bodyOfResponse = new LinkedHashMap<>();
		bodyOfResponse.put("timestamp", LocalDate.now());
		bodyOfResponse.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getField() + " " + x.getDefaultMessage())
				.collect(Collectors.toList());

		bodyOfResponse.put("errors", errors);

		return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
	}

}