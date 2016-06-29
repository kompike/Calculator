package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.context.ContextClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.javaclasses.calculator.impl.UnaryOperator.Notation.POSTFIX;

/**
 * Operates operand and operator stacks for keeping
 * math expression parsing data
 */
public class EvaluationStack {

    private final Logger log = LoggerFactory.getLogger(EvaluationStack.class);

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> binaryOperatorStack = new ArrayDeque<>();
    private final Deque<UnaryOperator> unaryOperatorStack = new ArrayDeque<>();

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
     *
     * @return Result of expression
     */
    public double popResult() throws IncorrectExpressionException {

        return operandStack.pop();
    }

    /**
     * Adds new operand to output context
     *
     * @param operand Added operand
     */
    public void pushOperand(Double operand) {

        operandStack.push(operand);

        popUnaryOperator();

        if (log.isDebugEnabled()) {
            log.debug("Operand successfully added to the stack: " + operand);
        }
    }

    /**
     * Adds new operator to output context
     * @param operator Added operator
     */
    public void pushBinaryOperator(BinaryOperator operator) throws IncorrectExpressionException {

        if (log.isDebugEnabled()) {
            log.debug("Checking is binaryOperatorStack is empty: " + binaryOperatorStack.isEmpty());
        }

        if (!binaryOperatorStack.isEmpty()) {

            final BinaryOperator lastOperator = binaryOperatorStack.peek();

            if (log.isDebugEnabled()) {
                log.debug("Last operator returned from the stack: " +
                        lastOperator.getClass().getSimpleName());
            }

            if (lastOperator.compareTo(operator) > 0) {

                popBinaryOperator();

            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Operator added to the stack: " + operator.getClass().getSimpleName());
        }

        binaryOperatorStack.push(operator);
    }

    /**
     * Pops remained operators from operator's stack
     */
    public void popAllBinaryOperators() throws IncorrectExpressionException {

        while (!binaryOperatorStack.isEmpty()) {

            popBinaryOperator();
        }
    }

    /**
     * Saves remained operands from operator's stack
     * to the list
     *
     * @return List of operands
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
     * Saves remained operands to the list, but not removes them from operator's stack
     *
     * @return List of operands
     */
    public List<Double> peekAllOperands() {

        if (!operandStack.isEmpty()) {

            return Arrays.asList(operandStack.toArray(new Double[operandStack.size()]));
        }

        return Collections.emptyList();
    }

    public void pushUnaryOperator(UnaryOperator operator) {

        if (log.isDebugEnabled()) {
            log.debug("Checking if unary operator is postfix: " +
                    (operator.getNotation() == POSTFIX));
        }

        if (operator.getNotation() == POSTFIX) {

            final double operand = operandStack.pop();

            if (log.isDebugEnabled()) {
                log.debug("Operand value before unary operator execution: " +
                        (operand));
            }

            pushOperand(operator.execute(operand));

            if (log.isDebugEnabled()) {
                log.debug("Operand value after unary operator execution: " +
                        (operandStack.peek()));
            }

        } else {

            if (log.isDebugEnabled()) {
                log.debug("Unary operator added to the stack: " +
                        (operator.getClass().getSimpleName()));
            }

            unaryOperatorStack.push(operator);
        }
    }

    /**
     * Get last operator from stack and executes it
     */
    private void popBinaryOperator() throws IncorrectExpressionException {

        final BinaryOperator operator = binaryOperatorStack.pop();

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

        pushOperand(operator.execute(leftOperand, rightOperand));

        if (log.isDebugEnabled()) {
            log.debug("Operand executed and added to the stack: " + operandStack.peek());
        }
    }

    private void popUnaryOperator() {

        if (!unaryOperatorStack.isEmpty()) {

            final UnaryOperator unaryOperator = unaryOperatorStack.pop();

            if (log.isDebugEnabled()) {
                log.debug("Unary operator poped from stack: " +
                        (unaryOperator.getClass().getSimpleName()));
            }

            final Double operand = operandStack.pop();

            if (log.isDebugEnabled()) {
                log.debug("Operand poped from operands stack: " +
                        (operand));
            }

            final double result = unaryOperator.execute(operand);

            if (log.isDebugEnabled()) {
                log.debug("Result after unary operator execution: " +
                        (result));
            }

            operandStack.push(result);

            if (log.isDebugEnabled()) {
                log.debug("Unary operators stack size: " +
                        (unaryOperatorStack.size()));
            }
        }
    }
}
