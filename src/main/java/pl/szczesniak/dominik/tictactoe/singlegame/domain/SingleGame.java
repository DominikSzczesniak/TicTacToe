package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.GameOverException;
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

    private static final Set<Symbol> SUPPORTED_SYMBOLS = Set.of(new Symbol('X'), new Symbol('O'));

    private final Board board;
    private final Player playerOne;
    private final Player playerTwo;

    private Player latestMoveByPlayer;
    private boolean gameOver;

    public SingleGame(final Player playerOne, final Player playerTwo, final int boardSize) { // FIXME: -> VO BoardSize 3;6
        if (SUPPORTED_SYMBOLS.stream().noneMatch(marker -> marker.getValue() == playerOne.getSymbol().getValue())) {
            throw new SymbolIsUnsupportedException("Symbol " + playerOne.getSymbol().getValue() + " is unsupported.");
        }
        if (SUPPORTED_SYMBOLS.stream().noneMatch(marker -> marker.getValue() == playerTwo.getSymbol().getValue())) {
            throw new SymbolIsUnsupportedException("Symbol " + playerTwo.getSymbol().getValue() + " is unsupported.");
        }
        if (boardSize < 3) {
            throw new SizeNotSupportedException("Board must be size 3 or bigger");
        }
        board = new Board(boardSize, boardSize);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Character[][] getBoardView() {
        return board.getCurrentState();
    }

    public GameResult makeMove(final Player player, final PlayerMove move) {
        checkGameNotOver();
        checkPlayerIsPartOfSingleGame(player);
        checkIsPlayerTurn(player);
        checkIsSpotNotTaken(player, move);

        board.placeSymbol(player.getSymbol().getValue(), move.getRowIndex(), move.getColumnIndex());
        latestMoveByPlayer = player;

        final GameResult result = resolveGameResult(move);
        gameOver = !result.getGameStatus().equals(GameStatus.IN_PROGRESS);
        return result;
    }

    private void checkGameNotOver() {
        if (gameOver) {
            throw new GameOverException("Game is already over.");
        }
    }

    private void checkPlayerIsPartOfSingleGame(final Player player) {
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

    private GameResult resolveGameResult(final PlayerMove move) {
        if (checkIfPlayerWon(latestMoveByPlayer, move)) {
            return new GameResult(GameStatus.WIN, latestMoveByPlayer);
        }
        if (isDraw()) {
            return new GameResult(GameStatus.DRAW, null);
        }
        return new GameResult(GameStatus.IN_PROGRESS, null);
    }

    private boolean checkIfPlayerWon(final Player player, final PlayerMove move) {
        final SymbolOnBoardCounter counter = new SymbolOnBoardCounter(player.getSymbol(), getBoardView());
        return counter.countSymbolInSequence(move.getRowIndex(), move.getColumnIndex()) >= 3;//FIXME make game more playable
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
