package com.javaclasses.calculator.context;

/**
 * Implementation for {@link OutputContext} interface for
 * math expressions
 */
public class MathExpressionOutputContext implements OutputContext {

    private EvaluationStack evaluationStack = new EvaluationStack();

    @Override
    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    @Override
    public void setEvaluationStack(EvaluationStack stack) {
        evaluationStack = new EvaluationStack(stack);
    }

    @Override
    public void leaveCurrentEvaluationStack() {
        evaluationStack = evaluationStack.getParent();
    }

    @Override
    public double popResult() {
        return getEvaluationStack().popResult();
    }
}
