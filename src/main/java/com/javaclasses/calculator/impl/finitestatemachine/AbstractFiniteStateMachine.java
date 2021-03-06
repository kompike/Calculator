package com.javaclasses.calculator.impl.finitestatemachine;

import com.javaclasses.calculator.impl.context.InputContext;
import com.javaclasses.calculator.impl.context.OutputContext;
import com.javaclasses.calculator.IncorrectExpressionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Abstract representation of Finite-state machine
 */
public abstract class AbstractFiniteStateMachine {

    private final Logger log = LoggerFactory.
            getLogger(AbstractFiniteStateMachine.class);

    private final TransitionMatrix transitionMatrix =
            new TransitionMatrix();

    private final StateRecognizer recognizer = new StateRecognizer();

    /**
     * Run through all states from input
     * context data
     * @param inputContext Contains the data to run through
     * @param outputContext Keeps the result of each state analysis
     */
    public void run(InputContext inputContext, OutputContext outputContext)
            throws IncorrectExpressionException {

        if (log.isInfoEnabled()) {
            log.info("Entering run method...");
        }

        State state = transitionMatrix.getStartState();

        while (state != transitionMatrix.getFinishState()) {

            if (log.isInfoEnabled()) {
                log.info("Moving to the next state from " + state.toString());
            }

            final State nextState = moveToNextState(state, inputContext, outputContext);

            if (nextState == null) {

                if (log.isWarnEnabled()) {
                    log.warn("Can not find possible next state for " +
                            state.toString());
                }

                deadlock(inputContext, outputContext);
                break;
            }

            if (log.isInfoEnabled()) {
                log.info("Current state is " + nextState.toString());
            }

            state = nextState;
        }

        log.info("Leaving run method");
    }

    /**
     * Moves finite-state machine to the next state
     * @param state Current state
     * @param inputContext Contains input data
     * @param outputContext Keeps the result of each state analysis
     * @return Next state or null if there is no possible state to move
     */
    private State moveToNextState(State state, InputContext inputContext,
                                  OutputContext outputContext) throws IncorrectExpressionException {

        final Set<State> possibleTransitions =
                transitionMatrix.getPossibleTransitions(state);

        for (State possibleState : possibleTransitions) {

            if (log.isDebugEnabled()) {
                log.debug("Accepting possible state: " + possibleState.toString());
            }

            if (recognizer.accept(possibleState, inputContext, outputContext)) {

                if (log.isDebugEnabled()) {
                    log.debug("State accepted: " + possibleState.toString());
                }

                return possibleState;
            }

        }

        if (log.isDebugEnabled()) {
            log.debug("Acceptable state not found.");
        }

        return null;
    }

    /**
     * Method is called in case there is no possible state to move
     * @param inputContext Contains input data
     * @param outputContext Keeps the result of each state analysis
     * @throws IncorrectExpressionException In case of errors in input context
     */
    protected abstract void deadlock(InputContext inputContext, OutputContext outputContext)
            throws IncorrectExpressionException;

}
