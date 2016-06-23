package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser implementation for integer and decimal numbers
 */
public class NumberParser implements Parser {

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        final String numberPattern = "^\\d+\\.?\\d*";

        final Pattern pattern = Pattern.compile(numberPattern);
        final Matcher matcher = pattern.matcher(expression);

        if (!matcher.find() || matcher.group().endsWith(".")) {
            return null;
        }

        final String result = matcher.group();

        inputContext.incrementPosition(result.length());

        return new EvaluationContext() {
            @Override
            public void execute() {
                outputContext.addOperand(Double.valueOf(result));
            }
        };
    }

}
