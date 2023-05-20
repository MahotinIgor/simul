package ru.makhotin.entities;

public class Carnivore extends Creature{
    private int attak;
    public Carnivore(int speed, int hp, int attak) {
        super("Хищ", speed, hp);
        this.attak = attak;
    }

    @Override
    void makeMove(Cell currCell) {

    }
}
