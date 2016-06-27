package com.javaclasses.calculator.impl.context;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.EvaluationStack;

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
    ContextClosure getContextClosure();

    /**
     * Set new current evaluation stack
     * @param stack Parent stack of new current stack
     * @param context Current closure context
     */
    void setEvaluationStack(EvaluationStack stack, ContextClosure context);

    /**
     * Set current closure context
     * @param context Current closure context
     */
    void setContextClosure(ContextClosure context);

    /**
     * Returns from current stack to parent stack
     */
    void leaveCurrentEvaluationStack() throws IncorrectExpressionException;

    /**
     * Pop the last element from stack of operands
     * @return Result of expression
     */
    double popResult() throws IncorrectExpressionException;
}
