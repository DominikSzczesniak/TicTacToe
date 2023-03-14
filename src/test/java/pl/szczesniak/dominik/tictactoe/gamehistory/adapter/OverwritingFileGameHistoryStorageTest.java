package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OverwritingFileGameHistoryStorageTest {

	private final String testFileName = "testFileName.txt";
//	OverwritingFileGameHistoryStorage tut;

	@TempDir
	File testFile = new File("temporaryfile.txt");

//	@BeforeEach
//	void setUp() {
//		tut = new OverwritingFileGameHistoryStorage(testFile.getName());
//	}

	@Test
	@Order(1)
	void should_store_and_load() {
		// when
		OverwritingFileGameHistoryStorage tut = new OverwritingFileGameHistoryStorage(testFile.getName());
		tut.store(new SingleGameResult(new PlayerName("Kamil")));

		// then
		assertThat(tut.loadPlayerScore(new PlayerName("Kamil")).getValue()).isEqualTo(1);
	}

	@Test
	@Order(2)
	void write_store() throws IOException {
		// given
		OverwritingFileGameHistoryStorage tut = new OverwritingFileGameHistoryStorage(testFile.getName());
		final File expected = new File("testing.txt");

		// when
		tut.store(new SingleGameResult(new PlayerName("Kamil")));
		tut.store(new SingleGameResult(new PlayerName("Patryk")));

		// then
//		assertThat(testFile).hasSameTextualContentAs(expected);
		assertTrue(FileUtils.contentEquals(testFile, expected), "The files differ!");
	}

	@Test
	@Order(3)
	void read_load() {
		// given
		// files.write(testfile)

		// when
		//tut.loadPlayerScore()

		// then
		//expect
	}

}