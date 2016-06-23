package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;

/**
 * Parser implementation for the end of expression
 */
public class FinishParser implements Parser{

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        return new EvaluationContext() {
            @Override
            public void execute() {
                if (!inputContext.hasMoreToParse()) {
                    outputContext.getEvaluationStack()
                            .popAllOperators();
                } else {
                    throw new IllegalStateException("Input expression still has elements to parse");
                }
            }
        };
    }

}
