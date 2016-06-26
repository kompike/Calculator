package com.javaclasses.calculator.finitestatemachine;

/**
 * Enum of possible finite-state machine states
 */
public enum State {

    START,
    NUMBER,
    BINARY_OPERATOR,
    OPENING_BRACKET,
    CLOSING_BRACKET,
    FUNCTION,
    ARGUMENTS_SEPARATOR,
    UNARY_OPERATOR,
    FINISH
}
