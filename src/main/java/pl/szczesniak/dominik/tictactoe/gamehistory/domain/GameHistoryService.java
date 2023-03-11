package pl.szczesniak.dominik.tictactoe.gamehistory.domain;

import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerScore;

public class GameHistoryService {

	private final GameHistoryStorage storage;

	public GameHistoryService(final GameHistoryStorage storage) {
		this.storage = storage;
	}

	public void store(SingleGameResult singleGameResult) {
		storage.store(singleGameResult);
	}
	
	public PlayerScore loadPlayerScore(final PlayerName playerName) {
		return storage.loadPlayerScore(playerName);
	}

}
