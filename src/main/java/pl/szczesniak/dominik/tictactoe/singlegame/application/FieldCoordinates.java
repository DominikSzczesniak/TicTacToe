package pl.szczesniak.dominik.tictactoe.singlegame.application;

class FieldCoordinates {

    private final int row;
    private final int column;

    FieldCoordinates(final int row, final int column, final int boardSize) {
        this.row = row;
        this.column = column;
        if (row >= boardSize || column >= boardSize) {
            throw new WrongCoordinatesException();
        }
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
