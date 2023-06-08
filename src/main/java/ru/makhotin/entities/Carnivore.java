package ru.makhotin.entities;

import ru.makhotin.map.Map;

public class Carnivore extends Creature{
    private int attak;
    public Carnivore(int speed, int hp, int attak, Map map) {
        super("Хищ", speed, hp, map);
        this.attak = attak;
    }

    @Override
    public void makeMove() {
        for (int step = 0; step < this.speed; step++) {

            //check if there is Herbivore nearby;
            var eatOnCell = isEatNear(this.cell, Herbivore.class) ;

            if (eatOnCell != null) {
                System.out.println("Carnivore found Herbivore on cell x: " + (eatOnCell.x) + " y:" + (eatOnCell.y)+ " and attack it. RRR!");
                Herbivore herbivore = (Herbivore) map.getEntity(eatOnCell);
                herbivore.hp=-attak;
                if(herbivore.hp<0) {
                    System.out.println("Carnivore eat Herbivore on cell x: " + (eatOnCell.x) + " y:" + (eatOnCell.y));
                    map.delete(eatOnCell);
                    //rerender
                    map.move(this.cell, eatOnCell);
                    this.cell = eatOnCell;
                    this.map.render();
                    System.out.println();
                }
                break;
            }

            if(this.currentPath.size() == 0) {
                this.currentPath = findPathToEat(this.cell, Herbivore.class);
            }
            else {
                Cell cellStep = this.currentPath.pollFirst();
                map.move(this.cell, cellStep);
                map.render();
                this.cell = cellStep;
            }

        }

    }

}
