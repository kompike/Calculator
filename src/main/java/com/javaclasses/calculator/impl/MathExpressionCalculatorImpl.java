package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.MathExpressionCalculator;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.MathExpressionInputContext;
import com.javaclasses.calculator.impl.context.MathExpressionOutputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import com.javaclasses.calculator.impl.finitestatemachine.AbstractFiniteStateMachine;

/**
 * Implementation of {@link MathExpressionCalculator} interface
 */

public class MathExpressionCalculatorImpl extends AbstractFiniteStateMachine
        implements MathExpressionCalculator {

    @Override
    public double evaluate(String expression) throws IncorrectExpressionException {

        final InputContext inputContext =
                new MathExpressionInputContext(expression);

        final OutputContext outputContext =
                new MathExpressionOutputContext();

        run(inputContext, outputContext);

        return outputContext.popResult();
    }

    @Override
    protected void deadlock(InputContext inputContext, OutputContext outputContext)
            throws IncorrectExpressionException {

        throw new IncorrectExpressionException("Expression contains incorrect symbol after position: " +
                inputContext.getCurrentPosition(), inputContext.getCurrentPosition());
    }
}
