package com.poc.calculator.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.poc.calculator.models.OperationBO;
import com.poc.calculator.responses.ResultResponse;

@Mapper
public interface OperationBO2ResultResponseMapper {
 
	OperationBO2ResultResponseMapper mapper = Mappers.getMapper(OperationBO2ResultResponseMapper.class);
 
	ResultResponse toResultResponse(OperationBO operationBO);
}