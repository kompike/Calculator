package com.javaclasses.calculator.function;

/**
 * Function implementation for math sum
 */
public class SumFunction implements Function {

    @Override
    public double execute(Double... args) {

        if (args == null || args.length < 2) {

            throw new IllegalStateException(
                    "Function must have at least two arguments.");
        }

        double sum = 0;

        for (double argument : args) {
            sum += argument;
        }

        return sum;
    }

}
