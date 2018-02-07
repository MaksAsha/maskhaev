package convertarraylist;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ConvertListTest {
    ConvertList convertList;

    @Before
    public void setUp() {
        convertList = new ConvertList();
    }

    @Test
    public void testToList() throws Exception {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        List<Integer> actual = convertList.toList(arr);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testToArray() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] actual = convertList.toArray(list, 4);
        Assert.assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void testToArray1() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] actual = convertList.toArray(list, 3);
        Assert.assertThat(actual, Matchers.is(expected));
    }
}