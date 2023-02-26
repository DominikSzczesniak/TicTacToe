package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import org.junit.jupiter.api.Test;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import static org.assertj.core.api.Assertions.assertThat;


class SymbolOnBoardCounterTest {

	@Test
	void name1() {
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('+'),
				new Character[][]{
						{null, '+', '+', null},
						{null, '+', null, '+'},
						{null, '+', null, null},
						{'+', '+', null, '+'},
				}
		);
		assertThat(tut.countSymbolInSequenceHorizontally(0)).isEqualTo(2);
		assertThat(tut.countSymbolInSequenceHorizontally(1)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(2)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(3)).isEqualTo(2);
	}

	@Test
	void name3() {
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('+'),
				new Character[][]{
						{null, '+', '+', null, null, null, null, null},
						{null, '+', null, '+', null, null, null, null},
						{null, '+', null, null, null, null, null, null},
						{'+', '+', null, '+', null, null, null, null},
						{'+', '+', '+', null, '+', '+', '+', '+'},
						{'+', '+', '+', null, '+', '+', '+', '+'},
						{'+', '+', '+', null, '+', '+', '+', '+'},
						{'+', '+', '+', null, '+', '+', '+', '+'},
				}
		);
		assertThat(tut.countSymbolInSequenceHorizontally(0)).isEqualTo(2);
		assertThat(tut.countSymbolInSequenceHorizontally(1)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(2)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(3)).isEqualTo(2);
		assertThat(tut.countSymbolInSequenceHorizontally(4)).isEqualTo(4);
	}

	@Test
	void name() {
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('X'),
				new Character[][]{
						{'1', 'X', '3', 'X'},
						{'4', null, '6', 'X'},
						{null, null, 'X', null},
						{null, null, '9', 'X'}
				}
		);

		assertThat(tut.maxCountSymbolInSequenceVertically(0)).isEqualTo(0);
		assertThat(tut.maxCountSymbolInSequenceVertically(1)).isEqualTo(1);
		assertThat(tut.maxCountSymbolInSequenceVertically(2)).isEqualTo(1);
		assertThat(tut.maxCountSymbolInSequenceVertically(3)).isEqualTo(2);

		assertThat(tut.countSymbolInSequenceHorizontally(0)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(1)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(2)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceHorizontally(3)).isEqualTo(1);

		assertThat(tut.countSymbolInSequenceDiagonally(3, 0)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceDiagonally(0, 1)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceDiagonally(3, 1)).isEqualTo(2);
	}
}