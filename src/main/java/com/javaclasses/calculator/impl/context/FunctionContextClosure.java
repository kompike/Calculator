package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Context closure implementation for functions
 */
public class FunctionContextClosure implements ContextClosure {

    private final Logger log = LoggerFactory.getLogger(FunctionContextClosure.class);

    private Function function;

    public FunctionContextClosure(Function function) {
        this.function = function;
    }

    @Override
    public boolean isInFunction() {
        return true;
    }

    @Override
    public void closeContext(OutputContext outputContext) throws IncorrectExpressionException {

        final List<Double> functionArguments =
                outputContext.getEvaluationStack().popAllOperands();

        if (log.isDebugEnabled()) {
            log.debug("Arguments list length: " + functionArguments.size());
        }

        final double result = function.execute(functionArguments.toArray
                    (new Double[functionArguments.size()]));

        if (log.isDebugEnabled()) {
            log.debug("Closure result: " + result);
        }

        outputContext.getEvaluationStack().getOperandStack().push(result);

    }

}
