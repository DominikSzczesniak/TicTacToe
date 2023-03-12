package pl.szczesniak.dominik.tictactoe.singlegame.domain.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IdSetter implements PlayerID {

	@Override
	public int getPlayerId(PlayerName playerName) {
		if (!playerHasId(playerName)) {
			final int id = getNewId();
			addId(playerName, id);
			return id;
		} else {
			return getExistingPlayerId(playerName);
		}
	}

	private void addId(final PlayerName playerName, final int id) {
		try {
			FileWriter fw = new FileWriter("player_id_file.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(playerName.getValue());
			bw.newLine();
			bw.write(String.valueOf(id));
			bw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private int getExistingPlayerId(final PlayerName playerName) {
		int id = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("player_id_file.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(playerName.getValue())) {
					id = Integer.parseInt(br.readLine());
					return id;
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return id;
	}

	private boolean playerHasId(final PlayerName playerName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("player_id_file.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals(playerName.getValue())) {
					return true;
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	private static int getNewId() {
		String lastLine = "";
		int id = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("player_id_file.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				lastLine = line;
				if (Character.isDigit(lastLine.charAt(0))) {
					id = Integer.parseInt(lastLine) + 1;
				}
			}
			return id;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}