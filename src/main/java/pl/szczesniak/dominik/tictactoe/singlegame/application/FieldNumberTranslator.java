package pl.szczesniak.dominik.tictactoe.singlegame.application;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.SingleGame;

class FieldNumberTranslator {



    FieldCoordinates toCoordinates(final char letter, final int number, final int length) {
        int numberOfLetter = 0;
        int counter = 0;
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (alphabet == letter) {
                numberOfLetter = counter;
                break;
            }
            counter++;
        }

        int row = (numberOfLetter) % length;
        int column = (number - 1) % length;

        return new FieldCoordinates(row, column);
    }
}
