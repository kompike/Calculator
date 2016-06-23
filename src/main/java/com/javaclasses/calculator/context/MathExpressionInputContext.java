package com.javaclasses.calculator.context;

/**
 * Implementation for {@link InputContext} interface for
 * math expressions
 */
public class MathExpressionInputContext implements InputContext {

    private String expression;
    private int position;

    public MathExpressionInputContext(String expression) {
        this.expression = expression;
    }

    @Override
    public int getCurrentPosition() {
        return position;
    }

    @Override
    public void incrementPosition(int value) {
        position += value;
    }

    @Override
    public String getRemainingExpression() {
        return expression.substring(position);
    }
}
