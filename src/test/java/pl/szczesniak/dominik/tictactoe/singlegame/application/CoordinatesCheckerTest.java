package pl.szczesniak.dominik.tictactoe.singlegame.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CoordinatesCheckerTest {


	@Test
	void should_return_true_when_coordinates_are_correct() {
		// when
		CoordinatesChecker tut = new CoordinatesChecker();

		// then
		assertThat(tut.areCorrectCoordinates("B5", 5)).isEqualTo(true);
		assertThat(tut.areCorrectCoordinates("C3", 5)).isEqualTo(true);
	}

	@Test // Junit5 parametrised tests
	void should_throw_exception_when_number_coordinate_is_bigger_than_board_size_1() {
		// given
		CoordinatesChecker tut = new CoordinatesChecker();

		// when
		Throwable thrown = catchThrowable(() -> tut.areCorrectCoordinates("A4",3));

		// then
		assertThat(thrown).isInstanceOf(WrongCoordinatesException.class);
	}

	@Test
	void should_throw_exception_when_number_coordinate_is_bigger_than_board_size_2() {
		// given
		CoordinatesChecker tut = new CoordinatesChecker();

		// when
		Throwable thrown = catchThrowable(() -> tut.areCorrectCoordinates("A12",3));

		// then
		assertThat(thrown).isInstanceOf(WrongCoordinatesException.class);
	}

	@Test
	void should_throw_exception_when_letter_coordinate_is_bigger_than_board_size() {
		// given
		CoordinatesChecker tut = new CoordinatesChecker();

		// when
		Throwable thrown = catchThrowable(() -> tut.areCorrectCoordinates("G3",3));

		// then
		assertThat(thrown).isInstanceOf(WrongCoordinatesException.class);
	}
}