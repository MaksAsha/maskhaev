package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

    Factorial factorial;

    @Before
    public void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void testCalcFactorialForFiveThenOneHundredTwenty() throws Exception {
        int result = factorial.calc(5);
        Assert.assertThat(result, Matchers.is(120));
    }

    @Test
    public void testCalcFactorialForZeroThenOne() throws Exception {
        int result = factorial.calc(0);
        Assert.assertThat(result, Matchers.is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcFactorialForIllegalArgument() throws Exception {
        int result = factorial.calc(-1);
    }
}