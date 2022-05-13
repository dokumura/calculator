package com.poc.calculator.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;
import com.poc.calculator.utils.Constants;

public class OperationBO2ResultResponseMapperTest {

	@Test
	public void givenOperatorBO_whenMockAddition_thenVerifyResultResponse() {
		// given
		OperationBO operationBO = new OperationBO(new BigDecimal(1), new BigDecimal(2), Constants.OPERATION_ADDITION, new BigDecimal(3));

		// when
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);

		// then
		assertThat(resultResponse).isNotNull();
		assertEquals(resultResponse.getResult(),new BigDecimal(3));
	}
	
	@Test
	public void givenOperationBOOperator1Null_whenMockAddition_thenVerifyResultResponse() {
		// given
		OperationBO operationBO = new OperationBO(null, new BigDecimal(2), Constants.OPERATION_ADDITION, new BigDecimal(3));
		
		// when
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);
		
		// then
		assertThat(resultResponse).isNotNull();
		assertEquals(resultResponse.getResult(),new BigDecimal(3));
	}
	
	@Test
	public void givenOperationBOOperator2Null_whenMockAddition_thenVerifyResultResponse() {
		// given
		OperationBO operationBO = new OperationBO(new BigDecimal(1), null, Constants.OPERATION_ADDITION, new BigDecimal(3));
		
		// when
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);
		
		// then
		assertThat(resultResponse).isNotNull();
		assertEquals(resultResponse.getResult(),new BigDecimal(3));
	}
	
	@Test
	public void givenOperationBOOperationNull_whenMockAddition_thenVerifyResultResponse() {
		// given
		OperationBO operationBO = new OperationBO(new BigDecimal(1), new BigDecimal(2), null, new BigDecimal(3));
		
		// when
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);
		
		// then
		assertThat(resultResponse).isNotNull();
		assertEquals(resultResponse.getResult(),new BigDecimal(3));
	}
	
	@Test
	public void givenOperationBOResultNull_whenMockAddition_thenVerifyResultResponse() {
		// given
		OperationBO operationBO = new OperationBO(new BigDecimal(1), new BigDecimal(2), Constants.OPERATION_ADDITION, null);
		
		// when
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);
		
		// then
		assertThat(resultResponse).isNotNull();
		assertThat(resultResponse.getResult()).isNull();
	}
	
	@Test
	public void givenOperatorBO_whenMockSubstraction_thenVerifyResultResponse() {
		// given
		OperationBO operationBO = new OperationBO(new BigDecimal(1), new BigDecimal(2), Constants.OPERATION_SUBSTRACTION, new BigDecimal(-1));

		// when
		ResultResponse resultResponse = OperationBO2ResultResponseMapper.mapper.toResultResponse(operationBO);

		// then
		assertThat(resultResponse).isNotNull();
		assertEquals(resultResponse.getResult(),new BigDecimal(-1));
	}

}
