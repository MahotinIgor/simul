package ru.makhotin.entities;

import java.util.*;
import java.util.stream.Collectors;

import ru.makhotin.map.Map;

abstract public class Creature extends Entity{
   final int speed;
   protected Map map;
   protected int  hp;
    Deque<Cell> currentPath;
   public abstract void  makeMove(Cell currCell) ;

    public Creature(String picture, int speed, int hp, Map map) {
        super(picture);
        this.speed = speed;
        this.hp = hp;
        this.map = map;
    }
    public Set<Cell> getAvalibleMoveCells(Cell cell) {
        Set<Cell> result = new HashSet<>();

        for (CellShift shift: getCreatureMoves()) {
            if (cell.canShift(shift, map.xMax, map.yMax)) {
                Cell newCell = cell.shift(shift);
                if (isCellAvailableForMove(newCell, map)) {
                    result.add(newCell);
                }
            }
        }
        return result;
    }

    protected  Set<CellShift> getCreatureMoves() {
        return new HashSet<>(Arrays.asList(
                new CellShift( 1, - 1),
                new CellShift(- 1, 0),
                new CellShift( - 1,  1),
                new CellShift(0,  1),
                new CellShift( 1,  1),
                new CellShift( 1, 0),
                new CellShift( -1,  - 1),
                new CellShift(0,  - 1))
        );
    }
    public Cell isEatNear(Cell cell, Class<?> eat) {
//        Set<Cell> cellSet = new HashSet<>();
//        cellSet = getAvalibleMoveCells();
        for (CellShift shift: getCreatureMoves()) {
            if (cell.canShift(shift, map.xMax, map.yMax)) {
                Cell newCell = cell.shift(shift);
                if (!isCellAvailableForMove(newCell, map) && map.getEntity(newCell).getClass() == eat) {
                    return newCell;
                }
            }
        }
        return null;
    }
    public Deque<Cell> findPathToEat(Cell cell, Class<?> eat) {
        Deque<Cell> path = new ArrayDeque<>();

        Deque<Cell> toVisit = new ArrayDeque<>();
        toVisit.addAll(getAvalibleMoveCells(cell));
        //System.out.println(toVisit);

        while (!toVisit.isEmpty()) {
           // System.out.println("to visit="+toVisit);
            Cell visiting = toVisit.pollFirst();
            path.add(visiting);
            //System.out.println("path="+path);

            if (isEatNear(visiting,eat) != null) break;
            toVisit.addAll(getAvalibleMoveCells(visiting).stream().filter(c -> !path.contains(c)).collect(Collectors.toList()));
        }

        return path;
    }

    private boolean isCellAvailableForMove(Cell newCell, Map map) {
        return !map.isEmptyCell(newCell);
    }
    }
