package pl.szczesniak.dominik.tictactoe.gamehistory.domain;

import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;

public class SingleGameResult {

	private final PlayerName value;

	public SingleGameResult(final PlayerName winner) {
		this.value = winner;
	}

	public PlayerName getValue() {
		return value;
	}
}
