package ru.job4j.chess.models;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

public abstract class Figure {

    private final Cell cell;
    private final FigureEnum figure;

    public Figure(FigureEnum figure, Cell cell) {
        this.figure = figure;
        this.cell = cell;
    }

    public FigureEnum getFigure() {
        return figure;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public abstract Figure copy(FigureEnum figure, Cell dest);

    public boolean isInCell(int x, int y) {
        return this.cell.x == x && this.cell.y == y;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "figure='" + figure + '\'' +
                ", cell=" + cell +
                '}';
    }
}
