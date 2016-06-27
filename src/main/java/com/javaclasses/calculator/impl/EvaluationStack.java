package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.context.ContextClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Operates operand and operator stacks for keeping
 * math expression parsing data
 */
public class EvaluationStack {

    private final Logger log = LoggerFactory.getLogger(EvaluationStack.class);

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<>();

    private final EvaluationStack parent;
    private final ContextClosure context;

    public EvaluationStack() {
        parent = null;
        context = null;
    }

    public EvaluationStack(EvaluationStack parent, ContextClosure context) {
        this.parent = parent;
        this.context = context;
    }

    public EvaluationStack getParent() {
        return parent;
    }

    public ContextClosure getContextClosure() {
        return context;
    }

    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    /**
     * Pop the last element from stack of operands
     * @return Result of expression
     */
    public double popResult() throws IncorrectExpressionException {

        if (operandStack.size() != 1) {

            final String message;

            if (operandStack.size() > 1) {
                message = "There is more than one operand left.";
            } else {
                message = "No operands left";
            }

            if (log.isErrorEnabled()) {
                log.error(message);
            }

            throw new IncorrectExpressionException(message);

        } else {

            if (log.isDebugEnabled()) {
                log.debug("Expression result equals: " + operandStack.peek());
            }

            return operandStack.pop();
        }
    }

    /**
     * Adds new operand to output context
     * @param operand Added operand
     */
    public void addOperand(Double operand) {

        operandStack.push(operand);

        if (log.isDebugEnabled()) {
            log.debug("Operand successfully added to the stack: " + operand);
        }
    }

    /**
     * Adds new operator to output context
     * @param operator Added operator
     */
    public void addOperator(BinaryOperator operator) throws IncorrectExpressionException {

        if (log.isDebugEnabled()) {
            log.debug("Checking is operatorStack is empty: " + operatorStack.isEmpty());
        }

        if (!operatorStack.isEmpty()) {

            final BinaryOperator lastOperator = operatorStack.peek();

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

        operatorStack.push(operator);
    }

    /**
     * Pops remained operators from operator's stack
     */
    public void popAllOperators() throws IncorrectExpressionException {

        while (!operatorStack.isEmpty()) {

            popOperator();
        }
    }

    /**
     * Saves remained operands from operator's stack
     * to the list
     */
    public List<Double> popAllOperands() {

        final List<Double> operands = new ArrayList<>();

        while (!operandStack.isEmpty()) {

            if (log.isDebugEnabled()) {
                log.debug("Next element to be added: " + operandStack.peek());
            }

            operands.add(operandStack.pop());
        }

        return operands;
    }

    /**
     * Get last operator from stack and executes it
     */
    private void popOperator() throws IncorrectExpressionException {

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
