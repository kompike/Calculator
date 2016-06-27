package com.javaclasses.calculator.impl.function;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;

/**
 * Function implementation for math pi number
 */
public class PiFunction implements Function {

    @Override
    public double execute(Double... args) throws IncorrectExpressionException {

        if (args.length != 0) {

            throw new IncorrectExpressionException(
                    "Function must have no arguments.");
        }

        return Math.PI;
    }

}
