package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.exception.EvaluationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for the end of expression
 */
public class FinishParser implements Parser{

    private final Logger log = LoggerFactory.getLogger(FinishParser.class);

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        return () -> {

            if (inputContext.hasMoreToParse()) {

                if (log.isDebugEnabled()) {
                    log.debug("Input expression still has elements to parse");
                }

                throw new IllegalStateException("Input expression still has elements to parse");
            } else if(outputContext.getEvaluationStack().getParent() != null) {

                if (log.isDebugEnabled()) {
                    log.debug("Closing bracket missing");
                }

                throw new IllegalStateException("Closing bracket missing");

            } else {

                outputContext.getEvaluationStack()
                        .popAllOperators();
            }
        };
    }

}
