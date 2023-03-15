package pl.szczesniak.dominik.tictactoe.gamehistory.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.linesOf;
import static org.junit.jupiter.api.Assertions.*;

class AddingNewLinesToFileGameHistoryStorageTest {

	@TempDir
	File testFile = new File("temporaryfile.txt");

	@Test
	void should_store_and_load() {
		// given
		AddingNewLinesToFileGameHistoryStorage tut = new AddingNewLinesToFileGameHistoryStorage(testFile.getName());

		// when
		tut.store(new SingleGameResult(new PlayerName("Kamil")));

		// then
		assertThat(tut.loadPlayerScore(new PlayerName("Kamil")).getValue()).isEqualTo(1);
	}

	@Test
	void write_store() {
		// given
		AddingNewLinesToFileGameHistoryStorage tut = new AddingNewLinesToFileGameHistoryStorage(testFile.getName());

		// when
		tut.store(new SingleGameResult(new PlayerName("Kamil")));
		tut.store(new SingleGameResult(new PlayerName("Patryk")));
		tut.store(new SingleGameResult(new PlayerName("Adrian")));
		tut.store(new SingleGameResult(new PlayerName("Kamil")));
		tut.store(new SingleGameResult(new PlayerName("Patryk")));
		tut.store(new SingleGameResult(new PlayerName("Patryk")));

		// then
		assertThat(linesOf(new File(testFile.getName()))).containsExactly(
				"Kamil",
				"1",
				"Patryk",
				"1",
				"Adrian",
				"1",
				"Kamil",
				"2",
				"Patryk",
				"2",
				"Patryk",
				"3"
		);
	}

}