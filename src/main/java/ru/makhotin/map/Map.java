package ru.makhotin.map;

import ru.makhotin.entities.*;

import java.util.HashMap;
import java.util.Random;

public class Map {

    public final int xMax;
    public final int yMax;

    HashMap<Cell, Entity> entitys = new HashMap<>();

    public Map(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public void setEntity(Cell cell, Entity entity) {
        entity.cell = cell;
        entitys.put(cell, entity);
    }
    public void render() {
        for (int i = 0; i <this.xMax; i++) {
            for (int j = 0; j < this.yMax; j++) {
                Cell cell = new Cell(i,j);
                if (!this.isEmptyCell(cell))
                    System.out.print("... ");
                else System.out.print(this.getEntity(cell).getPicture()+" ");
            }
            System.out.print("\n");
        }
    }

    public boolean isEmptyCell(Cell cell) {
        return entitys.containsKey(cell);
    }
    public Entity getEntity(Cell cell) {
        return entitys.get(cell);
    }
}
