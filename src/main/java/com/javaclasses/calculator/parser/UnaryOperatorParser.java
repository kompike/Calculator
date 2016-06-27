package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser implementation for unary operator
 */
public class UnaryOperatorParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(UnaryOperatorParser.class);

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        final String unaryOperatorPattern = "^[+-]";

        final Pattern pattern = Pattern.compile(unaryOperatorPattern);
        final Matcher matcher = pattern.matcher(expression);

        if (!matcher.find()) {

            if (log.isDebugEnabled()) {
                log.debug("Parsed expression does not start with current pattern");
            }

            return null;
        }

        final String result = matcher.group();

        if (log.isDebugEnabled()) {
            log.debug("Parsed result equals: " + result);
        }

        inputContext.incrementPosition(1);

        return new EvaluationContext() {
            @Override
            public void execute() {

                if (result.equals("-")) {

                    outputContext.getEvaluationStack().setUnaryState(true);

                    if (log.isDebugEnabled()) {
                        log.debug("Unary state changed: " +
                                outputContext.getEvaluationStack().isInUnaryState());
                    }
                }

            }
        };

    }

}
