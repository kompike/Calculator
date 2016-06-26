package com.javaclasses.calculator.function;

/**
 * Function implementation for math pi number
 */
public class PiFunction implements Function {

    @Override
    public double execute(Double... args) {

        if (args.length != 0) {

            throw new IllegalStateException(
                    "Function must have no arguments.");
        }

        return Math.PI;
    }

}
