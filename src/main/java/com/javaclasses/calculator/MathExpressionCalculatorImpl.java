package com.javaclasses.calculator;

import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.MathExpressionInputContext;
import com.javaclasses.calculator.context.MathExpressionOutputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.exception.EvaluationException;
import com.javaclasses.calculator.finitestatemachine.AbstractFiniteStateMachine;

/**
 * Implementation of {@link MathExpressionCalculator} interface
 */

public class MathExpressionCalculatorImpl extends AbstractFiniteStateMachine
        implements MathExpressionCalculator {

    @Override
    public double evaluate(String expression) throws EvaluationException {

        final InputContext inputContext =
                new MathExpressionInputContext(expression);

        final OutputContext outputContext =
                new MathExpressionOutputContext();

        run(inputContext, outputContext);

        return outputContext.popResult();
    }

    @Override
    protected void deadlock(InputContext inputContext, OutputContext outputContext)
            throws EvaluationException {

        throw new EvaluationException("Can not execute expression after position ",
                inputContext.getCurrentPosition());
    }
}
