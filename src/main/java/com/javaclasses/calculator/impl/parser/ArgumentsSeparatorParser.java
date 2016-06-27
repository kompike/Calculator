package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for arguments separator
 */
public class ArgumentsSeparatorParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(ArgumentsSeparatorParser.class);

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        if (expression.startsWith(",")) {

            inputContext.incrementPosition(1);

            return (OutputContext outputContext) -> {

                if (log.isDebugEnabled()) {
                    log.debug("Checking if closure context does not equals null: " +
                            (outputContext.getEvaluationStack().getContextClosure() == null));
                }

                if (outputContext.getEvaluationStack().getContextClosure() == null ||
                        !outputContext.getEvaluationStack().getContextClosure().isInFunction()) {

                    throw new IncorrectExpressionException("It is not allowed to use comma beyond function: " +
                            inputContext.getCurrentPosition(), inputContext.getCurrentPosition());
                }

                outputContext.getEvaluationStack().popAllBinaryOperators();
            };
        }

        return null;
    }

}
