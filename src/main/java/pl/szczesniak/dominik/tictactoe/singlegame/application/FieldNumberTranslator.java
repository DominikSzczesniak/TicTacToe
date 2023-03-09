package pl.szczesniak.dominik.tictactoe.singlegame.application;

class FieldNumberTranslator {

    FieldCoordinates toCoordinates(final char letter, final int number, final int boardSize) {
        int numberOfLetter = 0;
        int counter = 0;

        if (number > boardSize) {
            return new FieldCoordinates(numberOfLetter, number, boardSize);
        }

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (counter >= boardSize) {
                return new FieldCoordinates(numberOfLetter, counter, boardSize);
            }
            if (alphabet == letter) {
                numberOfLetter = counter;
                break;
            }
            counter++;
        }

        final int row = (numberOfLetter) % boardSize;
        final int column = (number - 1) % boardSize;

        return new FieldCoordinates(row, column, boardSize);
    }
    Integer getNumberCoordinate(final String line) {
        return Integer.parseInt(line.substring(1));
    }

    char getLetterCoordinate(final String line) {
        return Character.toLowerCase(line.charAt(0));
    }


}
