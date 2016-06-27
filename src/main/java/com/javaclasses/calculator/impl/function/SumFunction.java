package com.javaclasses.calculator.impl.function;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;

/**
 * Function implementation for math sum
 */
public class SumFunction implements Function {

    @Override
    public double execute(Double... args) throws IncorrectExpressionException {

        if (args == null || args.length < 2) {

            throw new IncorrectExpressionException(
                    "Function must have at least two arguments.");
        }

        double sum = 0;

        for (double argument : args) {
            sum += argument;
        }

        return sum;
    }

}
