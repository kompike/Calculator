package com.javaclasses.calculator.parser;

import com.javaclasses.calculator.context.EvaluationContext;
import com.javaclasses.calculator.context.InputContext;
import com.javaclasses.calculator.context.OutputContext;

/**
 * Basic interface for token parsers from input context
 */
public interface Parser {

    /**
     * Parse given sequence from input context and
     * set obtained result into output context
     * @param inputContext Context with sequence to parse
     * @param outputContext Context which keeps the result
     * @return EvaluationContext instance depending on
     * parsed sequence
     */
    EvaluationContext parse(InputContext inputContext, OutputContext outputContext);
}
