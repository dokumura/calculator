package com.poc.calculator.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.calculator.dtos.OperationDto;
import com.poc.calculator.services.OperationService;
import com.poc.calculator.services.impl.OperationServiceImpl;

import io.corp.calculator.TracerImpl;

public class OperationControllerIntegrationTest {

	private MockMvc mockMvc;
	private OperationService operationService;
	private TracerImpl tracerImpl;
	private OperationDto operationDto;
	private static final String CONTENT_TYPE = "application/json";

	@BeforeEach
	void setUp() {
		operationDto = new OperationDto(new BigDecimal(1), new BigDecimal(2));
		operationService = new OperationServiceImpl();
		tracerImpl = new TracerImpl();
		this.mockMvc = MockMvcBuilders.standaloneSetup(new OperationController(operationService, tracerImpl)).build();
	}

	@Test
	public void givenAddURI_whenMockMVC_thenVerifyResponse() throws Exception {
		String requestJson = new ObjectMapper().writeValueAsString(operationDto);
		this.mockMvc.perform(post("/operation/addition").contentType(CONTENT_TYPE).content(requestJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$.result").value(3));
	}
	
	@Test
	public void givenAddURI_whenMockMVCOp1Null_thenVerifyResponse400() throws Exception {
		operationDto.setOperator1(null);
		String requestJson = new ObjectMapper().writeValueAsString(operationDto);
		this.mockMvc.perform(post("/operation/addition").contentType(CONTENT_TYPE).content(requestJson))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void givenAddURI_whenMockMVCOp2Null_thenVerifyResponse400() throws Exception {
		operationDto.setOperator2(null);
		String requestJson = new ObjectMapper().writeValueAsString(operationDto);
		this.mockMvc.perform(post("/operation/addition").contentType(CONTENT_TYPE).content(requestJson))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void givenAddURI_whenMockMVCOpDtoNull_thenVerifyResponse400() throws Exception {
		String requestJson = new ObjectMapper().writeValueAsString(null);
		this.mockMvc.perform(post("/operation/addition").contentType(CONTENT_TYPE).content(requestJson))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void givenSubURI_whenMockMVC_thenVerifyResponse() throws Exception {
		String requestJson = new ObjectMapper().writeValueAsString(operationDto);
		this.mockMvc.perform(post("/operation/substraction").contentType(CONTENT_TYPE).content(requestJson))
		.andExpect(status().isOk()).andExpect(jsonPath("$.result").value(-1));
	}
	
	@Test
	public void givenSubURI_whenMockMVCOp1Char_thenVerifyResponse() throws Exception {
		String requestJson = new ObjectMapper().writeValueAsString("{\"operator1\":\"H\",\"operator2\":2}");
		this.mockMvc.perform(post("/operation/substraction").contentType(CONTENT_TYPE).content(requestJson))
		.andExpect(status().is4xxClientError());
	}

}
