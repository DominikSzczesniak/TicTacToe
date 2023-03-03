package pl.szczesniak.dominik.tictactoe.singlegame.domain;

class Board {

	private final Character[][] currentState;
	private final int rowsNumber;
	private final int columnNumber;

	 Board(final int rowsNumber, final int columnNumber) {
		this.rowsNumber = rowsNumber;
		this.columnNumber = columnNumber;
		currentState = new Character[rowsNumber][columnNumber];
	}

	void placeSymbol(final char symbol, final int rowIndex, final int columnIndex) {
		currentState[rowIndex][columnIndex] = symbol;
	}

	boolean isSpotTaken(final int rowIndex, final int columnIndex) {
		return currentState[rowIndex][columnIndex] != null;
	}

	Character[][] getCurrentState() {
		return deepCopy(currentState);
	}

	private static Character[][] deepCopy(final Character[][] original) {
		Character[][] copy = new Character[original.length][original[0].length];
		for (int x = 0; x < original.length; x++) {
			for (int y = 0; y < original[0].length; y++) {
				copy[x][y] = original[x][y];
			}
		}
		return copy;
	}

	int getRowsNumber() {
		return rowsNumber;
	}

	int getColumnNumber() {
		return columnNumber;
	}

}
