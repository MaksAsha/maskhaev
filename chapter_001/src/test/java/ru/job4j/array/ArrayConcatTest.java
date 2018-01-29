package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayConcatTest {

    ArrayConcat data;
    int[] arr1;
    int[] arr2;

    @Before
    public void setUp() {
        data = new ArrayConcat();

    }

    @Test
    public void testConcatAndSortWhenBothArgAreExist() throws Exception {
        arr1 = new int[]{3, 6, 9};
        arr2 = new int[]{4, 5, 1, 2};
        int[] actual = data.concatAndSort(arr1, arr2);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 9};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatAndSortWhenBothArgAreNull() throws Exception {
        int[] actual = data.concatAndSort(arr1, arr2);
    }

    @Test
    public void testConcatAndSortWhenOneArgIsNull() throws Exception {
        arr1 = null;
        arr2 = new int[]{3, 2, 1};

        int[] actual = data.concatAndSort(arr1, arr2);
        int[] expected = new int[]{1, 2, 3};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testConcatAndSortWhenOneArgAreEmpty() throws Exception {
        arr1 = new int[]{3, 4, 2};
        arr2 = new int[]{};

        int[] actual = data.concatAndSort(arr1, arr2);
        int[] expected = new int[]{2, 3, 4};

        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testConcatAndSortWhenBothArgAreEmpty() throws Exception {
        arr1 = new int[]{};
        arr2 = new int[]{};

        int[] actual = data.concatAndSort(arr1, arr2);
        int[] expected = new int[]{};

        Assert.assertThat(actual, Matchers.is(expected));
    }
}