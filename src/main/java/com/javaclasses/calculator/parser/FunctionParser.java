package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.function.Function;
import com.javaclasses.calculator.function.FunctionFactory;

import java.util.Set;

/**
 * Parser implementation for math functions
 */
public class FunctionParser implements Parser {

    private final FunctionFactory factory = new FunctionFactory();

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        final Set<String> functionsRepresentations =
                factory.getAllRepresentations();

        for (String representation : functionsRepresentations) {
            if (expression.startsWith(representation)) {

                final Function function = factory.getFunction(representation);
                inputContext.incrementPosition(representation.length());

                return new EvaluationContext() {
                    @Override
                    public void execute() {


                    }
                };
            }
        }

        return null;
    }

}
