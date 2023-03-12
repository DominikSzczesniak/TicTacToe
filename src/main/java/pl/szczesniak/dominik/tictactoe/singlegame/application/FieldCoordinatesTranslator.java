package pl.szczesniak.dominik.tictactoe.singlegame.application;

class FieldCoordinatesTranslator {

	FieldCoordinates toCoordinates(final String coordinatesLine, final int boardSize) {
		final int row = mapToRow(coordinatesLine);
		final int column = mapToColumn(coordinatesLine);
		return new FieldCoordinates(row, column, boardSize);
	}

	private int mapToColumn(final String coordinatesLine) {
		final int number = getNumberCoordinate(coordinatesLine);
		return number - 1;
	}

	private int mapToRow(final String coordinatesLine) {
		final char letter = getLetterCoordinate(coordinatesLine);
		int counter = 0;
		for (char alphabet = 'a'; alphabet < letter; alphabet++) {
			counter++;
		}

		return counter;
	}

	Integer getNumberCoordinate(final String line) {
		return Integer.parseInt(line.substring(1));
	}

	char getLetterCoordinate(final String line) {
		return Character.toLowerCase(line.charAt(0));
	}


}
