package edu.sanvalero.raul;

import java.util.Random;
import java.util.Scanner;

public class Examen {

    static final char LIBRE = 'L';
    static final char POCIMA = 'P';
    static final int FILAS_TABLERO = 5;
    static final int COLUMNAS_TABLERO = 5;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int filasYoda = random.nextInt(5);
        int columnasYoda = random.nextInt(5);
        int filasVader = random.nextInt(5);
        int columnasVader = random.nextInt(5);
        char YODA = 'Y';
        char VADER = 'V';
        char MAUL = 'D';
        char R2 = 'R';
        int vidasYoda = 3;
        int vidasVader = 3;
        int pocimasYoda = 3;
        int pocimasVader = 3;
        int[] parametros;
        char[][] tableroYoda = new char[FILAS_TABLERO][COLUMNAS_TABLERO];
        char[][] tableroVader = new char[FILAS_TABLERO][COLUMNAS_TABLERO];

        tableroJuego(tableroYoda);
        tableroJuego(tableroVader);

        situarJugador(tableroYoda, YODA, filasYoda, columnasYoda);
        situarJugador(tableroVader, VADER, filasVader, columnasVader);

        situarEnemigo(tableroYoda, MAUL);
        situarEnemigo(tableroVader, R2);

        repartirPocimas(tableroYoda, pocimasYoda);
        repartirPocimas(tableroVader, pocimasVader);

