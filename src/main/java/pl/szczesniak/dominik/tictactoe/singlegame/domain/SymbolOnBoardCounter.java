package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

class SymbolOnBoardCounter {

	private final Symbol symbol;
	private final Character[][] board;

	SymbolOnBoardCounter(final Symbol symbol, final Character[][] board) {
		this.symbol = symbol;
		this.board = board;
	}

	private static class Boardx {
		private final Character[][] value;

		private Boardx(final Character[][] value) {
			this.value = value;
		}

		Optional<Field> getField(int row, int column) {
			if (row >= value.length) {
				return empty();
			}
			if (column >= value.length) {
				return empty();
			}
			return Optional.of(new Field(Optional.ofNullable(value[row][column]).orElse(';')));
		}
	}

	private static class Field {
		char value;

		public Field(final char value) {
			this.value = value;
		}

		Optional<Character> getValue() {
			return Optional.of(value);
		}

		boolean matchesSymbol(char symbol) {
			return getValue().isPresent() && getValue().get().equals(symbol);
		}
	}


	int horizontally(final int rowIndex) {
		int number = 0;
		int secondNumber = 0;
		int columnIndex = 0;
		Boardx boardx = new Boardx(board);
		do {
			Optional<Field> field = boardx.getField(rowIndex, columnIndex);
			if (field.isPresent() && field.get().matchesSymbol(symbol.getValue())) {
				number++;
				if (columnIndex == board.length - 1) {
					secondNumber = Math.max(number, secondNumber);
				}
			} else {
				secondNumber = Math.max(number, secondNumber);
				number = 0;
			}
		} while (boardx.getField(rowIndex, columnIndex++).isPresent());

		return secondNumber;
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
