package ru.job4j.pseudo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void testDraw() throws Exception {
        Triangle triangle = new Triangle();

        String actual = triangle.draw();

        Assert.assertThat(actual, Matchers.is(new StringBuilder()
                .append("  +  ")
                .append(" + + ")
                .append("+++++")
                .toString()
        ));
    }
}