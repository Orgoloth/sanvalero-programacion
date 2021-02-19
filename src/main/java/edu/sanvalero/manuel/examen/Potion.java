package edu.sanvalero.manuel.examen;

public class Potion extends BoardItem {
    public Potion(Side side, Coordinate position, Board board) {
        super(side, position, board);
    }

    @Override
    public void act() {
        this.move(this.board.getFreeRandomCoordinate());
    }
}
