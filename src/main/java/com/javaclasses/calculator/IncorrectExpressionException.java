package com.javaclasses.calculator;

/**
 * Custom exception for handling wrong symbol's
 * position in evaluated expression
 */

public class IncorrectExpressionException extends Exception {

    private int position;

    public IncorrectExpressionException(String message) {
        super(message);
    }

    public IncorrectExpressionException(String message, int position) {
        super(message);
        this.position = position;
    }
}
