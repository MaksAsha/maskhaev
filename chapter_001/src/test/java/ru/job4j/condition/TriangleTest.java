package ru.job4j.condition;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testNormalTriangleCalcSquare() throws Exception {

        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0));
        double result = triangle.calcSquare();
        double expected = 0.5D;
        Assert.assertThat(result, Matchers.closeTo(expected, 0.01));

    }

    @Test
    public void testDegenerateTriangleCalcSquare() throws Exception {

        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        double result = triangle.calcSquare();
        double expected = -1D;
        Assert.assertThat(result, Matchers.is(expected));

    }
}