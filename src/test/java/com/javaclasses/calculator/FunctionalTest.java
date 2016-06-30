package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathExpressionCalculatorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

/**
 * Functional test for all groups of tokens
 */
public class FunctionalTest {

    public static final double EXPECTED_RESULT = 2d;

    private static final String MATH_EXPRESSION =
            "2*(sum(1,2,max(1,2,3)) - min(sum(4,min(5,6),7),2+8,2^2) + 1) / 3";

    private final MathExpressionCalculator calculator =
            new MathExpressionCalculatorImpl();


    @Test
    public void testMathExpressionEvaluation() throws IncorrectExpressionException {

        assertEquals("Evaluated result does not equal expected result of current expression.",
                EXPECTED_RESULT, calculator.evaluate(MATH_EXPRESSION), 0.0001d );

    }

    @Test
    public void testMathCalculatorStateless() throws Exception {

        final int threadPoolSize = 20;

        final CountDownLatch calculationStartLatch = new CountDownLatch(threadPoolSize);
        final CountDownLatch calculationFinishLatch = new CountDownLatch(threadPoolSize);

        final ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        final List<Future<Double>> futureList = new ArrayList<>();

        for (int i = 0; i < threadPoolSize; i++) {

            final Future<Double> future = executorService.submit(() -> {

                calculationStartLatch.countDown();
                calculationStartLatch.await();

                final double result = calculator.evaluate(MATH_EXPRESSION);

                calculationFinishLatch.countDown();

                return result;
            });

            futureList.add(future);

        }

        calculationFinishLatch.await();

        for (Future<Double> future : futureList) {

            assertEquals("Evaluated result does not equal expected result of current expression",
                    EXPECTED_RESULT, future.get(), 0.0001d );
        }

    }
}
