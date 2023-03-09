package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import org.junit.jupiter.api.Test;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import static org.assertj.core.api.Assertions.assertThat;


class SymbolOnBoardCounterTest {

	@Test
	void should_return_correct_highest_number_of_symbols_in_sequence_horizontally_when_given_row_v1() {
		// when
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('+'),
				new Character[][]{
						{null, '+', '+', null},
						{null, '+', null, '+'},
						{null, '+', null, null},
						{'+', '+', null, '+'},
				}
		);

		// then
		assertThat(tut.horizontally(0)).isEqualTo(2);
		assertThat(tut.horizontally(1)).isEqualTo(1);
		assertThat(tut.horizontally(2)).isEqualTo(1);
		assertThat(tut.horizontally(3)).isEqualTo(2);
	}

	@Test
	void should_return_correct_highest_number_of_symbols_in_sequence_horizontally_when_given_row_v2() {
		// when
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

		// then
		assertThat(tut.horizontally(0)).isEqualTo(2);
		assertThat(tut.horizontally(1)).isEqualTo(1);
		assertThat(tut.horizontally(2)).isEqualTo(1);
		assertThat(tut.horizontally(3)).isEqualTo(2);
		assertThat(tut.horizontally(4)).isEqualTo(4);
	}

	@Test
	void should_return_correct_highest_number_of_symbols_in_sequence_vertically_when_given_column_v1() {
		// when
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('+'),
				new Character[][]{
						{null, '+', '+', null, null, null, null, '+'},
						{null, '+', null, 'a', null, null, null, '+'},
						{null, '+', null, null, null, null, null, null},
						{'+', '+', null, 'b', null, null, null, null},
						{null, null, '+', null, '+', '6', null, '+'},
						{'+', null, '+', null, '+', '+', '+', '+'},
						{'+', null, null, null, '7', '5', '8', '+'},
						{'+', null, '+', null, '+', '+', null, '+'},
				}
		);

		// then
		assertThat(tut.maxCountSymbolInSequenceVertically(0)).isEqualTo(3);
		assertThat(tut.maxCountSymbolInSequenceVertically(7)).isEqualTo(4);
		assertThat(tut.maxCountSymbolInSequenceVertically(5)).isEqualTo(1);
		assertThat(tut.maxCountSymbolInSequenceVertically(1)).isEqualTo(4);
		assertThat(tut.maxCountSymbolInSequenceVertically(2)).isEqualTo(2);
		assertThat(tut.maxCountSymbolInSequenceVertically(3)).isEqualTo(0);
	}

	@Test
	void should_return_correct_highest_number_of_symbols_in_sequence_diagonally_when_given_column_and_row() {
		// when
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('+'),
				new Character[][]{
						{null, '+', '+', null, null, null, null, '+'},
						{null, '+', null, 'a', null, null, null, '+'},
						{null, '+', null, null, null, null, null, null},
						{'+', '+', null, 'b', null, null, null, null},
						{null, null, '+', null, '+', '6', null, '+'},
						{'+', null, '+', null, '+', '+', '+', '+'},
						{'+', '+', null, null, '7', '5', '8', '+'},
						{'+', null, '+', null, '+', '+', null, '+'},
				}
		);

		// then
		assertThat(tut.countSymbolInSequenceDiagonally(0, 7)).isEqualTo(3);
		assertThat(tut.countSymbolInSequenceDiagonally(6, 7)).isEqualTo(2);
		assertThat(tut.countSymbolInSequenceDiagonally(1, 2)).isEqualTo(2);
		assertThat(tut.countSymbolInSequenceDiagonally(6, 6)).isEqualTo(2);
		assertThat(tut.countSymbolInSequenceDiagonally(4, 0)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceDiagonally(0, 0)).isEqualTo(2);
	}


	@Test
	void should_return_correct_highest_number_of_symbols_in_sequence_in_all_lines_when_given_row_and_column() {
		// when
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('X'),
				new Character[][]{
						{'1', 'X', '3', 'X'},
						{'4', null, '6', 'X'},
						{null, null, 'X', null},
						{null, null, '9', 'X'}
				}
		);

		// then
		assertThat(tut.maxCountSymbolInSequenceVertically(0)).isEqualTo(0);
		assertThat(tut.maxCountSymbolInSequenceVertically(1)).isEqualTo(1);
		assertThat(tut.maxCountSymbolInSequenceVertically(2)).isEqualTo(1);
		assertThat(tut.maxCountSymbolInSequenceVertically(3)).isEqualTo(2);

		assertThat(tut.horizontally(0)).isEqualTo(1);
		assertThat(tut.horizontally(1)).isEqualTo(1);
		assertThat(tut.horizontally(2)).isEqualTo(1);
		assertThat(tut.horizontally(3)).isEqualTo(1);

		assertThat(tut.countSymbolInSequenceDiagonally(2, 0)).isEqualTo(0);
		assertThat(tut.countSymbolInSequenceDiagonally(0, 1)).isEqualTo(1);
		assertThat(tut.countSymbolInSequenceDiagonally(0, 0)).isEqualTo(2);
	}

	@Test
	void shoulkd_return_correct_highest_number_of_symbols_in_sequence() {
		// when
		SymbolOnBoardCounter tut = new SymbolOnBoardCounter(new Symbol('+'),
				new Character[][]{
						{null, '+', '+', null, null, null, null, '+'},
						{null, '+', null, 'a', '+', null, null, '+'},
						{null, '+', null, null, null, '+', null, null},
						{'+', '+', '+', 'b', null, null, null, null},
						{null, null, '+', null, '+', '6', null, '+'},
						{'+', null, '+', '+', '+', '+', '+', '+'},
						{'+', '+', null, null, '7', '5', '8', '+'},
						{'+', null, '+', null, '+', '+', null, '+'},
				}
		);
		assertThat(tut.countSymbolInSequence(5, 3)).isEqualTo(6);
		assertThat(tut.countSymbolInSequence(2, 4)).isEqualTo(2);
		assertThat(tut.countSymbolInSequence(7, 4)).isEqualTo(2);
		assertThat(tut.countSymbolInSequence(4, 0)).isEqualTo(3);
		assertThat(tut.countSymbolInSequence(6, 4)).isEqualTo(3);
		assertThat(tut.countSymbolInSequence(7, 6)).isEqualTo(2);
	}
}