package pl.szczesniak.dominik.tictactoe.singlegame.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FieldNumberTranslatorTest {

	private FieldCoordinatesTranslator tut;

	@BeforeEach
	void setUp() {
		tut = new FieldCoordinatesTranslator();
	}

	@Test
	void board_size_3() {
		FieldAssert.assertThatField(tut.toCoordinates("a1", 3)).isRowIndex(0).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("a2", 3)).isRowIndex(0).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("a3", 3)).isRowIndex(0).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("b1", 3)).isRowIndex(1).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("b2", 3)).isRowIndex(1).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("b3", 3)).isRowIndex(1).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("c1", 3)).isRowIndex(2).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("c2", 3)).isRowIndex(2).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("c3", 3)).isRowIndex(2).isColumnIndex(2);
	}

	@Test
	void board_size_4() {
		FieldAssert.assertThatField(tut.toCoordinates("a1", 4)).isRowIndex(0).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("a2", 4)).isRowIndex(0).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("a3", 4)).isRowIndex(0).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("a4", 4)).isRowIndex(0).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("b1", 4)).isRowIndex(1).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("b2", 4)).isRowIndex(1).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("b3", 4)).isRowIndex(1).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("b4", 4)).isRowIndex(1).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("c1", 4)).isRowIndex(2).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("c2", 4)).isRowIndex(2).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("c3", 4)).isRowIndex(2).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("c4", 4)).isRowIndex(2).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("d1", 4)).isRowIndex(3).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("d2", 4)).isRowIndex(3).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("d3", 4)).isRowIndex(3).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("d4", 4)).isRowIndex(3).isColumnIndex(3);
	}

	@Test
	void board_size_5() {
		FieldAssert.assertThatField(tut.toCoordinates("a1", 5)).isRowIndex(0).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("a2", 5)).isRowIndex(0).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("a3", 5)).isRowIndex(0).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("a4", 5)).isRowIndex(0).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("a5", 5)).isRowIndex(0).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("b1", 5)).isRowIndex(1).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("b2", 5)).isRowIndex(1).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("b3", 5)).isRowIndex(1).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("b4", 5)).isRowIndex(1).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("b5", 5)).isRowIndex(1).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("c1", 5)).isRowIndex(2).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("c2", 5)).isRowIndex(2).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("c3", 5)).isRowIndex(2).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("c4", 5)).isRowIndex(2).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("c5", 5)).isRowIndex(2).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("d1", 5)).isRowIndex(3).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("d2", 5)).isRowIndex(3).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("d3", 5)).isRowIndex(3).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("d4", 5)).isRowIndex(3).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("d5", 5)).isRowIndex(3).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("e1", 5)).isRowIndex(4).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("e2", 5)).isRowIndex(4).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("e3", 5)).isRowIndex(4).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("e4", 5)).isRowIndex(4).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("e5", 5)).isRowIndex(4).isColumnIndex(4);
	}

	@Test
	void board_size_6() {
		FieldAssert.assertThatField(tut.toCoordinates("a1", 6)).isRowIndex(0).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("a2", 6)).isRowIndex(0).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("a3", 6)).isRowIndex(0).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("a4", 6)).isRowIndex(0).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("a5", 6)).isRowIndex(0).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("a6", 6)).isRowIndex(0).isColumnIndex(5);
		FieldAssert.assertThatField(tut.toCoordinates("b1", 6)).isRowIndex(1).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("b2", 6)).isRowIndex(1).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("b3", 6)).isRowIndex(1).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("b4", 6)).isRowIndex(1).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("b5", 6)).isRowIndex(1).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("b6", 6)).isRowIndex(1).isColumnIndex(5);
		FieldAssert.assertThatField(tut.toCoordinates("c1", 6)).isRowIndex(2).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("c2", 6)).isRowIndex(2).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("c3", 6)).isRowIndex(2).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("c4", 6)).isRowIndex(2).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("c5", 6)).isRowIndex(2).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("c6", 6)).isRowIndex(2).isColumnIndex(5);
		FieldAssert.assertThatField(tut.toCoordinates("d1", 6)).isRowIndex(3).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("d2", 6)).isRowIndex(3).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("d3", 6)).isRowIndex(3).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("d4", 6)).isRowIndex(3).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("d5", 6)).isRowIndex(3).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("d6", 6)).isRowIndex(3).isColumnIndex(5);
		FieldAssert.assertThatField(tut.toCoordinates("e1", 6)).isRowIndex(4).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("e2", 6)).isRowIndex(4).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("e3", 6)).isRowIndex(4).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("e4", 6)).isRowIndex(4).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("e5", 6)).isRowIndex(4).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("e6", 6)).isRowIndex(4).isColumnIndex(5);
		FieldAssert.assertThatField(tut.toCoordinates("f1", 6)).isRowIndex(5).isColumnIndex(0);
		FieldAssert.assertThatField(tut.toCoordinates("f2", 6)).isRowIndex(5).isColumnIndex(1);
		FieldAssert.assertThatField(tut.toCoordinates("f3", 6)).isRowIndex(5).isColumnIndex(2);
		FieldAssert.assertThatField(tut.toCoordinates("f4", 6)).isRowIndex(5).isColumnIndex(3);
		FieldAssert.assertThatField(tut.toCoordinates("f5", 6)).isRowIndex(5).isColumnIndex(4);
		FieldAssert.assertThatField(tut.toCoordinates("f6", 6)).isRowIndex(5).isColumnIndex(5);

	}


}