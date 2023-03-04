package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Name;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameHistoryHandler {

	public void saveWinner(Name player) {
//		int playerWins = getPlayerWins(player);
		int playerWins = 0;
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Game history.txt "));
			bufferedWriter.write(player + ": " + playerWins + " wins");
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (Exception e) {

		}
	}

	public int getPlayerWins(Name player) {
		int playerWins = 0;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("Game history.txt"));
			bufferedReader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return playerWins;
	}
}
