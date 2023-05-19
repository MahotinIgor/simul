package ru.makhotin.entities;

public class Herbivore extends Creature{

    public Herbivore(String picture, int speed, int hp) {

        super(picture, speed, hp);
    }

    @Override
    void makeMove(Cell currCell) {

    }
}
