package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.StringJoiner;

public class PaintTest {

    Paint paint;

    @Before
    public void setUp() {
        paint = new Paint();
    }

    @Test
    public void testPyramidForHeightFour() throws Exception {
        String result = paint.pyramid(4);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString();
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testPyramidForHeightTwo() throws Exception {
        String result = paint.pyramid(2);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(" ^ ")
                .add("^^^")
                .toString();
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testPyramidLeftSideForHeightFour() throws Exception {
        String result = paint.leftTrl(2);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(" ^")
                .add("^^")
                .toString();
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testPyramidRightSideForHeightFour() throws Exception {
        String result = paint.rightTrl(2);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("^ ")
                .add("^^")
                .toString();
        Assert.assertThat(result, Matchers.is(expected));
    }
}