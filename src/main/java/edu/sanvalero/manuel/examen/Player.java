package edu.sanvalero.manuel.examen;

import java.util.Scanner;

public class Player extends BoardItem {
    private static final Scanner sc = new Scanner(System.in);

    private int lifes;

    public Player(Side side, Coordinate position, Board board) {
        super(side, position, board);
        this.lifes = Config.INITIAL_LIFES;
    }

    public void hurt() {
        this.lifes--;
    }

    public void heal() {
        this.lifes++;
    }

    public boolean isDead() {
        return this.lifes <= 0;
    }

    public int lifes() {
        return this.lifes;
    }

    public void act() {
        Direction direction = this
                .askDirection("¿En que direccion quieres moverte? [" + Direction.getAllDirections() + "]");
        Coordinate destiny = this.position().moveInDirection(direction);

        this.checkConsequences(destiny);
        this.move(destiny);
    }

    private Direction askDirection(String pregunta) {
        Direction direction = null;
        char tecla;
        do {
            System.out.println(pregunta);
            tecla = sc.next().charAt(0);
            tecla = Character.toUpperCase(tecla);
            direction = Direction.keyDirection(tecla);
        } while (direction == null);
        return direction;
    }

    private void checkConsequences(Coordinate destiny) {
        BoardItem boardItemOnDestiny = this.board.boardItemsRepository().itemInCoordinate(destiny);

        if (boardItemOnDestiny == null)
            return;

        if (boardItemOnDestiny.side == this.side.foe()) {
            this.hurt();
            System.out.println("Has encontrado un ENEMIGO, pierdes una vida...");
        }

        if (boardItemOnDestiny.side == Side.POTION) {
            this.heal();
            this.board.boardItemsRepository().remove(boardItemOnDestiny);
            System.out.println("Has encontrado un POCION, ganas una vida...");
        }
    }
}
