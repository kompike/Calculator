package com.javaclasses.calculator.function;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Factory of available math functions
 */
public class FunctionFactory {

    private final Map<String, Function> functions =
            new HashMap<String, Function>(){{
            }};

    /**
     * Get function according to its string representation
     * @param representation String representation of function
     * @return Function instance
     */
    public Function getFunction(String representation) {
        return functions.get(representation);
    }

    public Set<String> getAllRepresentations() {
        return functions.keySet();
    }
}
