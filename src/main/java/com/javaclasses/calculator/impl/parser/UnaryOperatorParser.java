package com.javaclasses.calculator.impl.parser;

import com.javaclasses.calculator.impl.EvaluationCommand;
import com.javaclasses.calculator.impl.Parser;
import com.javaclasses.calculator.impl.context.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser implementation for unary operator
 */
public class UnaryOperatorParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(UnaryOperatorParser.class);

    @Override
    public EvaluationCommand parse(InputContext inputContext) {

        return null;

    }

}
