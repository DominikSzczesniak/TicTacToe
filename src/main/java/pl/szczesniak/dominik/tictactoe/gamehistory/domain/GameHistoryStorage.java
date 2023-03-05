package pl.szczesniak.dominik.tictactoe.gamehistory.domain;

public interface GameHistoryStorage {

	void store(SingleGameResult singleGameResult);

	PlayerScore loadPlayerScore(PlauerName plauerName);

}
