package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.operator.BinaryOperator;
import com.javaclasses.calculator.operator.BinaryOperatorFactory;

import java.util.Set;

/**
 * Parser implementation for binary operators
 */
public class BinaryOperatorParser implements Parser {

    private final BinaryOperatorFactory factory = new BinaryOperatorFactory();

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        final Set<String> operatorsRepresentations =
                factory.getAllRepresentations();

        for (String representation : operatorsRepresentations) {
            if (expression.startsWith(representation)) {

                final BinaryOperator operator = factory.getBinaryOperator(representation);
                inputContext.incrementPosition(representation.length());

                return new EvaluationContext() {
                    @Override
                    public void execute() {
                        outputContext.getEvaluationStack()
                                .addOperator(operator);
                    }
                };
            }
        }

        return null;

    }

}
