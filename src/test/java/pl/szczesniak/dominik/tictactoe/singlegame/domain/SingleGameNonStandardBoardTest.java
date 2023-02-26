package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.OtherPlayerTurnException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.PlayerIsNotThePartOfTheGameException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SpotAlreadyTakenOnBoardException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.SymbolIsUnsupportedException;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameResult;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Name;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Player;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.PlayerMove;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.fail;
import static pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameStatus.DRAW;
import static pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameStatus.IN_PROGRESS;
import static pl.szczesniak.dominik.tictactoe.singlegame.domain.model.GameStatus.WIN;

class SingleGameNonStandardBoardTest {

    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() {
        playerOne = new Player(new Symbol('O'), new Name("playerOne"));
        playerTwo = new Player(new Symbol('X'), new Name("playerTwo"));
    }

    @Test
    void name() {
        fail("TODO: GameOverException when some won");
    }
    @Test
    void name2() {
        fail("TODO: GameOverException when DRAW");
    }
}