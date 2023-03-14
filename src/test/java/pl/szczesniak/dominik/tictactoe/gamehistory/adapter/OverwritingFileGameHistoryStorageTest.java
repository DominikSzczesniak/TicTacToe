package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
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

	private final String testFileName = "testFileName.txt";
	OverwritingFileGameHistoryStorage tut;


	@BeforeEach
	void setUp() {
		tut = new OverwritingFileGameHistoryStorage(testFileName);
	}

	@Test
	void should_store_and_load() {
		// when
		tut.store(new SingleGameResult(new PlayerName("Kamil")));

		// then
		assertThat(tut.loadPlayerScore(new PlayerName("Kamil")).getValue()).isEqualTo(1);
	}

	@Test
	void write_store() {
		// given

		// when
//		tut.store();

		// then
		// co jest w pliku
	}

	@Test
	void read_load() {
		// given
		// files.write(testfile)

		// when
		//tut.loadPlayerScore()

		// then
		//expect
	}

}