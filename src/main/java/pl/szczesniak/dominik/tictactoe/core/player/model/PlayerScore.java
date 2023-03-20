package pl.szczesniak.dominik.tictactoe.core.player.model;

public class PlayerScore {

	private final int value;

	public PlayerScore(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "PlayerScore{" +
				"value=" + value +
				'}';
	}
}
