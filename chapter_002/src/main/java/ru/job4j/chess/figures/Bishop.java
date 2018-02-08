package ru.job4j.chess.figures;

import ru.job4j.chess.models.Cell;
import ru.job4j.chess.models.Figure;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

public class Bishop extends Figure {

    public Bishop(Cell cell) {
        super(cell);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {

        int dx = dest.getX()-source.getX();
        int dy = dest.getY()-source.getY();

        if (Math.abs(dx) == Math.abs(dy)){
            int steps = Math.abs(dx);
            int dxsign = dx/Math.abs(dx);
            int dysign = dy/Math.abs(dy);
            Cell[] cells = new Cell[steps];
            for (int i=1;i<=steps;i++){
                cells[i-1] = new Cell(source.getX()+i*dxsign, source.getY()+i*dysign);
            }
            return cells;

        } else throw new ImpossibleMoveException("Wrong way");
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
