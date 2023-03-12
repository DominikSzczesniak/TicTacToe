package pl.szczesniak.dominik.tictactoe.singlegame.application;

import java.util.Objects;

class FieldCoordinates {

    private final int row;
    private final int column;

    FieldCoordinates(final int row, final int column, final int boardSize) {
        if (row < 0 || row > boardSize - 1 || column < 0 || column > boardSize - 1) {
            throw new WrongCoordinatesException();
        }
        if (row >= boardSize || column >= boardSize) {
            throw new WrongCoordinatesException();
        }
        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FieldCoordinates that = (FieldCoordinates) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "FieldCoordinates{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
