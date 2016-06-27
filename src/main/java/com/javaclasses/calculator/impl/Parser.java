package com.javaclasses.calculator.impl;

import com.javaclasses.calculator.impl.context.InputContext;

/**
 * Basic interface for token parsers from input context
 */
public interface Parser {

    /**
     * Parse given sequence from input context and
     * set obtained result into output context
     * @param inputContext Context with sequence to parse
     * @return EvaluationCommand instance depending on
     * parsed sequence
     */
    EvaluationCommand parse(InputContext inputContext);
}
