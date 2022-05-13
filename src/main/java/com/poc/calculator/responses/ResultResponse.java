package com.poc.calculator.responses;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResultResponse {

	@JsonProperty("result")
	private BigDecimal result;
}