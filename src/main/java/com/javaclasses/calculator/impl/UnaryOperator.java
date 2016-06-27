package com.javaclasses.calculator.impl;

/**
 * Abstract instance of unary operator
 */
public abstract class UnaryOperator {

    public abstract double execute(double arg);

    private Notation notation;

    public UnaryOperator(Notation notation) {
        this.notation = notation;
    }

    public Notation getNotation() {
        return notation;
    }

    public enum Notation {
        PREFIX,
        POSTFIX
    }
}
