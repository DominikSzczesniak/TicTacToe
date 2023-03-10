package pl.szczesniak.dominik.tictactoe.singlegame.domain.model;

public class GameResult {
    private final GameStatus gameStatus;
    private final Player whoWon;

    public GameResult(final GameStatus gameStatus, final Player whoWon) {
        if (gameStatus.equals(GameStatus.WIN) && whoWon == null) {
            throw new IllegalArgumentException("Game status = WIN, player whoWon cannot be null.");
        }
        if (!gameStatus.equals(GameStatus.WIN) && whoWon != null) {
            throw new IllegalArgumentException("Game status = " + gameStatus + ", player whoWon must be null.");
        }
        this.gameStatus = gameStatus;
        this.whoWon = whoWon;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Name getWhoWon() {
        return whoWon.getName();
    }


}
