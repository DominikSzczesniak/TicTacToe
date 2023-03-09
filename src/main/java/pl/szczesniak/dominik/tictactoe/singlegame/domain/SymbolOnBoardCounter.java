package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

class SymbolOnBoardCounter {

	private final Symbol symbol;
	private final Character[][] board;

	private static class Board {
		private final Character[][] value;
//		private final int rows;
//		private final int columns;

		private Board(final Character[][] value) {
			this.value = value;
		}

		Optional<Object> getField(int row, int column) {
			if (row >= value.length) {
				return empty();
			}
			if (column >= value.length) {
				return empty();
			}
			return Optional.of(new Field(ofNullable(value[row][column])));
		}
	}

	private static class Field {
		char value;

		public <Object> Field(final Optional<Object> field) {
			field.ifPresent(object -> this.value = (char) object);
		}

		Optional<Character> getValue() {
			return Optional.of(value);
		}
	}

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
			if (isSymbol(rowIndex, columnIndex)) {
				number++;
				if (columnIndex == board.length - 1) {
					secondNumber = Math.max(number, secondNumber);
				}
			} else {
				secondNumber = Math.max(number, secondNumber);
				number = 0;
			}
		}
		return secondNumber;
	}

	int maxCountSymbolInSequenceVertically(final int columnIndex) {
		int number = 0;
		int secondNumber = 0;

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			if (isSymbol(rowIndex, columnIndex)) {
				number++;
				if (rowIndex == board.length - 1) {
					secondNumber = Math.max(number, secondNumber);
				}
			} else {
				secondNumber = Math.max(number, secondNumber);
				number = 0;
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
				if (isSymbol(rowIndex, columnIndex)) {
					number++;
					if (rowIndex == 0) {
						secondNumber = Math.max(number, secondNumber);
					}
				} else {
					secondNumber = Math.max(number, secondNumber);
					number = 0;
				}
			}
			columnIndex++;
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
				if (isSymbol(rowIndex, columnIndex)) {
					number++;
					if (columnIndex == board.length - 1) {
						secondNumber = Math.max(number, secondNumber);
					}
				} else {
					secondNumber = Math.max(number, secondNumber);
					number = 0;
				}
			}
			columnIndex++;
		}
		return secondNumber;
	}

	private boolean isSymbol(final int rowIndex, final int columnIndex) {
		return board[rowIndex][columnIndex] != null && board[rowIndex][columnIndex] == symbol.getValue();
	}
}
