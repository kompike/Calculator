package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.context.BracketsContextClosure;
import com.javaclasses.calculator.impl.context.ContextClosure;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for opening bracket
 */
public class OpeningBracketParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(OpeningBracketParser.class);

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        if (expression.startsWith("(")) {

            inputContext.incrementPosition(1);

            return (OutputContext outputContext) -> {

                ContextClosure context = outputContext.getContextClosure();

                if (log.isDebugEnabled()) {
                    log.debug("ContextClosure is default: " + (context == null));
                }

                if (context == null) {

                    context = new BracketsContextClosure();
                }

                outputContext.setEvaluationStack(outputContext.getEvaluationStack(), context);

            };
        }

        return null;
    }

}
