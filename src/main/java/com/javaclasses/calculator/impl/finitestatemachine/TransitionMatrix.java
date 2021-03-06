package com.javaclasses.calculator.impl.finitestatemachine;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.javaclasses.calculator.impl.finitestatemachine.State.*;

/**
 * Representation of finite-state machine
 * transitions matrix according to all possible states
 */
public class TransitionMatrix {

    /**
     * Map of possible transitions for each state
     */
    private final Map<State, Set<State>> possibleTransitions =
            new HashMap<State, Set<State>>(){{

                put(START, EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION, PREFIX_UNARY_OPERATOR));
                put(NUMBER, EnumSet.of(BINARY_OPERATOR, CLOSING_BRACKET, ARGUMENTS_SEPARATOR,
                        POSTFIX_UNARY_OPERATOR, FINISH));
                put(BINARY_OPERATOR, EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION));
                put(OPENING_BRACKET, EnumSet.of(NUMBER, OPENING_BRACKET, CLOSING_BRACKET,
                        FUNCTION, PREFIX_UNARY_OPERATOR));
                put(CLOSING_BRACKET, EnumSet.of(BINARY_OPERATOR, ARGUMENTS_SEPARATOR, CLOSING_BRACKET,
                        POSTFIX_UNARY_OPERATOR, FINISH));
                put(FUNCTION, EnumSet.of(OPENING_BRACKET));
                put(ARGUMENTS_SEPARATOR, EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION, PREFIX_UNARY_OPERATOR));
                put(PREFIX_UNARY_OPERATOR, EnumSet.of(NUMBER, OPENING_BRACKET, FUNCTION));
                put(POSTFIX_UNARY_OPERATOR, EnumSet.of(BINARY_OPERATOR, ARGUMENTS_SEPARATOR, CLOSING_BRACKET, FINISH));
                put(FINISH, EnumSet.noneOf(State.class));

            }};

    /**
     * Method returns all possible transitions for given state
     * @param state Current finite-state machine state
     * @return Set of possible transitions for given state
     */
    public Set<State> getPossibleTransitions(State state) {
        return possibleTransitions.get(state);
    }

    /**
     * Returns finite-state machine start state
     * @return start state
     */
    public State getStartState() {
        return START;
    }

    /**
     * Returns finite-state machine finish state
     * @return finish state
     */
    public State getFinishState() {
        return FINISH;
    }
}
