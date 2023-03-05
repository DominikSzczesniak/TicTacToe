package pl.szczesniak.dominik.tictactoe.gamehistory.domain;

public class GameHistoryService {

	private final GameHistoryStorage storage;

	public GameHistoryService(final GameHistoryStorage storage) {
		this.storage = storage;
	}


}
