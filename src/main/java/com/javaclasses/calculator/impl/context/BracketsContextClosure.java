package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;
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
    public void closeContext(OutputContext outputContext) throws IncorrectExpressionException {

        outputContext.getEvaluationStack().popAllOperators();

        final double result = outputContext.popResult();

        if (log.isDebugEnabled()) {
            log.debug("Default closureContext result: " + result);
        }

        outputContext.getEvaluationStack().getOperandStack().push(result);

    }

}
