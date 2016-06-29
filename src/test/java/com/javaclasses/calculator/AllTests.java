package com.javaclasses.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BinaryOperatorTest.class, IncorrectExpressionTest.class,
        FunctionTest.class, FunctionalTest.class,
        NumberEvaluationTest.class, UnaryOperatorTest.class})
public class AllTests {
}
