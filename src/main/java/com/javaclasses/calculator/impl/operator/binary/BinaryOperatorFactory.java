package com.javaclasses.calculator.impl.operator.binary;

import com.javaclasses.calculator.impl.BinaryOperator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.javaclasses.calculator.impl.operator.binary.Priority.HIGH;
import static com.javaclasses.calculator.impl.operator.binary.Priority.LOW;
import static com.javaclasses.calculator.impl.operator.binary.Priority.MEDIUM;

/**
 * Factory of available binary operators
 */
public class BinaryOperatorFactory {

    private final Map<String, BinaryOperator> operators =
            new HashMap<String, BinaryOperator>(){{

                put("+", new Plus(LOW));
                put("-", new Minus(LOW));
                put("*", new Multiply(MEDIUM));
                put("/", new Divide(MEDIUM));
                put("^", new Power(HIGH));

            }};

    /**
     * Get binary operator according to its string representation
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
