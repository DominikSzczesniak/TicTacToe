package pl.szczesniak.dominik.tictactoe.singlegame.domain.model;

import pl.szczesniak.dominik.tictactoe.player.model.PlayerName;

public class Player {

    private final Symbol symbol;
    private final PlayerName name;

    public Player(final Symbol symbol, final PlayerName name) {
        this.symbol = symbol;
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerName getName() {
        return name;
    }

}
