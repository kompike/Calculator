package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;

/**
 * Parser implementation for closing bracket
 */
public class ClosingBracketParser implements Parser {

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {
        return new EvaluationContext() {
            @Override
            public void execute() {

            }
        };
    }

}
