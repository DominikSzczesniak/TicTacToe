package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

class SymbolOnBoardCounter {

	private final Symbol symbol;
	private final Character[][] board;

	SymbolOnBoardCounter(final Symbol symbol, final Character[][] board) {
		this.symbol = symbol;
		this.board = board;
	}

	int countSymbolInSequenceHorizontally(final int rowIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int index = 0; index < board.length; index++) {
			if (number == 0 && checkIfNotNull(rowIndex, index) && isEqualSymbol(index, rowIndex)) {
				number++;
			} else if (number > 0 && checkIfNotNull(rowIndex, index - 1) && isEqualSymbol(index - 1, rowIndex)
					&& checkIfNotNull(rowIndex, index) && isEqualSymbol(index, rowIndex)) {
				number++;
			}

			if (board[rowIndex][index] == null || board[rowIndex][index] != symbol.getValue()
					|| isEqualSymbol(index, rowIndex) && index == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	private boolean checkIfNotNull(final int rowIndex, final int index) {
		return board[rowIndex][index] != null;
	}

	private boolean isEqualSymbol(final int columnIndex, final int index) {
		return board[index][columnIndex] == symbol.getValue();
	}

	int maxCountSymbolInSequenceVertically(int columnIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int index = 0; index < board.length; index++) {
			if (number == 0 && checkIfNotNull(index, columnIndex) && isEqualSymbol(columnIndex, index)) {
				number++;
			} else if (number > 0 && checkIfNotNull(index - 1, columnIndex) && isEqualSymbol(columnIndex, index - 1)
					&& checkIfNotNull(index, columnIndex) && isEqualSymbol(columnIndex, index)) {
				number++;
			}

			if (board[index][columnIndex] == null || board[index][columnIndex] != symbol.getValue()    // TO PODEJRZEC TO PODEJRZECTO PODEJRZECTO PODEJRZEC
					|| isEqualSymbol(columnIndex, index) && index == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	int countSymbolInSequenceDiagonally(int rowIndex, int columnIndex) {
		int cursor = 0;
		int firstDiagonal = 0;
		int secondDiagonal = 0;

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
				if (number == 0 && checkIfNotNull(rowIndex, columnIndex) && isEqualSymbol(columnIndex, rowIndex)) {
					number++;
				} else if (number > 0 && checkIfNotNull(rowIndex + 1, columnIndex - 1) && isEqualSymbol(columnIndex - 1, rowIndex + 1)
						&& checkIfNotNull(rowIndex, columnIndex) && isEqualSymbol(columnIndex, rowIndex)) {
					number++;
				}

				if (board[rowIndex][columnIndex] == null || board[rowIndex][columnIndex] != symbol.getValue()
						|| isEqualSymbol(columnIndex, rowIndex) && rowIndex == 0) {
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
				if (number == 0 && checkIfNotNull(rowIndex, columnIndex) && isEqualSymbol(columnIndex, rowIndex)) {
					number++;
				} else if (number > 0 && checkIfNotNull(rowIndex - 1, columnIndex - 1) && isEqualSymbol(columnIndex - 1, rowIndex - 1)
						&& checkIfNotNull(rowIndex, columnIndex) && isEqualSymbol(columnIndex, rowIndex)) {
					number++;
				}

				if (board[rowIndex][columnIndex] == null || board[rowIndex][columnIndex] != symbol.getValue()
						|| isEqualSymbol(columnIndex, rowIndex) && rowIndex == board.length - 1 || columnIndex == board.length - 1) {
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

}
