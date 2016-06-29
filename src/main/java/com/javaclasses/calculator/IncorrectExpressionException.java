package com.javaclasses.calculator;

/**
 * Custom exception for handling wrong symbol's
 * position in evaluated expression
 */

public class IncorrectExpressionException extends Exception {

    private final int position;

    public IncorrectExpressionException(String message, int position) {
        super(message + " " + position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
