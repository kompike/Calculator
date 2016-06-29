package com.javaclasses.calculator.impl.function;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;

/**
 * Function implementation for math pi number
 */
public class PiFunction implements Function {

    @Override
    public int getMinimumArgumentsNumber() {
        return 0;
    }

    @Override
    public int getMaximumArgumentsNumber() {
        return 0;
    }

    @Override
    public double execute(Double... args) throws IncorrectExpressionException {

        return Math.PI;
    }

}
