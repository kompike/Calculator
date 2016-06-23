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
            log.debug("Operand successfully added to the stack: " + operand);
        }
    }

    @Override
    public void addOperator(BinaryOperator operator) {

        if (log.isDebugEnabled()) {
            log.debug("Checking is operatorStack is empty: " + operatorStack.isEmpty());
        }

        if (!operatorStack.isEmpty()) {

            final BinaryOperator lastOperator = operatorStack.peek();

            if (log.isDebugEnabled()) {
                log.debug("Last operator returned from the stack: " +
                        lastOperator.getClass().getSimpleName());
            }

            if (lastOperator.compareTo(operator) == 1) {

                popOperator();

            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Operator added to the stack: " + operator.getClass().getSimpleName());
        }

        operatorStack.push(operator);
    }

    @Override
    public void popAllOperators() {

        while (!operatorStack.isEmpty()) {

            popOperator();
        }
    }

    private void popOperator() {

        final BinaryOperator operator = operatorStack.pop();

        if (log.isDebugEnabled()) {
            log.debug("Operator returned from the stack: " + operator.getClass().getSimpleName());
        }

        final double rightOperand = operandStack.pop();

        if (log.isDebugEnabled()) {
            log.debug("Right operand returned from the stack: " + rightOperand);
        }

        final double leftOperand = operandStack.pop();

        if (log.isDebugEnabled()) {
            log.debug("Left operand returned from the stack: " + leftOperand);
        }

        operandStack.push(operator.execute(leftOperand, rightOperand));

        if (log.isDebugEnabled()) {
            log.debug("Operand executed and added to the stack: " + operandStack.peek());
        }
    }

}
