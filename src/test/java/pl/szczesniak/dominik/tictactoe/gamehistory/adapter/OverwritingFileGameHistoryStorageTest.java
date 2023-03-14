package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class OverwritingFileGameHistoryStorageTest {

	private final String testFileName = "testFileName.txt";
	@TempDir
	File testFile = new File(testFileName);
	OverwritingFileGameHistoryStorage tut;


	@BeforeEach
	void setUp() {
		tut = new OverwritingFileGameHistoryStorage(testFile.getName());
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
		final File expected = new File("testing.txt");
		// when
		tut.store(new SingleGameResult(new PlayerName("Kamil")));
		tut.store(new SingleGameResult(new PlayerName("Patryk")));

		// then
		assertThat(testFile.isFile()).isEqualTo(true);
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