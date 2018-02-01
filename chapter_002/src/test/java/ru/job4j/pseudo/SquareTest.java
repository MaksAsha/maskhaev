package ru.job4j.pseudo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {
    @Test
    public void testDraw() {
        Square square = new Square();

        String actual = square.draw();

        Assert.assertThat(actual, Matchers.is(new StringBuilder()
                .append("+++++")
                .append("+   +")
                .append("+   +")
                .append("+++++")
                .toString()
        ));
    }
}