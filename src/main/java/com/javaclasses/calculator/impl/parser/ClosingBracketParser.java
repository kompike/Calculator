package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for closing bracket
 */
public class ClosingBracketParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(ClosingBracketParser.class);

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        if (expression.startsWith(")")) {

            inputContext.incrementPosition(1);

            return OutputContext::leaveCurrentEvaluationStack;
        }

        return null;
    }

}
