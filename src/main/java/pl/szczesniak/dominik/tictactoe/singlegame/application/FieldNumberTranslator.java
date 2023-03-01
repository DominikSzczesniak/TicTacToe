package pl.szczesniak.dominik.tictactoe.singlegame.application;

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

        final int row = (numberOfLetter) % length;
        final int column = (number - 1) % length;

        return new FieldCoordinates(row, column);
    }
}
