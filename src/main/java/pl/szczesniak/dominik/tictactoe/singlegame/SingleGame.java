package pl.szczesniak.dominik.tictactoe.singlegame;

import pl.szczesniak.dominik.tictactoe.exceptions.OtherPlayerTurnException;
import pl.szczesniak.dominik.tictactoe.exceptions.PlayerIsNotThePartOfTheGameException;
import pl.szczesniak.dominik.tictactoe.exceptions.SpotAlreadyTakenOnBoardException;
import pl.szczesniak.dominik.tictactoe.exceptions.SymbolIsUnsupportedException;
import java.util.Set;

import static pl.szczesniak.dominik.tictactoe.singlegame.GameStatus.*;

public class SingleGame {

    private final Board board;
//    private final Set<Symbol> supportedSymbols = Set.of(new Symbol('X'), new Symbol('O'));
    private final Player playerOne;
    private final Player playerTwo;
    private Player latestMoveByPlayer;

    public SingleGame(Player playerOne, Player playerTwo) {
//        if (supportedSymbols.stream().noneMatch(marker -> marker.getValue() == playerOne.getSymbol().getValue())) {
//            throw new SymbolIsUnsupportedException("Symbol " + playerOne.getSymbol().getValue() + " is unsupported.");
//        }
//        if (supportedSymbols.stream().noneMatch(marker -> marker.getValue() == playerTwo.getSymbol().getValue())) {
//            throw new SymbolIsUnsupportedException("Symbol " + playerTwo.getSymbol().getValue() + " is unsupported.");
//        }
        board = new Board(3, 3);
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
        return resolveGameResult();
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

    private GameResult resolveGameResult() {
        if (checkIfPlayerWon(latestMoveByPlayer)) {
            return new GameResult(WIN, latestMoveByPlayer);
        }
        if (isDraw()) {
            return new GameResult(DRAW, null);
        }

        return new GameResult(IN_PROGRESS, null);
    }

    private boolean checkIfPlayerWon(final Player player) {
        final char symbol = player.getSymbol().getValue();

        if (checkHorizontally(symbol)) {
            return true;
        }
        if (checkVertically(symbol)) {
            return true;
        }
        if (checkDiagonally(symbol)) {
            return true;
        }

        return false;
    }

    private boolean checkDiagonally(char symbol) {
        if (board.hasSymbolOnFields(symbol, new PairOfCoordinates(0, 0), new PairOfCoordinates(1, 1), new PairOfCoordinates(2, 2))) {
            return true;
        }
        if (board.hasSymbolOnFields(symbol, new PairOfCoordinates(0, 2), new PairOfCoordinates(1, 1), new PairOfCoordinates(2, 0))) {
            return true;
        }
        return false;
    }

    private boolean checkVertically(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board.hasSymbolOnFields(symbol, new PairOfCoordinates(0, i), new PairOfCoordinates(1, i), new PairOfCoordinates(2, i))){
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontally(char symbol) {
        for (int i = 0; i < 3; i++) {
        if (board.hasSymbolOnFields(symbol, new PairOfCoordinates(i, 0), new PairOfCoordinates(i, 1), new PairOfCoordinates(i, 2))) {
            return true;
        }
        }
        return false;
    }

    boolean isDraw() {
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
