package pl.szczesniak.dominik.tictactoe.singlegame.application;

public class BoardPrinter {

	private final Character[][] boardPrint;
	private final int[][] boardWithNumbers;

	BoardPrinter(final int size) {
		boardPrint = new Character[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				boardPrint[row][column] = ' ';
			}
		}

		int i = 1;
		boardWithNumbers = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				boardWithNumbers[row][column] = i;
				i++;
			}
		}
	}

//	  -------------------------------------------------------------         -------------------------------
//    |                   |                   |                   |         |         |         |         |
//    |    board[0][0]    |    board[0][1]    |    board[0][2]    |         |    1    |    2    |    3    |
//    |                   |                   |                   |         |         |         |         |
//    -------------------------------------------------------------         -------------------------------
//    |                   |                   |                   |         |         |         |         |
//    |    board[1][0]    |    board[1][1]    |    board[1][2]    |         |    4    |    5    |    6    |
//    |                   |                   |                   |         |         |         |         |
//    -------------------------------------------------------------         -------------------------------
//    |                   |                   |                   |         |         |         |         |
//    |    board[2][0]    |    board[2][1]    |    board[2][2]    |         |    7    |    8    |    9    |
//    |                   |                   |                   |         |         |         |         |
//    -------------------------------------------------------------         -------------------------------


	public void printBoard(Character[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != null) {
					boardPrint[i][j] = board[i][j];
				}
			}
		}
		int length = board.length - 1;
		for (int i = 0; i <= length; i++) {
			System.out.print(" ---------");
		}
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column = column + board.length) {
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print("|         ");
				}
				System.out.print("|");
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print("|    " + boardPrint[row][i] + "    ");
				}
				System.out.print("|");
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print("|         ");
				}
				System.out.print("|");
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print(" ---------");
				}
			}
		}
		System.out.println();
	}

	public void printBoardWithNumbers(Character[][] board) {
		int length = board.length - 1;
		for (int i = 0; i <= length; i++) {
			System.out.print(" ---------");
		}
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column = column + board.length) {
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print("|         ");
				}
				System.out.print("|");
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print("|    " + boardWithNumbers[row][i] + "    ");
				}
				System.out.print("|");
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print("|         ");
				}
				System.out.print("|");
				System.out.println();
				for (int i = 0; i <= length; i++) {
					System.out.print(" ---------");
				}
			}
		}
		System.out.println();
	}

}

