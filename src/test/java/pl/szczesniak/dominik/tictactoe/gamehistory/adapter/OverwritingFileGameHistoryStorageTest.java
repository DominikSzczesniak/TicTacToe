package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OverwritingFileGameHistoryStorageTest {

	OverwritingFileGameHistoryStorage tut;

	@BeforeEach
	void setUp() {
		tut = new OverwritingFileGameHistoryStorage();
	}

	@TempDir
	File sharedTempDir;

	@Test
	void fileTest() throws IOException {  // dodac plik jako argument do metody?????
		// given
		File data = new File(sharedTempDir, "letters.txt");
		List<String> lines = Arrays.asList("Dominik", "5", "Patryk", "7");
		PlayerName playerName = new PlayerName("Dominik");

		// when
		Files.write(data.toPath(), lines);

		// then
		assertAll(
				() -> assertTrue(Files.exists(data.toPath()), "File should exist"),
				() -> assertLinesMatch(lines, Files.readAllLines(data.toPath())));
		assertThat(tut.loadPlayerScore(playerName).getValue()).isEqualTo(5);
	}
}