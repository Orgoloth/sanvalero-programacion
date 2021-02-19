package edu.sanvalero.manuel.examen;

abstract class BoardItem {
    protected Side side;
    protected Coordinate position;
    protected Board board;

    BoardItem(Side side, Coordinate position, Board board) {
        this.side = side;
        this.position = position;
        this.board = board;
    }

    Side side() {
        return this.side;
    }

    Coordinate position() {
        return this.position;
    }

    void move(Coordinate destiny) {
        this.position = destiny;
    }

    void act() {
    }

}
