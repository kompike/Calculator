package com.javaclasses.calculator.function;

/**
 * Function implementation for math sum
 */
public class SumFunction implements Function {

    @Override
    public double execute(Double... args) {
        double sum = 0;

        for (double argument : args) {
            sum += argument;
        }

        return sum;
    }

}
