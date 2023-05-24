package ru.makhotin.entities;

import java.util.Set;
import ru.makhotin.map.Map;

public class Herbivore extends Creature{

    public Herbivore(int speed, int hp, Map map) {

        super("Трв", speed, hp,map);
    }

    @Override
    void makeMove(Cell currCell) {

    }


}
