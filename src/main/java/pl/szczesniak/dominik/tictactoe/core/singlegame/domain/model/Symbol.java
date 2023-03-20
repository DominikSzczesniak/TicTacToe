package pl.szczesniak.dominik.tictactoe.core.singlegame.domain.model;

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
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Symbol symbol = (Symbol) o;
		return value == symbol.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
