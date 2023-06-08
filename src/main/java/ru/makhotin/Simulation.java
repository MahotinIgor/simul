package ru.makhotin;

import ru.makhotin.map.Map;
import ru.makhotin.map.MapFactory;

public class Simulation {

    MapFactory mapFactory = new MapFactory();
    Map map = mapFactory.generateStartMap(10,10,20);

    public void nextTurn() {

    }
}
