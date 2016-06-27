package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser implementation for integer and decimal numbers
 */
public class NumberParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(NumberParser.class);

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        final String numberPattern = "^[+-]?\\d+\\.?\\d*";

        final Pattern pattern = Pattern.compile(numberPattern);
        final Matcher matcher = pattern.matcher(expression);

        if (!matcher.find() || matcher.group().endsWith(".")) {

            if (log.isDebugEnabled()) {
                log.debug("Parsed expression does not start with current pattern");
            }

            return null;
        }

        final String result = matcher.group();

        if (log.isDebugEnabled()) {
            log.debug("Parsed result equals: " + result);
        }

        inputContext.incrementPosition(result.length());

        return () -> outputContext.getEvaluationStack()
                .addOperand(Double.valueOf(result));
    }

}
