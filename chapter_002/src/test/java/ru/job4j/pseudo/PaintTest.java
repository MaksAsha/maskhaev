package ru.job4j.pseudo;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput(){
        System.out.println("execute before test method");
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput(){
        System.setOut(stdout);
        System.out.println("execute after test method");
    }

    @Test
    public void testDrawSquare() throws Exception {
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
    }

    @Test
    public void testDrawTriangle() throws Exception {
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
    }

}