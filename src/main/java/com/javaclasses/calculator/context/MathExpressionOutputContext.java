package com.javaclasses.calculator.context;

/**
 * Implementation for {@link OutputContext} interface for
 * math expressions
 */
public class MathExpressionOutputContext implements OutputContext {

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
        evaluationStack = new EvaluationStack(stack, context);
        this.closureContext = null;
    }

    @Override
    public void setClosureContext(ClosureContext context) {
        this.closureContext = context;
    }

    @Override
    public void leaveCurrentEvaluationStack() {
        evaluationStack.getContext().closeContext();

        final double result = evaluationStack.popResult();

        evaluationStack = evaluationStack.getParent();

        evaluationStack.getOperandStack().push(result);
    }

    @Override
    public double popResult() {
        return getEvaluationStack().popResult();
    }
}
