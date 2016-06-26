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
     * Set new current evaluation stack
     * @param stack Parent stack of new current stack
     */
    void setEvaluationStack(EvaluationStack stack);

    /**
     * Returns from current stack to parent stack
     */
    void leaveCurrentEvaluationStack();

    /**
     * Returns from current stack to parent stack
     */
    double popResult();
}
