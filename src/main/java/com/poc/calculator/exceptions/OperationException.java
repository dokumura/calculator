package com.poc.calculator.exceptions;

@SuppressWarnings("serial")
public class OperationException extends RuntimeException {

    public OperationException(String message) {

        super(message);
    }
}