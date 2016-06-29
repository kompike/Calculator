package com.javaclasses.calculator.impl.operator.unary;

import com.javaclasses.calculator.impl.UnaryOperator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.javaclasses.calculator.impl.UnaryOperator.Notation.*;
import static com.javaclasses.calculator.impl.UnaryOperator.Notation.PREFIX;

/**
 * Factory of unary operators
 */
public class UnaryOperatorFactory {

    private final Map<String, UnaryOperator> operators =
            new HashMap<String, UnaryOperator>(){{

                put("+", new UnaryPlusOperator(PREFIX));
                put("-", new UnaryMinusOperator(PREFIX));
                put("!", new Factorial(POSTFIX));
            }};

    /**
     * Get unary operator according to its string representation
     * @param representation String representation of unary operator
     * @return Unary operator instance
     */
    public UnaryOperator getUnaryOperator(String representation) {
        return operators.get(representation);
    }

    public Set<String> getAllRepresentations() {
        return operators.keySet();
    }
}
