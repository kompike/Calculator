package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Context closure implementation for brackets
 */
public class BracketsContextClosure implements ContextClosure {

    private final Logger log = LoggerFactory.getLogger(BracketsContextClosure.class);

    @Override
    public boolean isInFunction() {
        return false;
    }

    @Override
    public Function getFunction() {
        return null;
    }

    @Override
    public void closeContext(OutputContext outputContext) throws IncorrectExpressionException {

        outputContext.getEvaluationStack().popAllBinaryOperators();

        final double result = outputContext.popResult();

        if (log.isDebugEnabled()) {
            log.debug("Default closureContext result: " + result);
        }

        outputContext.getEvaluationStack().pushOperand(result);

    }

}
