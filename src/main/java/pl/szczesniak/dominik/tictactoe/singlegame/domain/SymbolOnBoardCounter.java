package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Optional;

import static java.util.Optional.empty;

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
		int currentSymbolCount = 0;
		int maxSymbolCount = 0;
		int columnIndex = 0;
		Boardx boardx = new Boardx(board);
		do {
			final Optional<Field> field = boardx.getField(rowIndex, columnIndex);
			if (field.isPresent() && field.get().matchesSymbol(symbol.getValue())) {
				currentSymbolCount++;
			} else {
				currentSymbolCount = 0;
			}
			maxSymbolCount = Math.max(currentSymbolCount, maxSymbolCount);
		} while (boardx.getField(rowIndex, columnIndex++).isPresent());

		return maxSymbolCount;
	}

	int maxCountSymbolInSequenceVertically(final int columnIndex) {
		int currentSymbolCount = 0;
		int maxSymbolCount = 0;
		int rowIndex = 0;
		Boardx boardx = new Boardx(board);
		do {
			final Optional<Field> field = boardx.getField(rowIndex, columnIndex);
			if (field.isPresent() && field.get().matchesSymbol(symbol.getValue())) {
				currentSymbolCount++;
			} else {
				currentSymbolCount = 0;
			}
			maxSymbolCount = Math.max(currentSymbolCount, maxSymbolCount);
		} while (boardx.getField(rowIndex++, columnIndex).isPresent());

		return maxSymbolCount;
	}

	int countSymbolInSequenceDiagonally(final int rowIndex, final int columnIndex) {
		int cursor = 0;
		int firstDiagonal = 0;
		int secondDiagonal;

		firstDiagonal = checkTopLeftToBotRightDiagonal(rowIndex, columnIndex, cursor, firstDiagonal);
		secondDiagonal = checkBotLeftToTopRightDiagonal(rowIndex, columnIndex, cursor, firstDiagonal);

		return Math.max(firstDiagonal, secondDiagonal);
	}

	private int checkBotLeftToTopRightDiagonal(int rowIndex, int columnIndex, int currentSymbolCount, int maxSymbolCount) {
		while (rowIndex != board.length - 1 && columnIndex != 0) {
			rowIndex++;
			columnIndex--;
		}

		Boardx boardx = new Boardx(board);
		do {
			final Optional<Field> field = boardx.getField(rowIndex, columnIndex);
			if (field.isPresent() && field.get().matchesSymbol(symbol.getValue())) {
				currentSymbolCount++;
			} else {
				currentSymbolCount = 0;
			}
			maxSymbolCount = Math.max(currentSymbolCount, maxSymbolCount);
		} while (boardx.getField(rowIndex--, columnIndex++).isPresent());

		return maxSymbolCount;
	}

	private int checkTopLeftToBotRightDiagonal(int rowIndex, int columnIndex, int currentSymbolCount, int maxSymbolCount) {
		while (rowIndex != 0 && columnIndex != 0) {
			rowIndex--;
			columnIndex--;
		}

		Boardx boardx = new Boardx(board);
		do {
			final Optional<Field> field = boardx.getField(rowIndex, columnIndex);
			if (field.isPresent() && field.get().matchesSymbol(symbol.getValue())) {
				currentSymbolCount++;
			} else {
				currentSymbolCount = 0;
			}
			maxSymbolCount = Math.max(currentSymbolCount, maxSymbolCount);
		} while (boardx.getField(rowIndex++, columnIndex++).isPresent());

		return maxSymbolCount;
	}

	private static class Boardx {
		private final Character[][] value;

		private Boardx(final Character[][] value) {
			this.value = value;
		}

		Optional<Field> getField(final int row, final int column) {
			if (row >= value.length || row < 0) {
				return empty();
			}
			if (column >= value.length || column < 0) {
				return empty();
			}
			return Optional.of(new Field(value[row][column]));
		}
	}

	private static class Field {
		private final Character value;

		private Field(final Character value) {
			this.value = value;
		}

		Optional<Character> getValue() {
			return Optional.ofNullable(value);
		}

		boolean matchesSymbol(char symbol) {
			return getValue().map(it -> it.equals(symbol)).orElse(false);
		}
	}

}
