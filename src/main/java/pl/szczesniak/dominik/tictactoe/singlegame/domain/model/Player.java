package pl.szczesniak.dominik.tictactoe.singlegame.domain.model;

public class Player {

	private final Symbol symbol;
	private final Name name;

	public Player(final Symbol symbol, final Name name) {
		this.symbol = symbol;
		this.name = name;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public Name getName() {
		return name;
	}

}
