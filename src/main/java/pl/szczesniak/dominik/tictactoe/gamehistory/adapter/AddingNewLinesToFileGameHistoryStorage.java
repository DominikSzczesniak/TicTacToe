package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import pl.szczesniak.dominik.tictactoe.gamehistory.domain.GameHistoryStorage;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerScore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddingNewLinesToFileGameHistoryStorage implements GameHistoryStorage {

	private final String fileName;

	public AddingNewLinesToFileGameHistoryStorage(final String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void store(final SingleGameResult singleGameResult) {
		createFile();
		int playerWins = loadPlayerScore(singleGameResult.getValue()).getValue();
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(singleGameResult.getValue().getName() + "\n");
			bw.write(playerWins + 1 + "\n");
			bw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PlayerScore loadPlayerScore(final PlayerName playerName) {
		int wins = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(playerName.getName())) {
					wins = Integer.parseInt(br.readLine());
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return new PlayerScore(wins);
	}

	private void createFile() {
		try {
			File myObj = new File(fileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

