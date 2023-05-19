package ru.makhotin.entities;

abstract public class Creature extends Entity{
   final int speed;
   protected int  hp;
   abstract void  makeMove(Cell currCell) ;

    public Creature(String picture, int speed, int hp) {
        super(picture);
        this.speed = speed;
        this.hp = hp;
    }
}
