package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedMoveException;
import ru.job4j.chess.figures.*;
import ru.job4j.chess.models.Cell;
import ru.job4j.chess.models.Figure;

public class Board {

    private static final int FIGURE_COUNT = 16;
    private static final int BOARD_SIZE = 8;
    private Figure[] figures = new Figure[FIGURE_COUNT];
    private int liveFigure = 0;

    public void addFigure(Figure figure) {
        figures[liveFigure++] = figure;
    }

    public void createAndPlaceFiguresToInitialPosition() {
        for (int i = 0; i < 8; i++) {
            addFigure(new Pawn(new Cell(i, 3)));
        }
        addFigure(new Rook(new Cell(0, 0)));
        addFigure(new Rook(new Cell(7, 0)));
        addFigure(new Knight(new Cell(1, 0)));
        addFigure(new Knight(new Cell(6, 0)));
        addFigure(new Bishop(new Cell(2, 0)));
        addFigure(new Bishop(new Cell(5, 0)));
        addFigure(new Queen(new Cell(3, 0)));
        addFigure(new King(new Cell(4, 0)));
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
            OccupiedMoveException,
            FigureNotFoundException {

        if (source.getX() < 1 || source.getX() > BOARD_SIZE || dest.getY() < 1 || dest.getY() > BOARD_SIZE) {
            throw new ImpossibleMoveException("Out of board");
        }

        Figure figure = null;
        Cell[] cells;
        int index = 0;

        boolean bfind = false;
        for (int i = 0; i < liveFigure; i++) {
            if (figures[i].isInCell(source.getX(), source.getY())) {
                index = i;
                figure = figures[i];
                bfind = true;
                break;
            }
        }
        if (!bfind) {
            throw new FigureNotFoundException("Figure not found");
        }

        cells = figure.way(source, dest);

        if (figure instanceof Bishop) {
            bfind = false;
            for (int i = 0; i < liveFigure; i++) {
                for (Cell cell : cells) {
                    if (figures[i].isInCell(cell.getX(), cell.getY())) {
                        bfind = true;
                        break;
                    }
                }
            }
            if (bfind) {
                throw new OccupiedMoveException("Pass is busy");
            }
        }
        figures[index] = figure.copy(dest);
        return true;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.createAndPlaceFiguresToInitialPosition();

        for (Figure figure : board.figures) {
            if (figure != null) {
                System.out.println(figure);
            }
        }

        System.out.println("Начинаем ходить фигурой Bishop" + board.figures[12]);
        if (board.move(new Cell(2, 0), new Cell(3, 1))) {
            System.out.println("Фигура установлена на новую позицию 1!");
            if (board.move(new Cell(3, 1), new Cell(2, 0))) {
                System.out.println("Фигура установлена на новую позицию 2!");
            }
        }
    }
}
