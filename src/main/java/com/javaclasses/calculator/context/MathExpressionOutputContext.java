package com.javaclasses.calculator.context;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implementation for {@link OutputContext} interface for
 * math expressions
 */
public class MathExpressionOutputContext implements OutputContext {

    private final Deque<Double> operandStack = new ArrayDeque<>();

    @Override
    public double popResult() {

        if (operandStack.size() == 1) {
            return operandStack.pop();
        }

        throw new IllegalStateException("Operands stack is empty.");
    }

    @Override
    public void addOperand(Double operand) {
        operandStack.push(operand);
    }

}
