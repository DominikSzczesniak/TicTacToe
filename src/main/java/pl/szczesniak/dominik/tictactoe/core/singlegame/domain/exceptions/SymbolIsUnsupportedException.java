package pl.szczesniak.dominik.tictactoe.core.singlegame.domain.exceptions;

public class SymbolIsUnsupportedException extends RuntimeException {
    public SymbolIsUnsupportedException(String message) {
        super(message);
    }
}
