package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import pl.szczesniak.dominik.tictactoe.gamehistory.domain.GameHistoryStorage;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerScore;

public class FilePerPlayerGameHistoryStorage implements GameHistoryStorage {

	@Override
	public void store(SingleGameResult singleGameResult) {

	}

	@Override
	public PlayerScore loadPlayerScore(final PlayerName playerName) {
		return null;
	}
}
