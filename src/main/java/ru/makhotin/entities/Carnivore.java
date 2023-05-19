package ru.makhotin.entities;

public class Carnivore extends Creature{
    private int attak;
    public Carnivore(String picture, int speed, int hp, int attak) {
        super(picture, speed, hp);
        this.attak = attak;
    }

    @Override
    void makeMove(Cell currCell) {

    }
}
