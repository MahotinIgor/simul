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
                System.out.println("Herbivore found grass on cell x: " + (grassOnCell.x+1) + " y:" + (grassOnCell.y +1)+ " and ate it. Yum!");
                map.delete(grassOnCell);
                //rerender
                this.map.render();
                System.out.println();
                 break;
            }
            currentPath = this.findPathToEat(this.cell, Grass.class);
            if (currentPath.size()==0) break;
            else {
                Cell cellHod = currentPath.pollFirst();
                map.move(this.cell, cellHod);
                map.render();
            }
        }
    }
}
