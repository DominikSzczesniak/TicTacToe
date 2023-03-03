package pl.szczesniak.dominik.tictactoe.singlegame.application;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FieldNumberTranslatorTest {

    private FieldCoordinates coordinates;

    @Test
    void should_return_0_and_0_indexes_when_passed_a1_and_length_3_as_arguments() {
        // given
       final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('a', 1, 3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(0);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_0_and_1_indexes_when_passed_a2_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('a',2,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(0);
        assertThat(coordinates.getColumn()).isEqualTo(1);
    }

    @Test
    void should_return_0_and_2_indexes_when_passed_a3_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('a', 3,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(0);
        assertThat(coordinates.getColumn()).isEqualTo(2);
    }

    @Test
    void should_return_1_and_0_indexes_when_passed_b4_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('b', 4,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(1);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_1_and_1_indexes_when_passed_b5_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('b', 5,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(1);
        assertThat(coordinates.getColumn()).isEqualTo(1);
    }

    @Test
    void should_return_1_and_2_indexes_when_passed_b6_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('b', 6,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(1);
        assertThat(coordinates.getColumn()).isEqualTo(2);
    }

    @Test
    void should_return_2_and_0_indexes_when_passed_c7_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('c', 7,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(2);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_2_and_1_indexes_when_passed_c8_and_length_3_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('c', 8,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(2);
        assertThat(coordinates.getColumn()).isEqualTo(1);
    }

    @Test
    void should_return_2_and_0_indexes_when_passed_c9_and_length_4_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('c', 9, 4);

        // then
        assertThat(coordinates.getRow()).isEqualTo(2);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_3_and_3_indexes_when_passed_d19_and_length_5_as_arguments() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('d', 19, 5);

        // then
        assertThat(coordinates.getRow()).isEqualTo(3);
        assertThat(coordinates.getColumn()).isEqualTo(3);
    }

}