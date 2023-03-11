package pl.szczesniak.dominik.tictactoe.gamehistory.domain;

import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerScore;

public interface GameHistoryStorage {

	void store(SingleGameResult singleGameResult);

	PlayerScore loadPlayerScore(PlayerName playerName);

}
