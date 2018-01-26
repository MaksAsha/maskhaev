package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void testSort() throws Exception {
        int[] data = new int[]{9,8,7,6,5,4,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(data);
        int[] expected = new int[]{1,2,3,4,5,6,7,8,9};
        Assert.assertThat(result, Matchers.is(expected));

    }
}