package pl.szczesniak.dominik.tictactoe.core.singlegame.domain.exceptions;

public class GameOverException extends RuntimeException{
	public GameOverException(final String message) {
		super(message);
	}
}
