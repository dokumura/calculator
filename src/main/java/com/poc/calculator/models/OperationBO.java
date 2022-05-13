package com.poc.calculator.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationBO {
	
	private BigDecimal operator1;

	private BigDecimal operator2;
	
	private String operation;
	
	private BigDecimal result;

}
