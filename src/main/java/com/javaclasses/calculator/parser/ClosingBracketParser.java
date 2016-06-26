package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for closing bracket
 */
public class ClosingBracketParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(ClosingBracketParser.class);

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        if (expression.startsWith(")")) {

            inputContext.incrementPosition(1);

            return new EvaluationContext() {
                @Override
                public void execute() {

                    outputContext.leaveCurrentEvaluationStack();
                }
            };
        }

        return null;
    }

}
