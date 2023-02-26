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
			} else if (index > 0 && board[rowIndex][index - 1] != null && board[rowIndex][index - 1] == symbol.getValue()
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
		return 0;
	}

	int countSymbolInSequenceDiagonally(int rowIndex, int columnIndex) {
		return 0;
	}

}
