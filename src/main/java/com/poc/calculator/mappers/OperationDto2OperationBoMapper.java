package com.poc.calculator.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.poc.calculator.dtos.OperationDto;
import com.poc.calculator.models.OperationBO;

@Mapper
public interface OperationDto2OperationBoMapper {
 
	OperationDto2OperationBoMapper mapper = Mappers.getMapper(OperationDto2OperationBoMapper.class);
 
    OperationBO toOperationBO(OperationDto operationDto, String operation);
}