package com.javaclasses.calculator.context;

import com.javaclasses.calculator.operator.BinaryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implementation for {@link OutputContext} interface for
 * math expressions
 */
public class MathExpressionOutputContext implements OutputContext {

    private final Logger log = LoggerFactory.getLogger(MathExpressionOutputContext.class);

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<>();

    @Override
    public double popResult() {

        if (operandStack.size() == 1) {

            if (log.isDebugEnabled()) {
                log.debug("Expression result equals: " + operandStack.peek());
            }

            return operandStack.pop();
        }

        if (log.isErrorEnabled()) {
            log.error("Operands stack is empty.");
        }

        throw new IllegalStateException("Operands stack is empty.");
    }

    @Override
    public void addOperand(Double operand) {
        operandStack.push(operand);

        if (log.isDebugEnabled()) {
            log.debug("Operand succesfully added to the stack: " + operand);
        }
    }

    @Override
    public void addOperator(BinaryOperator operator) {
        operatorStack.push(operator);
    }

}
