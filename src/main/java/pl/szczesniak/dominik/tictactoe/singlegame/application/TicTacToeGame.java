package pl.szczesniak.dominik.tictactoe.singlegame.application;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.SingleGame;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SpotAlreadyTakenOnBoardException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameResult;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameStatus;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Player;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.PlayerMove;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Scanner;

class TicTacToeGame {
	private final FieldCoordinatesTranslator translator = new FieldCoordinatesTranslator();
	private final Scanner scan = new Scanner(System.in);
	private SingleGame game;
	private final Player playerOne;
	private final Player playerTwo;
	private final int boardSize;
	Symbol SYMBOL_O = new Symbol('O');

	TicTacToeGame(final Player playerOne, final Player playerTwo, final int boardSize) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.boardSize = boardSize;
	}

	void play() {
		game = new SingleGame(playerOne, playerTwo, boardSize);
		final BoardPrinter printer = new BoardPrinter(boardSize);
		GameResult latestResult;

		Player nextPlayer = setWhichPlayerMakesFirstMove();

		do {
			printer.printBoard(game.getBoardView());
			System.out.println(nextPlayer.getName() + " (" + nextPlayer.getSymbol() + ") please enter coordinates (e.g. C2) with unoccupied place");
			latestResult = placeSymbol(game, translator, nextPlayer);
			nextPlayer = getNextPlayer(nextPlayer);
		} while (latestResult.getGameStatus().equals(GameStatus.IN_PROGRESS));

		printer.printBoard(game.getBoardView());
		printResultOfTheGame(latestResult);

		askIfPlayAgain();
	}

	private Player setWhichPlayerMakesFirstMove() {
		Player nextPlayer;
		if (playerOne.getSymbol().equals(SYMBOL_O)) {
			nextPlayer = playerOne;
		} else {
			nextPlayer = playerTwo;
		}
		return nextPlayer;
	}

	private GameResult placeSymbol(final SingleGame game, final FieldCoordinatesTranslator translator, final Player nextPlayer) {
		final FieldCoordinates coordinates = getFieldCoordinates(game, translator);
		try {
			return game.makeMove(nextPlayer, new PlayerMove(coordinates.getRow(), coordinates.getColumn()));
		} catch (SpotAlreadyTakenOnBoardException exception) {
			System.out.println("Spot is taken, choose different number");
			return placeSymbol(game, translator, nextPlayer);
		}
	}

	private FieldCoordinates getFieldCoordinates(final SingleGame game, final FieldCoordinatesTranslator translator) {
		try {
			final String line = getSpot();
			return translator.toCoordinates(line, boardSize);
		} catch (WrongCoordinatesException e) {
			System.out.println("Choose valid coordinates.");
			return getFieldCoordinates(game, translator);
		}
	}

	private Player getNextPlayer(final Player nextPlayer) {
		return nextPlayer == playerTwo ? playerOne : playerTwo;
	}

	private void printResultOfTheGame(final GameResult result) {
		if (GameStatus.WIN.equals(result.getGameStatus())) {
			System.out.println("Congratulations, " + result.getWhoWon() + " won the round.");
		} else if (GameStatus.DRAW.equals(result.getGameStatus())) {
			System.out.println("It's a draw.");
		} else {
			throw new IllegalArgumentException("Cannot printResultOfTheGame when game is in status:" + result.getGameStatus());
		}
	}

	private void askIfPlayAgain() {
		System.out.println("Would you like to play again? (1 - yes, 2 - no)");
		int playAgain = getNumber(scan);
		if (playAgain == 1) {
			resetBoard(game.getBoardView());
			play();
		} else {
			System.out.println("Thanks for playing");
		}
	}

	private String getSpot() {
		return scan.nextLine();
	}

	private int getNumber(final Scanner scanner) {
		return Integer.parseInt(scanner.nextLine());
	}

	private void resetBoard(final Character[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
}
