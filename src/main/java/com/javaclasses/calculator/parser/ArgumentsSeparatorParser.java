package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;

/**
 * Parser implementation for arguments separator
 */
public class ArgumentsSeparatorParser implements Parser {

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (expression.startsWith(",")) {

            inputContext.incrementPosition(1);

            return () -> outputContext.getEvaluationStack().popAllOperators();
        }

        return null;
    }

}
