package com.javaclasses.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BinaryOperatorTest.class, ExceptionTest.class,
        FunctionTest.class, MathExpressionCalculatorTest.class,
        NumberEvaluationTest.class})
public class AllTests {
}
