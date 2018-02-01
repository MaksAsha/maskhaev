package ru.job4j.pseudo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    @Test
    public void testDrawSquare() throws Exception {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new Paint().draw(new Square());

        Assert.assertThat(
                new String(out.toByteArray()),
                Matchers.is(new StringBuilder()
                .append("+++++")
                .append("+   +")
                .append("+   +")
                .append("+++++")
                .append(System.lineSeparator())
                .toString()
                )
        );
        System.setOut(stdout);
    }
    @Test
    public void testDrawTriangle() throws Exception {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());

        Assert.assertThat(
                new String(out.toByteArray()),
                Matchers.is(new StringBuilder()
                        .append("  +  ")
                        .append(" + + ")
                        .append("+++++")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
        System.setOut(stdout);
    }

}