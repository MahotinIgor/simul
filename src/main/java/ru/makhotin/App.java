package ru.makhotin;

import ru.makhotin.map.Map;
import ru.makhotin.entities.*;
import ru.makhotin.map.MapFactory;

import java.util.Deque;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        MapFactory mapFactory = new MapFactory();
        Map map = mapFactory.generateStartMap(10,10,20);
        map.setEntity(new Cell(0,0), new Carnivore(10,10,10, map));
        map.setEntity(new Cell(9,9), new Herbivore(10,10, map));
        //map.setEntity(new Cell(9,8), new Grass());
        Creature creature = (Creature) map.getEntity(new Cell(0,0));
        Set<Cell> avCell = creature.getAvalibleMoveCells(creature.cell);
        map.render();
        System.out.println("");

        Creature creature1 = (Creature) map.getEntity(new Cell(9,9));
        //Cell eatCell = creature1.isEatNear(new Cell(9,9), Grass.class);
        //Set<Cell> avCell1 = creature1.getAvalibleMoveCells(creature1.cell);
       // Deque path1 = creature1.findPathToEat(creature1.cell, Grass.class);


        int b=123;
        creature1.makeMove();




       // System.out.println(map.getCreaturesFromMap());
        //for(Creature trv: map.getCreaturesFromMap())
          //  trv.makeMove(trv.cell);
        int a = 123;
    }
}
