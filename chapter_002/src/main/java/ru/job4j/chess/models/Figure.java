package ru.job4j.chess.models;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

public abstract class Figure {

    private final Cell cell;

    public Figure(Cell cell) {
        this.cell = cell;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public abstract Figure copy(Cell dest);

    public boolean isInCell(int x, int y) {
        return this.cell.x == x && this.cell.y == y;
    }

    @Override
    public String toString() {
        return "Figure{" +
                ", cell=" + cell +
                '}';
    }
}
