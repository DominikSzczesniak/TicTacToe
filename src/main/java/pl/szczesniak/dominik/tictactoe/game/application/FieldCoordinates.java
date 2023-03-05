package pl.szczesniak.dominik.tictactoe.game.application;

public class FieldCoordinates {
    private final int row;
    private final int column;

    public FieldCoordinates(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
