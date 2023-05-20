package ru.makhotin;

import ru.makhotin.entities.*;

import java.util.Random;

public class EntityFactory {
    public Entity fromRandomNumber(int number) {
        switch (number) {
            case 1 : return new Tree();
            case 2 : return new Rock();
            case 3 : return new Grass();
            case 4: return new Herbivore(new Random().nextInt(5), new Random().nextInt(5));
            case 5: return new Carnivore(new Random().nextInt(5), new Random().nextInt(5), new Random().nextInt(5));
            default:
                throw new RuntimeException("Unknown type Entity!");
        }

    }
}

