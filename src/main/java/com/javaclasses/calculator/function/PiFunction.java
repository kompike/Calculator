package com.javaclasses.calculator.function;

/**
 * Function implementation for math pi number
 */
public class PiFunction implements Function {

    @Override
    public double execute(Double... args) {
        return Math.PI;
    }

}
