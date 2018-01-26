package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindLoopTest {

    FindLoop findLoop;

    @Before
    public void setUp() {
        findLoop = new FindLoop();
    }

    @Test
    public void textIndexOfExistElement() throws Exception {
        int[] data = new int[]{0, 1, 4, 9, 16};
        int result = findLoop.indexOf(data, 9);
        Assert.assertThat(result, Matchers.is(3));
    }

    @Test
    public void textIndexOfNonExistElement() throws Exception {
        int[] data = new int[]{0, 1, 4, 9, 16};
        int result = findLoop.indexOf(data, 20);
        Assert.assertThat(result, Matchers.is(-1));
    }

}