package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import pl.szczesniak.dominik.tictactoe.gamehistory.domain.GameHistoryStorage;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerScore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class OverwritingFileGameHistoryStorage implements GameHistoryStorage {

	private final String fileName;

	public OverwritingFileGameHistoryStorage(final String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void store(SingleGameResult singleGameResult) {
		createFile();
		int playerWins = loadPlayerScore(singleGameResult.getValue()).getValue();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuffer buffer = new StringBuffer();
			String line;

			while ((line = br.readLine()) != null) {
				if (line.equals(singleGameResult.getValue().getName())) {
					br.readLine();
					buffer.append(line + "\n");
					line = String.valueOf(playerWins + 1);
					buffer.append(line + "\n");
				}  else {
					buffer.append(line);
					buffer.append('\n');
				}
			}
			br.close();

			FileOutputStream fileOut = new FileOutputStream(fileName);
			fileOut.write(buffer.toString().getBytes());
			fileOut.close();

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
					break;
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
