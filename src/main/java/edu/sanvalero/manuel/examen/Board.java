package edu.sanvalero.manuel.examen;

import java.util.Iterator;

public class Board {

    private BoardItemsRepository boardItemsRepository = new BoardItemsRepository();
    private Player player;

    public Board(Side side) {
        this.placePlayer(side);
        this.placeEnemies(side.foe());
        this.placePotions();
    }

    public Coordinate getFreeRandomCoordinate() {
        Coordinate randomCoordinate;
        do {
            randomCoordinate = Coordinate.generateRandom();
        } while (boardItemsRepository.containsItemIn(randomCoordinate));
        return randomCoordinate;

    }

    public boolean isPlayerDead() {
        return this.player.isDead();
    }

    public Side playerSide() {
        return this.player.side();
    }

    public BoardItemsRepository boardItemsRepository() {
        return this.boardItemsRepository;
    }

    public void run() {
        AppExamen.clearConsole();
        this.printStatus();
        this.playerAction();
        this.boardItemsActions();
    }

    private void placePlayer(Side side) {
        this.player = new Player(side, this.getFreeRandomCoordinate(), this);
        this.boardItemsRepository.add(this.player);
    }

    private void placeEnemies(Side side) {
        for (int i = Config.ENEMIES; i > 0; i--) {
            BoardItem newEnemy = new Enemy(side, this.getFreeRandomCoordinate(), this);
            this.boardItemsRepository.add(newEnemy);
        }
    }

    private void placePotions() {
        for (int i = Config.POTIONS; i > 0; i--) {
            BoardItem newPotion = new Potion(Side.POTION, this.getFreeRandomCoordinate(), this);
            this.boardItemsRepository.add(newPotion);
        }
    }

    private void printStatus() {
        System.out.println("JUGADOR: " + this.player.side.name());
        System.out.println("VIDAS RESTANTES: " + this.player.lifes());
        System.out.println("TABLERO:");
        System.out.println(this.boardGridToString());
    }

    private void playerAction() {
        this.player.act();
    }

    private void boardItemsActions() {
        Iterator<BoardItem> iterator = this.boardItemsRepository.iterator();
        while (iterator.hasNext()) {
            BoardItem current = iterator.next();
            if (current != this.player) {
                current.act();
            }
        }
    }

    private String[][] boardGrid() {
        String[][] boardGrid = new String[Config.ROWS][Config.COLUMNS];

        Iterator<BoardItem> iterator = this.boardItemsRepository.iterator();
        while (iterator.hasNext()) {
            BoardItem current = iterator.next();
            boardGrid[current.position().row()][current.position().column()] = String
                    .valueOf(current.side().abbreviation());
            boardGrid[this.player.position().row()][this.player.position().column()] = String
                    .valueOf(this.playerSide().abbreviation());
        }
        return boardGrid;
    }

    private String boardGridToString() {
        String boardGridToString = new String();
        String[][] boardGrid = this.boardGrid();
        for (int i = 0; i < boardGrid.length; i++) {
            for (int j = 0; j < boardGrid[i].length; j++) {
                if (boardGrid[i][j] == null) {
                    boardGridToString = boardGridToString.concat(Config.EMPTY + " ");
                } else {
                    boardGridToString = boardGridToString.concat(boardGrid[i][j] + " ");
                }
            }
            boardGridToString = boardGridToString.concat("\n");
        }
        return boardGridToString;
    }
}
