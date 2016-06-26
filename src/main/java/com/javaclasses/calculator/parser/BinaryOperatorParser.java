package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.operator.BinaryOperator;
import com.javaclasses.calculator.operator.BinaryOperatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Parser implementation for binary operators
 */
public class BinaryOperatorParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(BinaryOperatorParser.class);

    private final BinaryOperatorFactory factory = new BinaryOperatorFactory();

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        final Set<String> operatorsRepresentations =
                factory.getAllRepresentations();

        for (String representation : operatorsRepresentations) {
            if (expression.startsWith(representation)) {

                final BinaryOperator operator = factory.getBinaryOperator(representation);

                if (log.isDebugEnabled()) {
                    log.debug("Binary operator found: " + operator.getClass().getSimpleName());
                }

                inputContext.incrementPosition(representation.length());

                return () -> outputContext.getEvaluationStack()
                        .addOperator(operator);
            }
        }

        return null;

    }

}
