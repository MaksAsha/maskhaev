package ru.job4j.chess;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedMoveException;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Knight;
import ru.job4j.chess.figures.Queen;
import ru.job4j.chess.models.Cell;
import ru.job4j.chess.models.FigureEnum;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() {
        board = new Board();
        board.addFigure(new Queen(FigureEnum.QUEEN, new Cell(6, 6)));
    }

    @Test
    public void testAddFigure() throws Exception {
        //не знаю как протестировать
    }

    @Test
    public void testCreateAndPlaceFiguresToInitialPosition() throws Exception {
        //не знаю как протестировать
    }

    @Test(expected = OccupiedMoveException.class)
    public void testMoveWhenDestinationBusy() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        board.move(new Cell(5, 5), new Cell(6, 6));
    }

    @Test(expected = OccupiedMoveException.class)
    public void testMoveWhenPathBusy() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        board.move(new Cell(5, 5), new Cell(7, 7));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testMoveWhenOutOfBorder() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        board.move(new Cell(5, 5), new Cell(9, 9));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testMoveWhenPathNotAvailableForThisFigure() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        board.move(new Cell(5, 5), new Cell(5, 6));
    }

    @Test
    public void testMoveWhenPathFreeAndPath1IsCorrect() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        boolean actual = board.move(new Cell(5, 5), new Cell(4, 4));
        Assert.assertThat(actual, Matchers.is(true));
    }

    @Test
    public void testMoveWhenPathFreeAndPath2IsCorrect() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        boolean actual = board.move(new Cell(5, 5), new Cell(6, 4));
        Assert.assertThat(actual, Matchers.is(true));
    }

    @Test
    public void testMoveWhenPathFreeAndPath3IsCorrect() throws Exception {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        boolean actual = board.move(new Cell(5, 5), new Cell(4, 6));
        Assert.assertThat(actual, Matchers.is(true));
    }

    @Test
    public void testMoveDirectToFreeCellAndBack() {
        board.addFigure(new Bishop(FigureEnum.BISHOP, new Cell(5, 5)));
        board.move(new Cell(5, 5), new Cell(4, 6));
        boolean actual = board.move(new Cell(4, 6), new Cell(5, 5));
        Assert.assertThat(actual, Matchers.is(true));
    }
}