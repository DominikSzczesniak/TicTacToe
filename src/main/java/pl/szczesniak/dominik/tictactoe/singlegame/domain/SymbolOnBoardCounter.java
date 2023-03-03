package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

class SymbolOnBoardCounter {

	private final Symbol symbol;
	private final Character[][] board;

	SymbolOnBoardCounter(final Symbol symbol, final Character[][] board) {
		this.symbol = symbol;
		this.board = board;
	}

	int countSymbolInSequence(final int rowIndex, final int columnIndex) {
		return Math.max(countSymbolInSequenceHorizontally(rowIndex),
				Math.max(maxCountSymbolInSequenceVertically(columnIndex), countSymbolInSequenceDiagonally(rowIndex, columnIndex)));
	}

	int countSymbolInSequenceHorizontally(final int rowIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
			if (number == 0 && checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
				number++;
			} else if (number > 0 && checkIfNotNull(rowIndex, columnIndex - 1) && checkIsEqualSymbol(rowIndex,columnIndex - 1)
					&& checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
				number++;
			}

			if (!checkIfNotNull(rowIndex, columnIndex) || !checkIsEqualSymbol(rowIndex, columnIndex)
					|| checkIsEqualSymbol(rowIndex, columnIndex) && columnIndex == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	int maxCountSymbolInSequenceVertically(final int columnIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			if (number == 0 && checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
				number++;
			} else if (number > 0 && checkIfNotNull(rowIndex - 1, columnIndex) && checkIsEqualSymbol(rowIndex - 1, columnIndex)
					&& checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
				number++;
			}

			if (!checkIfNotNull(rowIndex, columnIndex) || !checkIsEqualSymbol(rowIndex, columnIndex)
					|| checkIsEqualSymbol(rowIndex, columnIndex) && rowIndex == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	int countSymbolInSequenceDiagonally(final int rowIndex, final int columnIndex) {
		int cursor = 0;
		int firstDiagonal = 0;
		int secondDiagonal;

		firstDiagonal = checkTopLeftToBotRightDiagonal(rowIndex, columnIndex, cursor, firstDiagonal);
		secondDiagonal = checkBotLeftToTopRightDiagonal(rowIndex, columnIndex, cursor, firstDiagonal);

		return Math.max(firstDiagonal, secondDiagonal);
	}

	private int checkBotLeftToTopRightDiagonal(int rowIndex, int columnIndex, int number, int secondNumber) {
		while (rowIndex != board.length - 1 && columnIndex != 0) {
			rowIndex++;
			columnIndex--;
		}

		for (; rowIndex >= 0; rowIndex--) {
			if (columnIndex < board.length) {
				if (number == 0 && checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
					number++;
				} else if (number > 0 && checkIfNotNull(rowIndex + 1, columnIndex - 1)
						&& checkIsEqualSymbol(rowIndex + 1, columnIndex - 1)
						&& checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
					number++;
				}

				if (!checkIfNotNull(rowIndex, columnIndex) || !checkIsEqualSymbol(rowIndex, columnIndex)
						|| checkIsEqualSymbol(rowIndex, columnIndex) && rowIndex == 0) {
					if (number > secondNumber) {
						secondNumber = number;
						number = 0;
					}
				}
				columnIndex++;
			}
		}
		return secondNumber;
	}

	private int checkTopLeftToBotRightDiagonal(int rowIndex, int columnIndex, int number, int secondNumber) {
		while (rowIndex != 0 && columnIndex != 0) {
			rowIndex--;
			columnIndex--;
		}

		for (; rowIndex < board.length; rowIndex++) {
			if (columnIndex < board.length) {
				if (number == 0 && checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
					number++;
				} else if (number > 0 && checkIfNotNull(rowIndex - 1, columnIndex - 1)
						&& checkIsEqualSymbol(rowIndex - 1, columnIndex - 1)
						&& checkIfNotNull(rowIndex, columnIndex) && checkIsEqualSymbol(rowIndex, columnIndex)) {
					number++;
				}

				if (!checkIfNotNull(rowIndex, columnIndex) || !checkIsEqualSymbol(rowIndex, columnIndex)
						|| checkIsEqualSymbol(rowIndex, columnIndex) && rowIndex == board.length - 1 || columnIndex == board.length - 1) {
					if (number > secondNumber) {
						secondNumber = number;
						number = 0;
					}
				}
				columnIndex++;
			}
		}
		return secondNumber;
	}


	private boolean checkIfNotNull(final int rowIndex, final int columnIndex) {
		return board[rowIndex][columnIndex] != null;
	}

	private boolean checkIsEqualSymbol(final int rowIndex, final int columnIndex) {
		return board[rowIndex][columnIndex] == symbol.getValue();
	}
}
