package pl.szczesniak.dominik.tictactoe.core.singlegame.domain.exceptions;

public class PlayerIsNotThePartOfTheGameException extends RuntimeException {
    public PlayerIsNotThePartOfTheGameException(String message) {
        super(message);
    }
}
