package pl.szczesniak.dominik.tictactoe.game.application;

import pl.szczesniak.dominik.tictactoe.gamehistory.adapter.OverwritingFileGameHistoryStorage;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.GameHistoryService;
import pl.szczesniak.dominik.tictactoe.gamehistory.domain.SingleGameResult;
import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.SingleGame;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SpotAlreadyTakenOnBoardException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameResult;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameStatus;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Player;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.PlayerMove;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Scanner;

public class TicTacToeConsoleApp {

	private final GameHistoryService gameHistoryService = new GameHistoryService(new OverwritingFileGameHistoryStorage());
	final Scanner scan = new Scanner(System.in);
	private final Player playerOne;
	private final Player playerTwo;
	private int playAgain;
	private final FieldNumberTranslator translator = new FieldNumberTranslator();

	public TicTacToeConsoleApp() {
		System.out.println();
		System.out.println("|----------------------------------------|");
		System.out.println("|Welcome to a single game of tic tac toe.|");
		System.out.println("|----------------------------------------|");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("|The game consists of 2 players, each with a symbol - X or O, player with symbol O gets to move first.|");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Player 1, choose your name:");
		PlayerName nameOne = new PlayerName(scan.nextLine());
		System.out.println(nameOne.getName() + " choose your symbol, enter O or X");
		playerOne = new Player(new Symbol(getSymbol(scan)), nameOne);
		System.out.println("Player 2, choose your name");
		if (playerOne.getSymbol().getValue() == 'O') {
		playerTwo = new Player(new Symbol('X'), new PlayerName(scan.nextLine()));
		} else {
		playerTwo = new Player(new Symbol('O'), new PlayerName(scan.nextLine()));
		}

	}

	public void run() {
		final BoardPrinter printer = new BoardPrinter();
		final SingleGame game = new SingleGame(playerOne, playerTwo);
		printer.printBoardWithNumbers(game.getBoardView());
		GameResult latestResult;
		Player nextPlayer;

		if (playerOne.getSymbol().getValue() == 'O') {
			nextPlayer = playerOne;
		} else {
			nextPlayer = playerTwo;
		}

		do {
			printer.printBoard(game.getBoardView());
			System.out.println(nextPlayer.getName() + " (" + nextPlayer.getSymbol() + ") please enter a number 1-9 with unoccupied place");
			latestResult = makeMove(game, scan, translator, nextPlayer);
			nextPlayer = nextPlayer == playerTwo ? playerOne : playerTwo;
		} while (latestResult.getGameStatus().equals(GameStatus.IN_PROGRESS));

		printer.printBoard(game.getBoardView());
		printResultOfTheGame(latestResult);
		SingleGameResult singleGameResult = new SingleGameResult(latestResult.getWhoWon());
		gameHistoryService.store(singleGameResult);
		System.out.println("Number of " + latestResult.getWhoWon() + "'s wins: " + gameHistoryService.loadPlayerScore(latestResult.getWhoWon()).getValue());

		System.out.println("Would you like to play again? (1 - yes, 2 - no)");
		playAgain = getNumber(scan);
		if (playAgain == 1) {
			resetBoard(game.getBoardView());
			run();
		} else {
			System.out.println("Thanks for playing");
		}
	}

	private GameResult makeMove(SingleGame game, Scanner scan, FieldNumberTranslator translator, Player nextPlayer) {
		final FieldCoordinates coordinates = translator.toCoordinates(getNumber(scan));
		try {
			return game.makeMove(nextPlayer, new PlayerMove(coordinates.getRow(), coordinates.getColumn()));
		} catch (SpotAlreadyTakenOnBoardException exception) {
			System.out.println("Spot is taken, choose different number");
			return makeMove(game, scan, translator, nextPlayer);
		}
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

	private void resetBoard(Character[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	private int getNumber(Scanner scanner) {
		return Integer.parseInt(scanner.nextLine());
	}

	private char getSymbol(Scanner scanner) {
		String symbol = scanner.nextLine();
		return symbol.charAt(0);
	}
}
