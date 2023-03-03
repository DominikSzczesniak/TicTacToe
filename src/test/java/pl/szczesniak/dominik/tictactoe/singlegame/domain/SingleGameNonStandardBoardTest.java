package pl.szczesniak.dominik.tictactoe.singlegame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Name;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Player;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.PlayerMove;
import pl.szczesniak.dominik.tictactoe.singlegame.domain.model.Symbol;

import static org.assertj.core.api.Assertions.assertThat;
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
	void game_should_be_won_by_player_one_4x4_v1() {
		// given
		final SingleGame tut = new SingleGame(playerOne, playerTwo, 4);

		// when
		assertThat(tut.makeMove(playerOne, new PlayerMove(3, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(0, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(2, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(2, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(1, 3)).getGameStatus()).isEqualTo(WIN);

		// then
		assertThat(tut.getBoardView()).satisfies(board -> {
			assertThat(board[0]).containsExactly(null, null, null, 'X');
			assertThat(board[1]).containsExactly(null, null, null, 'O');
			assertThat(board[2]).containsExactly(null, 'X', null, 'O');
			assertThat(board[3]).containsExactly(null, null, null, 'O');
		});
	}

	@Test
	void game_should_be_won_by_player_one_4x4_v3() {
		// when
		final SingleGame tut = new SingleGame(playerOne, playerTwo, 4);

		// then
		assertThat(tut.makeMove(playerOne, new PlayerMove(2, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(3, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(1, 2)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(0, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(0, 3)).getGameStatus()).isEqualTo(WIN);
	}

	@Test
	void game_should_be_won_by_player_one_4x4_v2() {
		// when
		final SingleGame tut = new SingleGame(playerOne, playerTwo, 4);

		// then
		assertThat(tut.makeMove(playerOne, new PlayerMove(0, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(3, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(0, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(2, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(0, 2)).getGameStatus()).isEqualTo(WIN);
	}

	@Test
	void game_should_be_draw_4x4() {
		// when
		final SingleGame tut = new SingleGame(playerOne, playerTwo, 4);

		// then
		assertThat(tut.makeMove(playerOne, new PlayerMove(0, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(0, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(0, 2)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(0, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(1, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(1, 2)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(1, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(1, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(2, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(2, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(2, 2)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(2, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(3, 0)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(3, 1)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerOne, new PlayerMove(3, 3)).getGameStatus()).isEqualTo(IN_PROGRESS);
		assertThat(tut.makeMove(playerTwo, new PlayerMove(3, 2)).getGameStatus()).isEqualTo(DRAW);


		// ...

		assertThat(tut.getBoardView()).satisfies(board -> {
			assertThat(board[0]).containsExactly('X', 'O', 'O', 'X');
			assertThat(board[1]).containsExactly('O', 'X', 'X', 'O');
			assertThat(board[2]).containsExactly('X', 'O', 'O', 'X');
			assertThat(board[3]).containsExactly('O', 'X', 'X', 'O');
		});
	}
}