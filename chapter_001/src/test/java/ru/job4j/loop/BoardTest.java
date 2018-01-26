package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    Board board;
    final String ls = System.lineSeparator();

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPaintForBoardThreeAndThree() throws Exception {
        String result = board.paint(4, 4);
        String expected = String.format("X X %s X X%sX X %s X X%s", ls, ls, ls, ls);
        Assert.assertThat(result, Matchers.is(expected));
    }

    @Test
    public void testPaintForBoardThreeAndTwo() throws Exception {
        String result = board.paint(3, 2);
        String expected = String.format("X X%s X %s", ls, ls);
        Assert.assertThat(result, Matchers.is(expected));
    }
}