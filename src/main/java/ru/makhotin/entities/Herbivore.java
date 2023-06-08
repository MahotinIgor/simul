package ru.makhotin.entities;

import ru.makhotin.map.Map;

import java.util.Deque;

public class Herbivore extends Creature{

    public Herbivore(int speed, int hp, Map map) {

        super("Трв", speed, hp,map);
    }

    @Override
    public void makeMove() {

        for (int step = 0; step < this.speed; step++) {

            //check if there is grass nearby;
            var grassOnCell =this.isEatNear(this.cell, Grass.class) ;

            if (grassOnCell != null) {
                System.out.println("Herbivore found grass on cell x: " + (grassOnCell.x) + " y:" + (grassOnCell.y)+ " and ate it. Yum!");
                map.delete(grassOnCell);
                //rerender
                this.map.render();
                System.out.println();
                 break;
            }
            Cell cellStep = this.findPathToEat(this.cell, Grass.class).pollFirst();

            if (cellStep==null) {
                currentPath.addAll(this.findPathToEat(this.cell, Grass.class));
                cellStep = this.currentPath.pollFirst();
            }

            map.move(this.cell, cellStep);
            map.render();
            this.cell = cellStep;

        }
    }
}
