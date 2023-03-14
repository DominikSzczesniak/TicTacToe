package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import pl.szczesniak.dominik.tictactoe.gamehistory.domain.GameHistoryStorage;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerScore;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class OverwritingFileGameHistoryStorageConfiguration {

	public GameHistoryStorage overwritingFileGameHistoryStorage(final String filename) {
		return new OverwritingFileGameHistoryStorage(filename);
	}

}
