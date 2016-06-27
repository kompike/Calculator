package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.function.Function;
import com.javaclasses.calculator.function.FunctionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Parser implementation for math functions
 */
public class FunctionParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(FunctionParser.class);

    private final FunctionFactory factory = new FunctionFactory();

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

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

                return () -> outputContext.setClosureContext(() -> {

                    final List<Double> functionArguments =
                            outputContext.getEvaluationStack().popAllOperands();

                    if (log.isDebugEnabled()) {
                        log.debug("Arguments list length: " + functionArguments.size());
                    }

                    final double result;

                    if (log.isDebugEnabled()) {
                        log.debug("Checking if context is in unary state: " +
                                outputContext.getEvaluationStack().getParent().isInUnaryState());
                    }

                    if (outputContext.getEvaluationStack().getParent().isInUnaryState()) {

                        result = function.execute(functionArguments.toArray
                                (new Double[functionArguments.size()])) * (-1);
                        outputContext.getEvaluationStack().getParent().setUnaryState(false);
                    } else {

                        result = function.execute(functionArguments.toArray
                                (new Double[functionArguments.size()]));
                    }

                    if (log.isDebugEnabled()) {
                        log.debug("Closure result: " + result);
                    }

                    outputContext.getEvaluationStack().getOperandStack().push(result);
                });
            }
        }

        return null;
    }

}
