package ru.makhotin.entities;

import ru.makhotin.map.Map;

public class Herbivore extends Creature{

    public Herbivore(int speed, int hp, Map map) {

        super("Трв", speed, hp,map);
    }

    @Override
    public void makeMove(Cell currCell) {
        //for (int step = 0; step < this.speed; step++) {

            //check if there is grass nearby;
            var grassOnCell =this.isEatNear(currCell, Grass.class) ;

            if (grassOnCell != null) {
                System.out.println("Herbivore found grass on cell x: " + (grassOnCell.x+1) + " y:" + (grassOnCell.y +1)+ " and ate it. Yum!");
                map.delete(grassOnCell);
                //rerender
                this.map.render();
                System.out.println();
            }



               // break;
            //}
    }
}
