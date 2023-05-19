package ru.makhotin;

import ru.makhotin.entities.Cell;

public class MapConsoleRenderer {
    public void render(Map map) {
        for (int i = 0; i <map.xMax; i++) {
            for (int j = 0; j < map.yMax; j++) {
                Cell cell = new Cell(i,j);
                if (!map.isEmptyCell(cell))
                    System.out.print("... ");
                else System.out.print(map.getEntity(cell).getPicture()+" ");
            }
            System.out.print("\n");
        }
    }
}
