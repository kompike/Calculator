package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.Function;
import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.context.ContextClosure;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Parser implementation for closing bracket
 */
public class ClosingBracketParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(ClosingBracketParser.class);

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        final String expression = inputContext.getRemainingExpression();

        if (log.isDebugEnabled()) {
            log.debug("Parsing remaining expression: " + expression);
        }

        if (expression.startsWith(")")) {

            inputContext.incrementPosition(1);

            return outputContext -> {

                final ContextClosure currentClosure = outputContext.getEvaluationStack().getContextClosure();

                if (currentClosure != null) {

                    checkCurrentClosureForErrors(inputContext, outputContext,
                            currentClosure);
                }

                if (outputContext.getEvaluationStack().getParent() == null) {

                    throw new IncorrectExpressionException("Redundant closing bracket at position:",
                            inputContext.getCurrentPosition());
                }

                outputContext.leaveCurrentEvaluationStack();
            };
        }

        return null;
    }

    private void checkCurrentClosureForErrors(InputContext inputContext, OutputContext outputContext,
                                              ContextClosure currentClosure) throws IncorrectExpressionException {

        final Function currentFunction = currentClosure.getFunction();

        if (currentFunction == null) {

            if (outputContext.getEvaluationStack().getOperandStack().isEmpty()) {

                throw new IncorrectExpressionException("Found empty brackets at position:",
                        inputContext.getCurrentPosition());
            }

        } else {

            checkCurrentFunctionArgumentsNumber(inputContext, outputContext, currentFunction);
        }
    }

    private void checkCurrentFunctionArgumentsNumber(InputContext inputContext, OutputContext outputContext,
                                                     Function currentFunction) throws IncorrectExpressionException {

        if (log.isDebugEnabled()) {
            log.debug("Current function is: " + currentFunction.getClass().getSimpleName());
        }

        final List<Double> functionArguments =
                outputContext.getEvaluationStack().peekAllOperands();

        final int size = functionArguments.size();

        if (size < currentFunction.getMinimumArgumentsNumber() ||
                size > currentFunction.getMaximumArgumentsNumber()) {

            if (currentFunction.getMinimumArgumentsNumber() ==
                    currentFunction.getMaximumArgumentsNumber()) {

                throw new IncorrectExpressionException("Arguments number must be exactly " +
                        currentFunction.getMaximumArgumentsNumber() + " for the function at position:",
                        inputContext.getCurrentPosition());
            } else {

                throw new IncorrectExpressionException("Arguments number must be from " +
                        currentFunction.getMinimumArgumentsNumber() + " to " +
                        currentFunction.getMaximumArgumentsNumber() + " for the function at position:",
                        inputContext.getCurrentPosition());
            }

        }
    }

}
