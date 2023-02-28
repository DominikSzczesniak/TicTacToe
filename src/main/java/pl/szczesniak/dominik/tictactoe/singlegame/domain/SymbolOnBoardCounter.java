package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Objects;

class SymbolOnBoardCounter {

	private final Symbol symbol;
	private final Character[][] board;

	SymbolOnBoardCounter(final Symbol symbol, final Character[][] board) {
		this.symbol = symbol;
		this.board = board;
	}

	int countSymbolInSequenceHorizontally(int rowIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int index = 0; index < board.length; index++) {
			if (number == 0 && board[rowIndex][index] != null && board[rowIndex][index] == symbol.getValue()) {
				number++;
			} else if (number > 0 && board[rowIndex][index - 1] != null && board[rowIndex][index - 1] == symbol.getValue()
					&& board[rowIndex][index] != null && board[rowIndex][index] == symbol.getValue()) {
				number++;
			}

			if (board[rowIndex][index] == null || board[rowIndex][index] != symbol.getValue()
					|| board[rowIndex][index] == symbol.getValue() && index == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	int maxCountSymbolInSequenceVertically(int columnIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int index = 0; index < board.length; index++) {
			if (number == 0 && board[index][columnIndex] != null && board[index][columnIndex] == symbol.getValue()) {
				number++;
			} else if (number > 0 && board[index - 1][columnIndex] != null && board[index - 1][columnIndex] == symbol.getValue()
					&& board[index][columnIndex] != null && board[index][columnIndex] == symbol.getValue()) {
				number++;
			}

			if (board[index][columnIndex] == null || board[index][columnIndex] != symbol.getValue()    // TO PODEJRZEC TO PODEJRZECTO PODEJRZECTO PODEJRZEC
					|| board[index][columnIndex] == symbol.getValue() && index == board.length - 1) {
				if (number > secondNumber) {
					secondNumber = number;
					number = 0;
				}
			}
		}

		return secondNumber;
	}

	int countSymbolInSequenceDiagonally(int rowIndex, int columnIndex) {
		int number = 0;
		int secondNumber = 0;
		int startingRowIndex = rowIndex;
		int startingColumnIndex = columnIndex;

		while (rowIndex != 0 && columnIndex != 0) {
			rowIndex--;
			columnIndex--;
		}

		for (; rowIndex < board.length; rowIndex++) {
			if (columnIndex < board.length) {
				if (number == 0 && board[rowIndex][columnIndex] != null && board[rowIndex][columnIndex] == symbol.getValue()) {
					number++;
				} else if (number > 0 && board[rowIndex - 1][columnIndex - 1] != null && board[rowIndex - 1][columnIndex - 1] == symbol.getValue()
				&& board[rowIndex][columnIndex] != null && board[rowIndex][columnIndex] == symbol.getValue()) {
					number++;
				}

				if (board[rowIndex][columnIndex] == null || board[rowIndex][columnIndex] != symbol.getValue()
						|| board[rowIndex][columnIndex] == symbol.getValue() && rowIndex == board.length - 1 || columnIndex == board.length - 1) {
					if (number > secondNumber) {
						secondNumber = number;
						number = 0;
					}
				}
				columnIndex++;
			}
		}

		number = 0;

		rowIndex = startingRowIndex;
		columnIndex = startingColumnIndex;

		while (rowIndex != board.length - 1 && columnIndex != 0) {
			rowIndex++;
			columnIndex--;
		}

		for (; rowIndex >= 0; rowIndex--) {
			if (columnIndex < board.length) {
				if (number == 0 && board[rowIndex][columnIndex] != null && board[rowIndex][columnIndex] == symbol.getValue()) {
					number++;
				} else if (number > 0 && board[rowIndex + 1][columnIndex - 1] != null && board[rowIndex + 1][columnIndex - 1] == symbol.getValue()
				&& board[rowIndex][columnIndex] != null && board[rowIndex][columnIndex] == symbol.getValue()) {
					number++;
				}

				if (board[rowIndex][columnIndex] == null || board[rowIndex][columnIndex] != symbol.getValue()
				|| board[rowIndex][columnIndex] == symbol.getValue() && rowIndex == 0) {
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
