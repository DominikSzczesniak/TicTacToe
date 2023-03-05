package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


class BoardTest {

	private Board tut;

	@BeforeEach
	void setUp() {
		tut = new Board(5, 5);
	}

	@Test
	void placing_symbols_should_change_array() {
		// when
		tut.placeSymbol('A', 1, 1);
		tut.placeSymbol('B', 1, 2);
		tut.placeSymbol('C', 1, 3);
		tut.placeSymbol('A', 0, 1);
		tut.placeSymbol('A', 2, 1);

		// then
		final Character[][] boardView = tut.getCurrentState();
		assertThat(boardView[0]).containsExactly(null, null, null, null, null);
		assertThat(boardView[1]).containsExactly(null, 'A', null, null, null);
		assertThat(boardView[2]).containsExactly(null, null, null, null, null);
		assertThat(boardView[3]).containsExactly(null, null, null, null, null);
		assertThat(boardView[4]).containsExactly(null, null, null, null, null);
	}

	@Test
	void should_throw_exception_when_trying_to_place_symbol_out_of_bounds() {
		// when
		final Throwable thrown = catchThrowable(() -> tut.placeSymbol('E', 5, 5));

		// then
		assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class);
	}

	@Test
	void should_return_true_if_spot_is_taken() {
		// when
		tut.placeSymbol('O', 0, 0);

		// then
		assertThat(tut.isSpotTaken(0, 0)).isEqualTo(true);
	}

	@Test
	void should_return_false_if_spot_is_not_taken() {
		// when
		tut.placeSymbol('O', 2, 0);

		// then
		assertThat(tut.isSpotTaken(0, 0)).isEqualTo(false);
	}

}