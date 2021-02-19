package edu.sanvalero.manuel.examen;

public class AppExamen {

    public static void main(String[] args) {
        new Game();
    }

    static void clearConsole() {
        int linesLeft = Config.EMPTY_LINES;
        while (linesLeft-- > 0) {
            System.out.println();
        }
    }
}
