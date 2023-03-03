package pl.szczesniak.dominik.tictactoe.singlegame.domain.model;

import java.util.Objects;

public class Symbol {

	private final char value;

	public Symbol(final char symbol) {
		this.value = symbol;
	}

	public char getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
