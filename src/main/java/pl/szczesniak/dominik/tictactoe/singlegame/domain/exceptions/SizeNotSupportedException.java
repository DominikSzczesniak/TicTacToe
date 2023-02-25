package pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions;

public class SizeNotSupportedException extends RuntimeException {

	public SizeNotSupportedException(final String message) {
		super(message);
	}
}
