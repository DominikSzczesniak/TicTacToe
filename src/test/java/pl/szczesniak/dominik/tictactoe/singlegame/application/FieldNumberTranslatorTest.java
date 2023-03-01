package pl.szczesniak.dominik.tictactoe.singlegame.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FieldNumberTranslatorTest {

    private FieldCoordinates coordinates;



    @Test
    void should_return_0_and_0_coordinates_when_passed_a_1_as_an_argument() {
        // given
       final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('a', 1, 3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(0);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_0_and_1_coordinates_when_passed_2_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('a',2,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(0);
        assertThat(coordinates.getColumn()).isEqualTo(1);
    }

    @Test
    void should_return_0_and_2_coordinates_when_passed_3_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('a', 3,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(0);
        assertThat(coordinates.getColumn()).isEqualTo(2);
    }

    @Test
    void should_return_1_and_0_coordinates_when_passed_4_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('b', 4,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(1);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_1_and_1_coordinates_when_passed_5_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('b', 5,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(1);
        assertThat(coordinates.getColumn()).isEqualTo(1);
    }

    @Test
    void should_return_1_and_2_coordinates_when_passed_6_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('b', 6,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(1);
        assertThat(coordinates.getColumn()).isEqualTo(2);
    }

    @Test
    void should_return_2_and_0_coordinates_when_passed_7_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('c', 7,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(2);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    @Test
    void should_return_2_and_1_coordinates_when_passed_8_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('c', 8,3);

        // then
        assertThat(coordinates.getRow()).isEqualTo(2);
        assertThat(coordinates.getColumn()).isEqualTo(1);
    }

    @Test
    void should_return_2_and_2_coordinates_when_passed_9_as_an_argument() {
        // given
        final FieldNumberTranslator tut = new FieldNumberTranslator();

        // when
        coordinates = tut.toCoordinates('c', 9, 4);

        // then
        assertThat(coordinates.getRow()).isEqualTo(2);
        assertThat(coordinates.getColumn()).isEqualTo(0);
    }

    
//        assertThat(tut.toCoordinates(2)).isEqualTo(new FieldCoordinates(0, 1));
//        assertThat(tut.toCoordinates(3)).isEqualTo(new FieldCoordinates(0, 2));
//        assertThat(tut.toCoordinates(4)).isEqualTo(new FieldCoordinates(1, 0));
//        assertThat(tut.toCoordinates(5)).isEqualTo(new FieldCoordinates(1, 1));
//        assertThat(tut.toCoordinates(6)).isEqualTo(new FieldCoordinates(1, 2));
//        assertThat(tut.toCoordinates(7)).isEqualTo(new FieldCoordinates(2, 0));
//        assertThat(tut.toCoordinates(8)).isEqualTo(new FieldCoordinates(2, 1));
//        assertThat(tut.toCoordinates(9)).isEqualTo(new FieldCoordinates(2, 2));

}