package com.javaclasses.calculator.context;

import com.javaclasses.calculator.operator.BinaryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Operates operand and operator stacks for keeping
 * math expression parsing data
 */
public class EvaluationStack {

    private final Logger log = LoggerFactory.getLogger(EvaluationStack.class);

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<>();

    private EvaluationStack parent;

    public EvaluationStack() {
        parent = null;
    }

    public EvaluationStack(EvaluationStack parent) {
        this.parent = parent;
    }

    public EvaluationStack getParent() {
        return parent;
    }

    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<BinaryOperator> getOperatorStack() {
        return operatorStack;
    }

    /**
     * Pop the last element from stack of operands
     * @return Result of expression
     */
    public double popResult() {

        if (getOperandStack().size() == 1) {

            if (log.isDebugEnabled()) {
                log.debug("Expression result equals: " + getOperandStack().peek());
            }

            return getOperandStack().pop();
        }

        if (log.isErrorEnabled()) {
            log.error("Operands stack is empty.");
        }

        throw new IllegalStateException("Operands stack is empty.");
    }

    /**
     * Adds new operand to output context
     * @param operand Added operand
     */
    public void addOperand(Double operand) {
        getOperandStack().push(operand);

        if (log.isDebugEnabled()) {
            log.debug("Operand successfully added to the stack: " + operand);
        }
    }

    /**
     * Adds new operator to output context
     * @param operator Added operator
     */
    public void addOperator(BinaryOperator operator) {

        if (log.isDebugEnabled()) {
            log.debug("Checking is operatorStack is empty: " + getOperatorStack().isEmpty());
        }

        if (!getOperatorStack().isEmpty()) {

            final BinaryOperator lastOperator = getOperatorStack().peek();

            if (log.isDebugEnabled()) {
                log.debug("Last operator returned from the stack: " +
                        lastOperator.getClass().getSimpleName());
            }

            if (lastOperator.compareTo(operator) > 0) {

                popOperator();

            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Operator added to the stack: " + operator.getClass().getSimpleName());
        }

        getOperatorStack().push(operator);
    }

    /**
     * Pops remained operators from operator's stack
     */
    public void popAllOperators() {

        while (!getOperatorStack().isEmpty()) {

            popOperator();
        }
    }

    private void popOperator() {

        final BinaryOperator operator = getOperatorStack().pop();

        if (log.isDebugEnabled()) {
            log.debug("Operator returned from the stack: " + operator.getClass().getSimpleName());
        }

        final double rightOperand = getOperandStack().pop();

        if (log.isDebugEnabled()) {
            log.debug("Right operand returned from the stack: " + rightOperand);
        }

        final double leftOperand = getOperandStack().pop();

        if (log.isDebugEnabled()) {
            log.debug("Left operand returned from the stack: " + leftOperand);
        }

        getOperandStack().push(operator.execute(leftOperand, rightOperand));

        if (log.isDebugEnabled()) {
            log.debug("Operand executed and added to the stack: " + getOperandStack().peek());
        }
    }
}
