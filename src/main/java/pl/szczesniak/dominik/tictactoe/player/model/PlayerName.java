package pl.szczesniak.dominik.tictactoe.player.model;

public class PlayerName {

	private final String name;

	public PlayerName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
