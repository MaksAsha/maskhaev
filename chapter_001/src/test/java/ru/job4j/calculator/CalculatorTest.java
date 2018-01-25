package ru.job4j.calculator;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void initTest() {
        calc = new Calculator();
    }

    @Test
    public void testAddTwoArguments() throws Exception {
        calc.add(1L, 1L);
        double result = calc.getResult();
        double expected = 2L;
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testSubtractTwoArguments() throws Exception {
        calc.subtract(5L, 10L);
        double result = calc.getResult();
        double expected = -5L;
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testDivTwoArguments() throws Exception {
        calc.div(5L, 10L);
        double result = calc.getResult();
        double expected = 0.5;
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testMultiplyTwoArguments() throws Exception {
        calc.multiply(2L, 2L);
        double result = calc.getResult();
        double expected = 4L;
        Assert.assertThat(result, Matchers.is(expected));
    }

}