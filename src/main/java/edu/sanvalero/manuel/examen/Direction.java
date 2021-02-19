package edu.sanvalero.manuel.examen;

public enum Direction {
    UP('W'), DOWN('S'), LEFT('A'), RIGHT('D'), UP_LEFT('Q'), UP_RIGHT('E'), DOWN_LEFT('Z'), DOWN_RIGHT('X');

    static {
        UP.coordinate = new Coordinate(-1, 0);
        DOWN.coordinate = new Coordinate(1, 0);
        LEFT.coordinate = new Coordinate(0, -1);
        RIGHT.coordinate = new Coordinate(0, 1);
        UP_LEFT.coordinate = new Coordinate(-1, -1);
        UP_RIGHT.coordinate = new Coordinate(-1, 1);
        DOWN_LEFT.coordinate = new Coordinate(1, -1);
        DOWN_RIGHT.coordinate = new Coordinate(1, 1);
    }

    private final char key;
    private Coordinate coordinate;

    Direction(char key) {
        this.key = key;
    }

    public char key() {
        return key;
    }

    public Coordinate coordinate() {
        return this.coordinate;
    }

    public static Direction keyDirection(char key) {
        for (Direction direction : Direction.values()) {
            if (direction.key() == key) {
                return direction;
            }
        }
        return null;
    }

    public static String getAllDirections() {
        String directions = "";
        for (Direction direction : Direction.values()) {
            if (directions.equals("")) {
                directions = "" + direction.key();
            } else {
                directions = directions + ", " + direction.key();
            }
        }
        return directions;
    }
}
