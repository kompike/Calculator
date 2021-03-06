package com.javaclasses.calculator.impl.finitestatemachine;

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
    PREFIX_UNARY_OPERATOR,
    POSTFIX_UNARY_OPERATOR,
    FINISH
}
