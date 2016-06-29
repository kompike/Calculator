package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.EvaluationStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation for {@link OutputContext} interface for
 * math expressions
 */
public class MathExpressionOutputContext implements OutputContext {

    private final Logger log = LoggerFactory.getLogger(MathExpressionOutputContext.class);

    private EvaluationStack evaluationStack = new EvaluationStack();
    private ContextClosure contextClosure = null;

    @Override
    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    public ContextClosure getContextClosure() {
        return contextClosure;
    }

    @Override
    public void setEvaluationStack(EvaluationStack stack, ContextClosure context) {

        if (log.isDebugEnabled()) {
            log.debug("New evaluation stack created");
        }

        evaluationStack = new EvaluationStack(stack, context);
        this.contextClosure = null;
    }

    public void setContextClosure(ContextClosure context) {
        this.contextClosure = context;
    }

    @Override
    public void leaveCurrentEvaluationStack() throws IncorrectExpressionException {

        if (log.isDebugEnabled()) {
            log.debug("Leaving current evaluation stack...");
        }

        evaluationStack.getContextClosure().closeContext(this);

        final double result = evaluationStack.popResult();

        evaluationStack = evaluationStack.getParent();

        evaluationStack.pushOperand(result);

        if (log.isDebugEnabled()) {
            log.debug("Evaluation stack changed");
        }
    }

    @Override
    public double popResult() throws IncorrectExpressionException {
        return getEvaluationStack().popResult();
    }
}
