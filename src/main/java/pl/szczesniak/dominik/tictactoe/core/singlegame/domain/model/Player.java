package pl.szczesniak.dominik.tictactoe.core.singlegame.domain.model;

import java.util.Objects;

public class Player {

	private final Symbol symbol;
	private final PlayerName playerName;
	private final int playerID;

	public Player(final Symbol symbol, final PlayerName playerName) {
		this.symbol = symbol;
		this.playerName = playerName;

		IdSetter idSetter = new IdSetter();
		playerID = idSetter.getPlayerId(playerName);
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public PlayerName getName() {
		return playerName;
	}

	int getPlayerID() {
		return playerID;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Player player = (Player) o;
		return Objects.equals(symbol, player.symbol) && Objects.equals(playerName, player.playerName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol, playerName);
	}

	@Override
	public String toString() {
		return "Player{" +
				"symbol=" + symbol +
				", name=" + playerName +
				'}';
	}
}