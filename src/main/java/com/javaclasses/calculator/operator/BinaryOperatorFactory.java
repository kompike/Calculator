package com.javaclasses.calculator.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Factory of available binary operators
 */
public class BinaryOperatorFactory {

    private final Map<String, BinaryOperator> operators =
            new HashMap<String, BinaryOperator>(){{

                put("+", new Plus());
                put("-", new Minus());
                put("*", new Multiply());
                put("/", new Divide());
                put("^", new Power());

            }};

    /**
     * Get binary operator according to it string representation
     * @param representation String representation of binary operator
     * @return Binary operator instance
     */
    public BinaryOperator getBinaryOperator(String representation) {
        return operators.get(representation);
    }

    public Set<String> getAllRepresentations() {
        return operators.keySet();
    }
}
