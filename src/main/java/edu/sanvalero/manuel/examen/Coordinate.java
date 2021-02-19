package edu.sanvalero.manuel.examen;

import java.util.Random;

public class Coordinate {

    private static final Random generador = new Random();

    private final int row;
    private final int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int row() {
        return this.row;
    }

    public int column() {
        return this.column;
    }

    public Coordinate moveInDirection(Direction direction) {
        if (!forbiddenDirection(direction)) {
            return new Coordinate((this.row + Config.ROWS + direction.coordinate().row()) % Config.ROWS,
                    (this.column + Config.COLUMNS + direction.coordinate().column()) % Config.COLUMNS);
        } else {
            return new Coordinate(this.row, this.column);
        }

    }

    private boolean forbiddenDirection(Direction direction) {
        if (this.row == 0 && this.column == 0 && direction.coordinate().row == -1
                && direction.coordinate().column == -1) {
            return true;
        }
        if (this.row == Config.ROWS - 1 && this.column == 0 && direction.coordinate().row == 0
                && direction.coordinate().column == -1) {
            return true;
        }
        if (this.row == 0 && this.column == Config.COLUMNS - 1 && direction.coordinate().row == -1
                && direction.coordinate().column == 0) {
            return true;
        }
        return false;

    }

    public static Coordinate generateRandom() {
        return new Coordinate(generador.nextInt(Config.ROWS), generador.nextInt(Config.COLUMNS));
    }

    @Override
    public String toString() {
        return "(" + this.row + ", " + this.column + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Coordinate otro = (Coordinate) o;
        if (this == otro) {
            return true;
        }
        return this.row() == otro.row() && this.column() == otro.column();

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.row;
        hash = 59 * hash + this.column;
        return hash;
    }

}
