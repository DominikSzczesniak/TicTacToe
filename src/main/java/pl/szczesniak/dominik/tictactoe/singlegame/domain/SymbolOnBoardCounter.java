package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Collections;
import java.util.List;

class SymbolOnBoardCounter {

	private final Symbol symbol;
	private final Character[][] board;

	SymbolOnBoardCounter(final Symbol symbol, final Character[][] board) {
		this.symbol = symbol;
		this.board = board;
	}


	int countSymbolInSequence(final int rowIndex, final int columnIndex) {
		return max(
				countSymbolInSequenceHorizontally(rowIndex),
				maxCountSymbolInSequenceVertically(columnIndex),
				countSymbolInSequenceDiagonally(rowIndex, columnIndex)
		);
	}

	private Integer max(final int inSequenceHorizontally, final int inSequenceVertically, final int inSequenceDiagonally) {
		return Collections.max(List.of(inSequenceHorizontally, inSequenceVertically, inSequenceDiagonally));
	}

	int countSymbolInSequenceHorizontally(final int rowIndex) {
		int count = 0;
		int finalCount = 0;

		for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
			if (isSymbol(rowIndex, columnIndex)) {
				count++;
				if (columnIndex == board.length - 1) {
					finalCount = Math.max(count, finalCount);
				}
			} else {
				finalCount = Math.max(count, finalCount);
				count = 0;
			}
		}
		return finalCount;
	}

	int maxCountSymbolInSequenceVertically(final int columnIndex) {
		int count = 0;
		int finalCount = 0;

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			if (isSymbol(rowIndex, columnIndex)) {
				count++;
				if (rowIndex == board.length - 1) {
					finalCount = Math.max(count, finalCount);
				}
			} else {
				finalCount = Math.max(count, finalCount);
				count = 0;
			}
		}
		return finalCount;
	}

	int countSymbolInSequenceDiagonally(final int rowIndex, final int columnIndex) {
		int cursor = 0;
		int firstDiagonal = 0;
		int secondDiagonal;

		firstDiagonal = checkTopLeftToBotRightDiagonal(rowIndex, columnIndex, cursor, firstDiagonal);
		secondDiagonal = checkBotLeftToTopRightDiagonal(rowIndex, columnIndex, cursor, firstDiagonal);

		return Math.max(firstDiagonal, secondDiagonal);
	}

	private int checkBotLeftToTopRightDiagonal(int rowIndex, int columnIndex, int counter, int finalCounter) {
		while (rowIndex != board.length - 1 && columnIndex != 0) {
			rowIndex++;
			columnIndex--;
		}

		for (; rowIndex >= 0; rowIndex--) {
			if (columnIndex < board.length) {
				if (isSymbol(rowIndex, columnIndex)) {
					counter++;
					if (rowIndex == 0) {
						finalCounter = Math.max(counter, finalCounter);
					}
				} else {
					finalCounter = Math.max(counter, finalCounter);
					counter = 0;
				}
			}
			columnIndex++;
		}
		return finalCounter;
	}

	private int checkTopLeftToBotRightDiagonal(int rowIndex, int columnIndex, int counter, int finalCounter) {
		while (rowIndex != 0 && columnIndex != 0) {
			rowIndex--;
			columnIndex--;
		}

		for (; rowIndex < board.length; rowIndex++) {
			if (columnIndex < board.length) {
				if (isSymbol(rowIndex, columnIndex)) {
					counter++;
					if (columnIndex == board.length - 1) {
						finalCounter = Math.max(counter, finalCounter);
					}
				} else {
					finalCounter = Math.max(counter, finalCounter);
					counter = 0;
				}
			}
			columnIndex++;
		}
		return finalCounter;
	}

	private boolean isSymbol(final int rowIndex, final int columnIndex) {
		return board[rowIndex][columnIndex] != null && board[rowIndex][columnIndex] == symbol.getValue();
	}
}