        while (vidasYoda > 0 && vidasVader > 0) {
            System.out.println("A continuación se muestra la posición actual del tablero de YODA");
            mostrarTablero(tableroYoda);
            parametros = movimiento(tableroYoda, vidasYoda, YODA, MAUL, filasYoda, columnasYoda, pocimasYoda);
            vidasYoda = parametros[0];
            filasYoda = parametros[1];
            columnasYoda = parametros[2];
            pocimasYoda = parametros[3];
            repartirPocimas(tableroYoda, pocimasYoda);

            if (vidasYoda > 0) {
                System.out.println("A continuación se muestra la posición actual del tablero de VADER");
                mostrarTablero(tableroVader);
                parametros = movimiento(tableroVader, vidasVader, VADER, R2, filasVader, columnasVader, pocimasVader);
                vidasVader = parametros[0];
                filasVader = parametros[1];
                columnasVader = parametros[2];
                pocimasVader = parametros[3];
                repartirPocimas(tableroVader, pocimasVader);
            } else {
                System.out.println("YODA HA PERDIDO!!");
            }
            if (vidasVader == 0) {
                System.out.println("VADER HA PERDIDO!!");
            }
        }


    }

    public static int[] movimiento(char[][] tablero, int vidas, char JUGADOR, char ENEMIGO, int filasJugador, int columnasJugador, int pocimas) {
        tablero[filasJugador][columnasJugador] = LIBRE;
        System.out.println("Introduzca un movimiento");
        String movimiento = sc.nextLine();

        switch (movimiento) {
            case "W":
            case "w":
                if (filasJugador != 0 || columnasJugador != 4) {
                    if (filasJugador == 0) {
                        filasJugador = 4;
                    } else {
                        filasJugador--;
                    }
                }
                break;

            case "S":
            case "s":
                if (filasJugador == 4) {
                    filasJugador = 0;
                } else {
                    filasJugador++;
                }
                break;

            case "A":
            case "a":
                if (filasJugador != 4 || columnasJugador != 0) {
                    if (columnasJugador == 0) {
                        columnasJugador = 4;
                    } else {
                        columnasJugador--;
                    }
                }

                break;

            case "D":
            case "d":
                if (columnasJugador == 4) {
                    columnasJugador = 0;
                } else {
                    columnasJugador++;
                }
                break;

            case "Q":
            case "q":
                if (filasJugador == 0 && columnasJugador == 0) {
                } else {
                    if (filasJugador == 0) {
                        filasJugador = 4;
                        columnasJugador--;
                    } else {
                        if (columnasJugador == 0) {
                            filasJugador--;
                            columnasJugador = 4;
                        } else {
                            filasJugador--;
                            columnasJugador--;
                        }
                    }
                }
                break;

            case "E":
            case "e":
                if (filasJugador == 0 && columnasJugador == 4) {
                    filasJugador = 4;
                    columnasJugador = 0;
                } else {
                    if (filasJugador == 0) {
                        filasJugador = 4;
                        columnasJugador++;
                    } else {
                        if (columnasJugador == 4) {
                            filasJugador--;
                            columnasJugador = 0;
                        } else {
                            filasJugador--;
                            columnasJugador++;
                        }
                    }
                }
                break;

            case "Z":
            case "z":
                if (filasJugador == 4 && columnasJugador == 0) {
                    filasJugador = 0;
                    columnasJugador = 4;
                } else {
                    if (filasJugador == 4) {
                        filasJugador = 0;
                        columnasJugador--;
                    } else {
                        if (columnasJugador == 0) {
                            filasJugador++;
                            columnasJugador = 4;
                        } else {
                            filasJugador++;
                            columnasJugador--;
                        }
                    }
                }
                break;

            case "X":
            case "x":
                if (filasJugador == 4 && columnasJugador == 4) {
                    filasJugador = 0;
                    columnasJugador = 0;
                } else {
                    if (filasJugador == 4) {
                        filasJugador = 0;
                        columnasJugador++;
                    } else {
                        if (columnasJugador == 4) {
                            filasJugador++;
                            columnasJugador = 0;
                        } else {
                            filasJugador++;
                            columnasJugador++;
                        }
                    }
                }
                break;
            default:
                System.out.println("Movimiento incorrecto");
        }
        if (tablero[filasJugador][columnasJugador] == ENEMIGO) {
            vidas--;
            System.out.println("Ha perdido una vida, Le quedan " + vidas + " vidas");
        }
        if (tablero[filasJugador][columnasJugador] == POCIMA) {
            vidas++;
            pocimas--;
            System.out.println("Ha ganado una vida, Le quedan " + vidas + " vidas");
        }
        tablero[filasJugador][columnasJugador] = JUGADOR;

        int[] parametros = new int[4];
        parametros[0] = vidas;
        parametros[1] = filasJugador;
        parametros[2] = columnasJugador;
        parametros[3] = pocimas;
        return parametros;
    }

    public static void mostrarTablero(char[][] tablero) {
        int i = 0;
        int j = 0;
        for (i = 0; i < FILAS_TABLERO; i++) {
            System.out.println("");
            for (j = 0; j < COLUMNAS_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void tableroJuego(char[][] tablero) {
        int i = 0;
        int j = 0;
        for (i = 0; i < FILAS_TABLERO; i++) {
            for (j = 0; j < COLUMNAS_TABLERO; j++) {
                tablero[i][j] = LIBRE;
            }
        }
    }

    public static void situarJugador(char[][] tablero, char JUGADOR, int filasJugador, int columnasJugador) {
        tablero[filasJugador][columnasJugador] = JUGADOR;
    }

    public static void situarEnemigo(char[][] tablero, char ENEMIGO) {
        int filasAleatorio;
        int columnasAleatorio;
        int numeroEnemigos = 5;
        int i = 0;
        for (i = 0; i < numeroEnemigos; i++) {
            filasAleatorio = random.nextInt(5);
            columnasAleatorio = random.nextInt(5);
            if (tablero[filasAleatorio][columnasAleatorio] == 'L') {
                tablero[filasAleatorio][columnasAleatorio] = ENEMIGO;
            } else {
                i--;
            }
        }
    }

    public static void repartirPocimas(char[][] tablero, int numeroPocimas) {
        int filasAleatorio;
        int columnasAleatorio;
        int i = 0;
        int x = 0;
        int j = 0;

        for (x = 0; x < FILAS_TABLERO; x++) {
            for (j = 0; j < COLUMNAS_TABLERO; j++) {
                if (tablero[x][j] == POCIMA) {
                    tablero[x][j] = LIBRE;
                }
            }
        }
        for (i = 0; i < numeroPocimas; i++) {
            filasAleatorio = random.nextInt(3);
            columnasAleatorio = random.nextInt(3);
            if (tablero[filasAleatorio][columnasAleatorio] == LIBRE) {
                tablero[filasAleatorio][columnasAleatorio] = POCIMA;
            } else {
                i--;
            }
        }
    }
}