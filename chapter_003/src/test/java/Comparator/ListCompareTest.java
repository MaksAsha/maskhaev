package Comparator;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ListCompareTest {

    ListCompare listCompare;

    @Before
    public void setUp() {
        listCompare = new ListCompare();
    }

    @Test
    public void testCompareWhenBothAreEqual() throws Exception {
        int actual = listCompare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        Assert.assertThat(actual, Matchers.is(0));
    }

    @Test
    public void testCompareWhenLeftLessThenRight() throws Exception {
        int actual = listCompare.compare(
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 2, 3)
        );
        Assert.assertThat(actual, Matchers.is(-1));
    }

    @Test
    public void testCompareWhenLeftGreaterThenRight() throws Exception {
        int actual = listCompare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 1)
        );
        Assert.assertThat(actual, Matchers.is(1));
    }

    @Test
    public void testCompareWhenLeftShorterThenRight() throws Exception {
        int actual = listCompare.compare(
                Arrays.asList(1, 2),
                Arrays.asList(1, 2, 3)
        );
        Assert.assertThat(actual, Matchers.is(-1));
    }

    @Test
    public void testCompareWhenLeftLongerThenRight() throws Exception {
        int actual = listCompare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2)
        );
        Assert.assertThat(actual, Matchers.is(1));
    }

}