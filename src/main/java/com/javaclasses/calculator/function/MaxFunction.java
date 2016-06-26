package com.javaclasses.calculator.function;

/**
 * Function implementation for math maximum
 */
public class MaxFunction implements Function {

    @Override
    public double execute(Double... args) {

        if (args == null || args.length < 2) {

            throw new IllegalStateException(
                    "Function must have at least two arguments.");
        }

        double max = args[0];

        for (double argument : args) {

            if (argument > max) {
                max = argument;
            }
        }

        return max;
    }

}
