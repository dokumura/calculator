package com.poc.calculator.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.poc.calculator.dtos.OperationDto;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.utils.Constants;

public class OperationDto2OperationBOMapperTest {

	@Test
	public void givenOperatorDTOOperationAdd_whenMapperToOperationBO_thenVerifyOperationBO() {
		// given
		OperationDto operationDto = new OperationDto(new BigDecimal(1), new BigDecimal(2));

		// when
		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto, Constants.OPERATION_ADDITION);

		// then
		assertThat(operationBO).isNotNull();
		assertEquals(operationBO.getOperator1(),new BigDecimal(1));
		assertEquals(operationBO.getOperator2(),new BigDecimal(2));
		assertEquals(operationBO.getOperation(),Constants.OPERATION_ADDITION);
	}
	
	@Test
	public void givenOperatorDTOOperator1Null_whenMapperToOperationBO_thenVerifyOperationBO() {
		// given
		OperationDto operationDto = new OperationDto(null, new BigDecimal(2));
		
		// when
		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto, Constants.OPERATION_ADDITION);
		
		// then
		assertThat(operationBO).isNotNull();
		assertEquals(operationBO.getOperator1(),null);
		assertEquals(operationBO.getOperator2(),new BigDecimal(2));
		assertEquals(operationBO.getOperation(),Constants.OPERATION_ADDITION);
	}
	
	@Test
	public void givenOperatorDTOOperator2Null_whenMapperToOperationBO_thenVerifyOperationBO() {
		// given
		OperationDto operationDto = new OperationDto(new BigDecimal(1), null);
		
		// when
		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto, Constants.OPERATION_ADDITION);
		
		// then
		assertThat(operationBO).isNotNull();
		assertEquals(operationBO.getOperator1(),new BigDecimal(1));
		assertEquals(operationBO.getOperator2(),null);
		assertEquals(operationBO.getOperation(),Constants.OPERATION_ADDITION);
	}
	
	@Test
	public void givenOperatorDTOOperationNull_whenMapperToOperationBO_thenVerifyOperationBO() {
		// given
		OperationDto operationDto = new OperationDto(new BigDecimal(1), new BigDecimal(2));
		
		// when
		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto, null);
		
		// then
		assertThat(operationBO).isNotNull();
		assertEquals(operationBO.getOperator1(),new BigDecimal(1));
		assertEquals(operationBO.getOperator2(),new BigDecimal(2));
		assertEquals(operationBO.getOperation(),null);
	}
	
	@Test
	public void givenOperatorDTOOperationSub_whenMapperToOperationBO_thenVerifyOperationBO() {
		// given
		OperationDto operationDto = new OperationDto(new BigDecimal(1), new BigDecimal(2));
		
		// when
		OperationBO operationBO = OperationDto2OperationBoMapper.mapper.toOperationBO(operationDto, Constants.OPERATION_SUBSTRACTION);
		
		// then
		assertThat(operationBO).isNotNull();
		assertEquals(operationBO.getOperator1(),new BigDecimal(1));
		assertEquals(operationBO.getOperator2(),new BigDecimal(2));
		assertEquals(operationBO.getOperation(),Constants.OPERATION_SUBSTRACTION);
	}

}
