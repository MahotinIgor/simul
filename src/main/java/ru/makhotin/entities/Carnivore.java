package ru.makhotin.entities;

import ru.makhotin.map.Map;

public class Carnivore extends Creature{
    private int attak;
    public Carnivore(int speed, int hp, int attak, Map map) {
        super("Хищ", speed, hp, map);
        this.attak = attak;
    }

    @Override
    public void makeMove(Cell currCell) {

    }

}
