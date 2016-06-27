package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import com.javaclasses.calculator.impl.BinaryOperator;
import com.javaclasses.calculator.impl.operator.BinaryOperatorFactory;
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
    public EvaluationCommand parse(InputContext inputContext) {

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

                return (OutputContext outputContext) -> outputContext.getEvaluationStack()
                        .addOperator(operator);
            }
        }

        return null;

    }

}
