package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.UnaryOperator;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import com.javaclasses.calculator.impl.operator.unary.UnaryOperatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Parser implementation for unary operator
 */
public class UnaryOperatorParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(UnaryOperatorParser.class);

    private final UnaryOperatorFactory factory = new UnaryOperatorFactory();

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

                final UnaryOperator operator = factory.getUnaryOperator(representation);

                if (log.isDebugEnabled()) {
                    log.debug("Unary operator found: " + operator.getClass().getSimpleName());
                }

                inputContext.incrementPosition(representation.length());

                return (OutputContext outputContext) -> outputContext.getEvaluationStack()
                        .addUnaryOperator(operator);
            }
        }

        return null;

    }

}
