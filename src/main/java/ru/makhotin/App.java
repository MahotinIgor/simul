package ru.makhotin;

public class App 
{
    public static void main( String[] args )
    {
        Map map = new Map(10,10);
        map.setupDefaultEntityPositions();

        MapConsoleRenderer consoleRenderer = new MapConsoleRenderer();
        consoleRenderer.render(map);

        int a = 123;
    }
}
