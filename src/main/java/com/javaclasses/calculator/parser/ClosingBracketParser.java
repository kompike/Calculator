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

        final String expression = inputContext.getRemainingExpression();

        if (expression.startsWith(")")) {

            inputContext.incrementPosition(1);

            return new EvaluationContext() {
                @Override
                public void execute() {

                    outputContext.getEvaluationStack().popAllOperators();

                    final double result = outputContext.getEvaluationStack().popResult();

                    outputContext.leaveCurrentEvaluationStack();

                    outputContext.getEvaluationStack().getOperandStack().push(result);
                }
            };
        }

        return null;
    }

}
