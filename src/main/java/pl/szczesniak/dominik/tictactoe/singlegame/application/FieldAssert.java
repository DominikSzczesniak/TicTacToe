package pl.szczesniak.dominik.tictactoe.singlegame.application;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldAssert {

	private final FieldCoordinates coordinates;

	FieldAssert(final FieldCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	static FieldAssert assertThatField(final FieldCoordinates coordinates) {
		return new FieldAssert(coordinates);
	}

	FieldAssert isRowIndex(final int row) {
		assertThat(coordinates.getRow()).isEqualTo(row);
		return this;
	}

	FieldAssert isColumnIndex(final int column) {
		assertThat(coordinates.getColumn()).isEqualTo(column);
		return this;
	}
}
