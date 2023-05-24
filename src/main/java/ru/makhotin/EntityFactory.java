package ru.makhotin;

import ru.makhotin.entities.*;
import ru.makhotin.map.Map;

import java.util.Random;

public class EntityFactory {
    private  Map map;
    public Entity fromRandomNumber(int number, Map map) {
        switch (number) {
            case 1 : return new Tree();
            case 2 : return new Rock();
            case 3 : return new Grass();
            case 4: return new Herbivore(new Random().nextInt(5), new Random().nextInt(5),map);
            case 5: return new Carnivore(new Random().nextInt(5), new Random().nextInt(5), new Random().nextInt(5), map);
            default:
                throw new RuntimeException("Unknown type Entity!");
        }

    }
}

