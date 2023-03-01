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
    private boolean checkIfPlayerWon(final Player player, final PlayerMove move) {
        Character[][] arrayForChecks = getBoardView();
        SymbolOnBoardCounter counter = new SymbolOnBoardCounter(player.getSymbol(), arrayForChecks);

        if (counter.countSymbolInSequenceHorizontally(move.getRowIndex()) >= 3) {
            return true;
        }
        if (counter.maxCountSymbolInSequenceVertically(move.getColumnIndex()) >= 3) {
            return true;
        }
        if (counter.countSymbolInSequenceDiagonally(move.getRowIndex(), move.getColumnIndex()) >= 3) {
            return true;
        }

        return false;
    }

    private boolean isDraw() {
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
