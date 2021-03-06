package com.javaclasses.calculator.impl.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation for {@link InputContext} interface for
 * math expressions
 */
public class MathExpressionInputContext implements InputContext {

    private final Logger log = LoggerFactory.getLogger(MathExpressionInputContext.class);

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

        if (log.isDebugEnabled()) {
            log.debug("Incrementing position with value: " + value);
        }

        position += value;
    }

    @Override
    public String getRemainingExpression() {

        if (hasMoreToParse()) {

            while (expression.charAt(position) == ' ') {

                if (log.isDebugEnabled()) {
                    log.debug("Space found, position incremented by 1.");
                }

                position += 1;
            }

        }

        return expression.substring(position);
    }

    @Override
    public boolean hasMoreToParse() {
        return position < expression.length();
    }
}
