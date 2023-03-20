package pl.szczesniak.dominik.tictactoe.core.singlegame.domain.exceptions;

public class SpotAlreadyTakenOnBoardException extends RuntimeException {
    public SpotAlreadyTakenOnBoardException(String message) {
        super(message);
    }
}
