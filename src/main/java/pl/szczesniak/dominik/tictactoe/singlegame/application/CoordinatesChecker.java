package pl.szczesniak.dominik.tictactoe.singlegame.application;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.WrongCoordinatesException;

class CoordinatesChecker {

	boolean areCorrectCoordinates(final String line, final int boardSize) {
		if (!Character.isLetter(line.charAt(0))
				|| !Character.isDigit(getNumberCoordinate(line)) && getNumberCoordinate(line) > boardSize
				|| getNumberCoordinate(line) > boardSize
				|| !checkIsLetterCoordinateCorrect(getLetterCoordinate(line), boardSize)
		) {
			throw new WrongCoordinatesException();
		}
		return true;
	}

	private boolean checkIsLetterCoordinateCorrect(final char letter, final int boardSize) {
		int counter = 1;
		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			if (alphabet == letter && counter <= boardSize) {
				return true;
			}
			counter++;
		}
		return false;
	}

	Integer getNumberCoordinate(final String line) {
		return Integer.parseInt(line.substring(1));
	}

	char getLetterCoordinate(final String line) {
		return Character.toLowerCase(line.charAt(0));
	}
}
