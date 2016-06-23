package com.javaclasses.calculator.finitestatemachine;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;
import com.javaclasses.calculator.parser.Parser;

import java.util.HashMap;
import java.util.Map;

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

    }};

    /**
     * Indicated if possible state is accepted
     * @param state Possible state
     * @param inputContext Context with input data
     * @param outputContext Context which keeps parsing result
     * @return If given state is accepted
     */
    public boolean accept(State state,
                          InputContext inputContext, OutputContext outputContext) {

        final EvaluationContext context = stateParsers.get(state).parse(inputContext, outputContext);

        if (context != null) {
            context.execute();

            return true;
        }

        return false;
    }
}