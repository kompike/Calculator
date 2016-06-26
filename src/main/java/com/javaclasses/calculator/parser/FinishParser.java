package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.exception.EvaluationException;

/**
 * Parser implementation for the end of expression
 */
public class FinishParser implements Parser{

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        return () -> {

            if (inputContext.hasMoreToParse()) {

                throw new IllegalStateException("Input expression still has elements to parse");
            } else if(outputContext.getEvaluationStack().getParent() != null) {

                throw new IllegalStateException("Closing bracket missing");

            } else {

                outputContext.getEvaluationStack()
                        .popAllOperators();
            }
        };
    }

}
