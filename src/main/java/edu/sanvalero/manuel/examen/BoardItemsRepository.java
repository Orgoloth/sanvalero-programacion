package edu.sanvalero.manuel.examen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardItemsRepository {
    private List<BoardItem> boardItems = new ArrayList<>();

    public boolean containsItemIn(Coordinate questionedCoordinate) {
        Iterator<BoardItem> iterator = this.boardItems.iterator();
        while (iterator.hasNext()) {
            BoardItem current = iterator.next();
            if (current.position().equals(questionedCoordinate)) {
                return true;
            }
        }
        return false;
    }

    public BoardItem itemInCoordinate(Coordinate destiny) {
        Iterator<BoardItem> iterator = this.boardItems.iterator();
        while (iterator.hasNext()) {
            BoardItem current = iterator.next();
            if (current.position().equals(destiny)) {
                return current;
            }
        }
        return null;
    }

    public void add(BoardItem item) {
        if (this.containsItemIn(item.position())) {
            throw new IllegalArgumentException(
                    "No se permite introducir un elemento con una coordenada que ya tenga un elemento del repositorio");
        }
        this.boardItems.add(item);
    }

    public void remove(BoardItem item) {
        Iterator<BoardItem> iterator = this.boardItems.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == item) {
                iterator.remove();
                return;
            }
        }
    }

    public Iterator<BoardItem> iterator() {
        return this.boardItems.iterator();
    }

}
