package ru.makhotin;

import ru.makhotin.entities.Cell;
import ru.makhotin.entities.Entity;
import ru.makhotin.entities.Rock;

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
    public void setupDefaultEntityPositions() {
        for (int i = 0; i < 3; i++) {
            setEntity(new Cell(new Random().nextInt(xMax), new Random().nextInt(yMax)),
                    new Rock("Гор"));
        }
    }
}
