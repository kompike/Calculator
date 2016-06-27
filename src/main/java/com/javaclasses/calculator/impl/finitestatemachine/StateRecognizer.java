package com.javaclasses.calculator.impl.finitestatemachine;

import com.javaclasses.calculator.IncorrectExpressionException;
import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import com.javaclasses.calculator.impl.parser.*;

import java.util.HashMap;
import java.util.Map;

import static com.javaclasses.calculator.impl.finitestatemachine.State.*;

/**
 * Indicates whether or not given state is accepted
 * according to input data
 */
public class StateRecognizer {

    /**
     * Map of parsers for each possible
     * finite-state machine state
     */
    private final Map<State, Parser> stateParsers = new HashMap<State, Parser>(){{

        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());
        put(OPENING_BRACKET, new OpeningBracketParser());
        put(CLOSING_BRACKET, new ClosingBracketParser());
        put(FUNCTION, new FunctionParser());
        put(ARGUMENTS_SEPARATOR, new ArgumentsSeparatorParser());
        put(UNARY_OPERATOR, new UnaryOperatorParser());
        put(FINISH, new FinishParser());
    }};

    /**
     * Indicated if possible state is accepted
     * @param state Possible state
     * @param inputContext Context with input data
     * @param outputContext Context which keeps parsing result
     * @return If given state is accepted
     */
    public boolean accept(State state,
                          InputContext inputContext, OutputContext outputContext) throws IncorrectExpressionException {

        final EvaluationCommand context = stateParsers.get(state).parse(inputContext);

        if (context != null) {
            context.execute(outputContext);

            return true;
        }

        return false;
    }
}
