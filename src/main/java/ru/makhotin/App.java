package ru.makhotin;

import ru.makhotin.map.Map;
import ru.makhotin.map.MapFactory;

public class App
{
    public static void main( String[] args )
    {
        MapFactory mapFactory = new MapFactory();
        Map map = mapFactory.generateStartMap(10,10,30);

        MapConsoleRenderer consoleRenderer = new MapConsoleRenderer();
        consoleRenderer.render(map);

        int a = 123;
    }
}
