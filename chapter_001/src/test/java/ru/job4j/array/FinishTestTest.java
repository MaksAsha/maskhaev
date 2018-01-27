package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FinishTestTest {

    FinishTest finishTest;

    @Before
    public void setUp() {
        finishTest = new FinishTest();
    }

    @Test
    public void testContainsFromBegining() throws Exception {
        boolean result = finishTest.contains("Приветики", "Прив");
        Assert.assertThat(result, Matchers.is(true));
    }

    @Test
    public void testContainsFromEnd() throws Exception {
        boolean result = finishTest.contains("Приветики", "етики");
        Assert.assertThat(result, Matchers.is(true));
    }

    @Test
    public void testContainsInTheMiddle() throws Exception {
        boolean result = finishTest.contains("Приветики", "ивет");
        Assert.assertThat(result, Matchers.is(true));
    }

    @Test
    public void testContainsNot() throws Exception {
        boolean result = finishTest.contains("Приветики", "равет");
        Assert.assertThat(result, Matchers.is(false));
    }
}