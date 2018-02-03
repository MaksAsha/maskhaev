package ru.job4j.chess.figures;

import ru.job4j.chess.models.Cell;
import ru.job4j.chess.models.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.models.FigureEnum;

public class Queen extends Figure {

    public Queen(FigureEnum figure, Cell cell) {
        super(figure, cell);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        return new Cell[0];
    }

    @Override
    public Figure copy(FigureEnum figure, Cell dest) {
        return new Queen(figure, dest);
    }
}
