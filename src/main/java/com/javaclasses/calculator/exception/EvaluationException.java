package com.javaclasses.calculator.exception;

/**
 * Custom exception for handling wrong symbol's
 * position in evaluated expression
 */

public class EvaluationException extends Exception {

    private final int position;

    public EvaluationException(String message, int position) {
        super(message);
        this.position = position;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + position;
    }
}
