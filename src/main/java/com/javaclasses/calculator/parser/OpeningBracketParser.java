package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.ClosureContext;
import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for opening bracket
 */
public class OpeningBracketParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(OpeningBracketParser.class);

    @Override
    public EvaluationContext parse(InputContext inputContext, OutputContext outputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        if (expression.startsWith("(")) {

            inputContext.incrementPosition(1);

            return () -> {

                ClosureContext context = outputContext.getClosureContext();

                if (log.isDebugEnabled()) {
                    log.debug("ClosureContext is default: " + (context == null));
                }

                if (context == null) {

                    context = () -> {

                        outputContext.getEvaluationStack().popAllOperators();

                        final double result;

                        if (log.isDebugEnabled()) {
                            log.debug("Checking if context is in unary state: " +
                                    outputContext.getEvaluationStack().getParent().isInUnaryState());
                        }

                        if (outputContext.getEvaluationStack().getParent().isInUnaryState()) {

                            result = outputContext.popResult() * (-1);
                            outputContext.getEvaluationStack().getParent().setUnaryState(false);
                        } else {

                            result = outputContext.popResult();
                        }

                        if (log.isDebugEnabled()) {
                            log.debug("Default closureContext result: " + result);
                        }

                        outputContext.getEvaluationStack().getOperandStack().push(result);

                    };
                }

                outputContext.setEvaluationStack(outputContext.getEvaluationStack(), context);

            };
        }

        return null;
    }

}
