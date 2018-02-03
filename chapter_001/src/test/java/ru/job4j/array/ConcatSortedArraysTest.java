package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcatSortedArraysTest {

    ConcatSortedArrays arrays;

    @Before
    public void setUp(){
        arrays = new ConcatSortedArrays();
    }


    @Test
    public void testWhenBothAreNull() throws Exception {
        int[] arr1 = null;
        int[] arr2 = null;
        int[] expected = null;

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenFirstIsNullSecondIsEmpty() throws Exception {
        int[] arr1 = null;
        int[] arr2 = new int[]{};
        int[] expected = new int[]{};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenFirstIsEmptySecondIsNull() throws Exception {
        int[] arr1 = new int[]{};
        int[] arr2 = null;
        int[] expected = new int[]{};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenBothAreEmpty() throws Exception {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};
        int[] expected = new int[]{};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenFirstIsEmptySecondIsFull() throws Exception {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1,2,3};
        int[] expected = new int[]{1,2,3};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenFirstIsFullSecondIsEmpty() throws Exception {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{};
        int[] expected = new int[]{1,2,3};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenBothAreTheSameLength() throws Exception {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
        int[] expected = new int[]{1,1,2,2,3,3};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testWhenBothAreTheDifferLength() throws Exception {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3,14,15};
        int[] expected = new int[]{1,1,2,2,3,3,14,15};

        int[] actual = arrays.concatAndSort(arr1, arr2);
        Assert.assertThat(actual, Matchers.is(expected));
    }

}