package com.javaclasses.calculator.finitestatemachine;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.javaclasses.calculator.finitestatemachine.State.FINISH;
import static com.javaclasses.calculator.finitestatemachine.State.START;

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

                put(START, EnumSet.of(FINISH));
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