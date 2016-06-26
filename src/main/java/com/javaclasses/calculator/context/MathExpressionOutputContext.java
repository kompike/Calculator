package com.javaclasses.calculator.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation for {@link OutputContext} interface for
 * math expressions
 */
public class MathExpressionOutputContext implements OutputContext {

    private final Logger log = LoggerFactory.getLogger(MathExpressionOutputContext.class);

    private EvaluationStack evaluationStack = new EvaluationStack();
    private ClosureContext closureContext = null;

    @Override
    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    @Override
    public ClosureContext getClosureContext() {
        return closureContext;
    }

    @Override
    public void setEvaluationStack(EvaluationStack stack, ClosureContext context) {

        if (log.isDebugEnabled()) {
            log.debug("New evaluation stack created");
        }

        evaluationStack = new EvaluationStack(stack, context);
        this.closureContext = null;
    }

    @Override
    public void setClosureContext(ClosureContext context) {
        this.closureContext = context;
    }

    @Override
    public void leaveCurrentEvaluationStack() {

        if (evaluationStack.getParent() == null) {

            throw new IllegalStateException("Opening bracket missing");
        }

        if (log.isDebugEnabled()) {
            log.debug("Leaving current evaluation stack...");
        }

        evaluationStack.getClosureContext().closeContext();

        final double result = evaluationStack.popResult();

        evaluationStack = evaluationStack.getParent();

        evaluationStack.getOperandStack().push(result);

        if (log.isDebugEnabled()) {
            log.debug("Evaluation stack changed");
        }
    }

    @Override
    public double popResult() {
        return getEvaluationStack().popResult();
    }
}
