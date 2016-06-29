package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for the end of expression
 */
public class FinishParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(FinishParser.class);

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        return (OutputContext outputContext) -> {

            if (inputContext.hasMoreToParse()) {

                if (log.isDebugEnabled()) {
                    log.debug("Input expression still has elements to parse");
                }

                throw new IncorrectExpressionException(
                        "Input expression still has elements to parse after position: ",
                        inputContext.getCurrentPosition());

            } else if(outputContext.getEvaluationStack().getParent() != null) {

                if (log.isDebugEnabled()) {
                    log.debug("Closing bracket missing");
                }

                throw new IncorrectExpressionException("Closing bracket missing at position:",
                        inputContext.getCurrentPosition());

            } else {

                outputContext.getEvaluationStack()
                        .popAllBinaryOperators();
            }
        };
    }

}
