package ru.makhotin.entities;

public class Herbivore extends Creature{

    public Herbivore(int speed, int hp) {

        super("Трв", speed, hp);
    }

    @Override
    void makeMove(Cell currCell) {

    }
}
