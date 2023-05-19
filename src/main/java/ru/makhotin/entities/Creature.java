package ru.makhotin.entities;

abstract public class Creature extends Entity{
   protected int speed;
   protected int  hp;
   abstract void  makeMove(Cell currCell) ;

    public Creature(String picture) {
        super(picture);
    }
}
