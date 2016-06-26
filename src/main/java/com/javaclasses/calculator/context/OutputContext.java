package com.javaclasses.calculator.context;

/**
 * Basic interface for operating finite-state machine's
 * output data
 */
public interface OutputContext {

    /**
     * Get current evaluation stack
     * @return Current evaluation stack
     */
    EvaluationStack getEvaluationStack();

    /**
     * Get current closure context
     * @return Current closure context
     */
    ClosureContext getClosureContext();

    /**
     * Set new current evaluation stack
     * @param stack Parent stack of new current stack
     * @param context Current closure context
     */
    void setEvaluationStack(EvaluationStack stack, ClosureContext context);

    /**
     * Set current closure context
     * @param context Current closure context
     */
    void setClosureContext(ClosureContext context);

    /**
     * Returns from current stack to parent stack
     */
    void leaveCurrentEvaluationStack();

    /**
     * Returns from current stack to parent stack
     */
    double popResult();
}
