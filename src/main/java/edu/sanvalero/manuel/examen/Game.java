package edu.sanvalero.manuel.examen;

public class Game {

    private Board[] boards;

    Game() {
        configure();
        run();
    }

    private void configure() {
        this.boards = new Board[Config.playerSides.length];
        for (int i = 0; i < Config.playerSides.length; i++) {
            this.boards[i] = new Board(Config.playerSides[i]);
        }
    }

    private void run() {
        Board actualBoard = null;
        int round = 0;
        do {
            actualBoard = this.boards[round % Config.playerSides.length];
            actualBoard.run();
            round++;
        } while (!actualBoard.isPlayerDead());
        printLoser(actualBoard);
    }

    private void printLoser(Board loserBoard) {
        System.out.println("El jugador " + loserBoard.playerSide() + " ha perdido");
    }

}