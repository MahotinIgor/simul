package ru.makhotin;

import ru.makhotin.map.Map;
import ru.makhotin.entities.*;
import ru.makhotin.map.MapFactory;

import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        MapFactory mapFactory = new MapFactory();
        Map map = mapFactory.generateStartMap(10,10,30);
        map.setEntity(new Cell(0,0), new Carnivore(10,10,10, map));
        Creature creature = (Creature) map.getEntity(new Cell(0,0));
        Set<Cell> avCell = creature.getAvalibleMoveCells();
        map.render();

        int a = 123;
    }
}
