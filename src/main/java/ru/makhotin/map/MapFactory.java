package ru.makhotin.map;

import ru.makhotin.EntityFactory;
import ru.makhotin.entities.Cell;

import java.util.Random;

public class MapFactory {
    private final EntityFactory entityFactory = new EntityFactory();


    public Map generateStartMap(int xMax, int yMax, int factorRandom) {
        Map map  = new Map(xMax, yMax);

        for (int i = 0; i < xMax; i++) {
            for (int j = 0; j < yMax; j++) {
                int numb = new Random().nextInt(factorRandom);
                if (numb<=5 && numb >0)
                    map.setEntity(new Cell(i,j), entityFactory.fromRandomNumber(numb, map));
            }
        }
        return map;
    }
}
