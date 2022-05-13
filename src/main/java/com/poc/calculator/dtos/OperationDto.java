package com.poc.calculator.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {

	@NotNull
	@JsonProperty("operator1")
	private BigDecimal operator1;

	@NotNull
	@JsonProperty("operator2")
	private BigDecimal operator2;
	
}
