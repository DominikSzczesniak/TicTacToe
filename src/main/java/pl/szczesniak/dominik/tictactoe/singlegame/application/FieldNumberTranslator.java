package pl.szczesniak.dominik.tictactoe.singlegame.application;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.SingleGame;

class FieldNumberTranslator {



    FieldCoordinates toCoordinates(final int number, final int length) {
        int row = (number - 1) / length;
        int column = (number - 1) % length;

        return new FieldCoordinates(row, column);
    }
}
