package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.FunctionContextClosure;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import com.javaclasses.calculator.impl.Function;
import com.javaclasses.calculator.impl.function.FunctionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Parser implementation for math functions
 */
public class FunctionParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(FunctionParser.class);

    private final FunctionFactory factory = new FunctionFactory();

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        final Set<String> functionsRepresentations =
                factory.getAllRepresentations();

        for (String representation : functionsRepresentations) {

            if (expression.startsWith(representation)) {

                final Function function = factory.getFunction(representation);

                if (log.isDebugEnabled()) {
                    log.debug("Closure function: " + function.getClass().getSimpleName());
                }

                inputContext.incrementPosition(representation.length());

                return (OutputContext outputContext) -> outputContext.setContextClosure(new FunctionContextClosure(function));
            }
        }

        return null;
    }

}
