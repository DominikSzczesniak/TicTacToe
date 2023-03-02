package pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions;

public class GameOverException extends RuntimeException{
	public GameOverException(final String message) {
		super(message);
	}
}
