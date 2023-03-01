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
			if (number == 0 && checkIfCurrentIndexIsNotNull(rowIndex, index) && isIndexEqualSymbol(index, rowIndex)) {
				number++;
			} else if (number > 0 && checkIfCurrentIndexIsNotNull(rowIndex, index - 1) && isIndexEqualSymbol(index - 1, rowIndex)
					&& checkIfCurrentIndexIsNotNull(rowIndex, index) && isIndexEqualSymbol(index, rowIndex)) {
				number++;
			}

			if (board[rowIndex][index] == null || board[rowIndex][index] != symbol.getValue()
					|| isIndexEqualSymbol(index, rowIndex) && index == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	private boolean checkIfCurrentIndexIsNotNull(final int rowIndex, final int index) {
		return board[rowIndex][index] != null;
	}

	private boolean isIndexEqualSymbol(final int columnIndex, final int index) {
		return board[index][columnIndex] == symbol.getValue();
	}

	int maxCountSymbolInSequenceVertically(int columnIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int index = 0; index < board.length; index++) {
			if (number == 0 && checkIfCurrentIndexIsNotNull(index, columnIndex) && isIndexEqualSymbol(columnIndex, index)) {
				number++;
			} else if (number > 0 && checkIfCurrentIndexIsNotNull(index - 1, columnIndex) && isIndexEqualSymbol(columnIndex, index - 1)
					&& checkIfCurrentIndexIsNotNull(index, columnIndex) && isIndexEqualSymbol(columnIndex, index)) {
				number++;
			}

			if (board[index][columnIndex] == null || board[index][columnIndex] != symbol.getValue()    // TO PODEJRZEC TO PODEJRZECTO PODEJRZECTO PODEJRZEC
					|| isIndexEqualSymbol(columnIndex, index) && index == board.length - 1) {
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
				if (number == 0 && checkIfCurrentIndexIsNotNull(rowIndex, columnIndex) && isIndexEqualSymbol(columnIndex, rowIndex)) {
					number++;
				} else if (number > 0 && checkIfCurrentIndexIsNotNull(rowIndex + 1, columnIndex - 1) && isIndexEqualSymbol(columnIndex - 1, rowIndex + 1)
						&& checkIfCurrentIndexIsNotNull(rowIndex, columnIndex) && isIndexEqualSymbol(columnIndex, rowIndex)) {
					number++;
				}

				if (board[rowIndex][columnIndex] == null || board[rowIndex][columnIndex] != symbol.getValue()
						|| isIndexEqualSymbol(columnIndex, rowIndex) && rowIndex == 0) {
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
				if (number == 0 && checkIfCurrentIndexIsNotNull(rowIndex, columnIndex) && isIndexEqualSymbol(columnIndex, rowIndex)) {
					number++;
				} else if (number > 0 && checkIfCurrentIndexIsNotNull(rowIndex - 1, columnIndex - 1) && isIndexEqualSymbol(columnIndex - 1, rowIndex - 1)
						&& checkIfCurrentIndexIsNotNull(rowIndex, columnIndex) && isIndexEqualSymbol(columnIndex, rowIndex)) {
					number++;
				}

				if (board[rowIndex][columnIndex] == null || board[rowIndex][columnIndex] != symbol.getValue()
						|| isIndexEqualSymbol(columnIndex, rowIndex) && rowIndex == board.length - 1 || columnIndex == board.length - 1) {
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
