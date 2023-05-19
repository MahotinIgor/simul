package ru.makhotin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Map map = new Map(10,10);
        map.setupDefaultEntityPositions();

        MapConsoleRenderer consoleRenderer = new MapConsoleRenderer();
        consoleRenderer.render(map);

        int a = 123;
    }
}
