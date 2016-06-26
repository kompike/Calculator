package com.javaclasses.calculator.function;

/**
 * Function implementation for math minimum
 */
public class MinFunction implements Function {

    @Override
    public double execute(Double... args) {

        if (args == null || args.length < 2) {

            throw new IllegalStateException(
                    "Function must have at least two arguments.");
        }

        double min = args[0];

        for (double argument : args) {

            if (argument < min) {
                min = argument;
            }
        }

        return min;
    }

}
