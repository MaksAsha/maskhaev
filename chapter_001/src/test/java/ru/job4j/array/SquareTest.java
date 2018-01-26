package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {
    @Test
    public void testCalculateForSizeFive() throws Exception {
        Square square = new Square();
        int[] result = square.calculate(5);
        int[] expected = new int[]{0,1,4,9,16};
        Assert.assertThat(result, Matchers.is(expected));
    }

}