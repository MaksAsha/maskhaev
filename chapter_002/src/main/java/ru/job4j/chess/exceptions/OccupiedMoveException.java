package ru.job4j.chess.exceptions;

public class OccupiedMoveException extends RuntimeException {

    public OccupiedMoveException(String s) {
        super(s);
    }
}
