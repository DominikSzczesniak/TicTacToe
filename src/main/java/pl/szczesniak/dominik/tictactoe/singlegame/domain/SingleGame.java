package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.OtherPlayerTurnException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.PlayerIsNotThePartOfTheGameException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SizeNotSupportedException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SpotAlreadyTakenOnBoardException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SymbolIsUnsupportedException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameResult;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameStatus;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Player;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.PlayerMove;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import java.util.Set;

public class SingleGame {

    private final Board board;
    private final Set<Symbol> supportedSymbols = Set.of(new Symbol('X'), new Symbol('O'));
    private final Player playerOne;
    private final Player playerTwo;
    private Player latestMoveByPlayer;

    public SingleGame(Player playerOne, Player playerTwo, int size) {
        if (supportedSymbols.stream().noneMatch(marker -> marker.getValue() == playerOne.getSymbol().getValue())) {
            throw new SymbolIsUnsupportedException("Symbol " + playerOne.getSymbol().getValue() + " is unsupported.");
        }
        if (supportedSymbols.stream().noneMatch(marker -> marker.getValue() == playerTwo.getSymbol().getValue())) {
            throw new SymbolIsUnsupportedException("Symbol " + playerTwo.getSymbol().getValue() + " is unsupported.");
        }
        if (size < 3) {
            throw new SizeNotSupportedException("Board must be size 3 or bigger");
        }
        board = new Board(size, size);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public Character[][] getBoardView() {
        return board.getCurrentState();
    }

    public GameResult makeMove(final Player player, final PlayerMove move) {
        checkPlayerIsPartOfSingleGame(player);
        checkIsPlayerTurn(player);
        checkIsSpotNotTaken(player, move);
        board.placeSymbol(player.getSymbol().getValue(), move.getRowIndex(), move.getColumnIndex());
        latestMoveByPlayer = player;
        return resolveGameResult(move);
    }

    private void checkPlayerIsPartOfSingleGame(Player player) {
        if (!player.equals(playerOne) && !player.equals(playerTwo)) {
            throw new PlayerIsNotThePartOfTheGameException("Player " + player + " is not part of the game");
        }
    }

    private void checkIsPlayerTurn(final Player player) {
        if (latestMoveByPlayer != null && latestMoveByPlayer.equals(player)) {
            throw new OtherPlayerTurnException("Player " + player + " can't make more than one turn in a row");
        }
    }

    private void checkIsSpotNotTaken(final Player player, final PlayerMove move) {
        if (board.isSpotTaken(move.getRowIndex(), move.getColumnIndex())) {
            throw new SpotAlreadyTakenOnBoardException("Player " + player + " can't make a move. Spot is already taken.");
        }
    }

    private GameResult resolveGameResult(PlayerMove move) {
        if (checkIfPlayerWon(latestMoveByPlayer, move)) {
            return new GameResult(GameStatus.WIN, latestMoveByPlayer);
        }
        if (isDraw()) {
            return new GameResult(GameStatus.DRAW, null);
        }

        return new GameResult(GameStatus.IN_PROGRESS, null);
    }

//    private boolean checkIfPlayerWon(final Player player) {
//        Character[][] arrayForChecks = getBoardView();
//        return false;
//    }

    private boolean checkIfPlayerWon(final Player player, final PlayerMove move) {
        final char symbol = player.getSymbol().getValue();
        Character[][] arrayForChecks = getBoardView();


        if (checkHorizontally(symbol, arrayForChecks, move)) {
            return true;
        }
        if (checkVertically(symbol, arrayForChecks, move)) {
            return true;
        }
        if (checkDiagonally(symbol, arrayForChecks, move)) {
            return true;
        }

        return false;
    }

    private boolean checkHorizontally(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) {
        if (!checkHorizontalLeft(symbol, arrayForChecks, move) && !checkHorizontalRight(symbol, arrayForChecks, move))
            return false;

        return true;
    }

    private boolean checkVertically(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) {
        if (!checkVerticalDown(symbol, arrayForChecks, move) && !checkVerticalUp(symbol, arrayForChecks, move))
            return false;

        return true;
    }

    private boolean checkDiagonally(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) {
        if (!checkDiagonalRightUp(symbol, arrayForChecks, move) && !checkDiagonalLeftDown(symbol, arrayForChecks, move) &&
                !checkDiagonalRightDown(symbol, arrayForChecks, move) && !checkDiagonalLeftUp(symbol, arrayForChecks, move))
            return false;

        return true;
    }

    private boolean checkHorizontalRight(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie prawej strony od symbolu
        if (board.getColumnNumber() - move.getColumnIndex() > 2) {
            for (int column = move.getColumnIndex(); column <= board.getColumnNumber() - 1; column++) {
                if (arrayForChecks[move.getRowIndex()][column] == null || arrayForChecks[move.getRowIndex()][column] != symbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkHorizontalLeft(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie lewel strony od symbolu
        if (move.getColumnIndex() >= 2) {
            for (int column = move.getColumnIndex(); column >= move.getColumnIndex() - 2; column--) {
                if (arrayForChecks[move.getRowIndex()][column] == null || arrayForChecks[move.getRowIndex()][column] != symbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkVerticalUp(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie gory od symbolu
        if (move.getRowIndex() >= 2) {
            for (int row = move.getRowIndex(); row >= move.getRowIndex() - 2; row--) {
                if (arrayForChecks[row][move.getColumnIndex()] == null || arrayForChecks[row][move.getColumnIndex()] != symbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkVerticalDown(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie dolu od symbolu
        if (board.getRowsNumber() - move.getRowIndex() > 2) {
            for (int row = move.getRowIndex(); row <= board.getRowsNumber() - 2; row++) {
                if (arrayForChecks[row][move.getColumnIndex()] == null || arrayForChecks[row][move.getColumnIndex()] != symbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDiagonalRightUp(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie prawo gora od symbolu
        int row;
        row = move.getRowIndex();
        if (board.getColumnNumber() - move.getColumnIndex() > 2 && move.getRowIndex() >= 2) {
            for (int column = move.getColumnIndex(); column <= board.getColumnNumber() - 1; column++) {
                if (arrayForChecks[row][column] == null || arrayForChecks[row][column] != symbol) {
                    return true;
                }
                row--;
            }
        }
        return false;
    }

    private boolean checkDiagonalLeftDown(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie lewo dol od symbolu
        int row;
        row = move.getRowIndex();
        if (move.getColumnIndex() >= 2 && board.getRowsNumber() - move.getRowIndex() > 2) {
            for (int column = move.getColumnIndex(); column >= move.getColumnIndex() - 2; column--) {
                if (arrayForChecks[row][column] == null || arrayForChecks[row][column] != symbol) {
                    return false;
                }
                row++;
            }
        }
        return true;
    }

    private boolean checkDiagonalRightDown(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie prawo dol od symbolu
        int row;
        row = move.getRowIndex();
        if (board.getColumnNumber() - move.getColumnIndex() > 2 && board.getRowsNumber() - move.getRowIndex() > 2) {
            for (int column = move.getColumnIndex(); column <= board.getColumnNumber() - 1; column++) {
                if (arrayForChecks[row][column] == null || arrayForChecks[row][column] != symbol) {
                    return false;
                }
                row++;
            }
        }
        return true;
    }

    private static boolean checkDiagonalLeftUp(final char symbol, final Character[][] arrayForChecks, final PlayerMove move) { // sprawdzenie lewo gora od symbolu
        int row = move.getRowIndex();
        if (move.getRowIndex() >= 2 && move.getColumnIndex() >= 2) {
            for (int column = move.getColumnIndex(); column >= move.getColumnIndex() - 2; column--) {
                if (arrayForChecks[row][column] == null || arrayForChecks[row][column] != symbol) {
                    return false;
                }
                row--;
            }
        }
        return true;
    }

    public boolean isDraw() {
        final Character[][] drawArray = getBoardView();
        for (int i = 0; i < board.getRowsNumber(); i++) {
            for (int k = 0; k < board.getColumnNumber(); k++) {
                if (drawArray[i][k] == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
