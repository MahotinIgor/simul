package ru.makhotin.entities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import ru.makhotin.map.Map;

abstract public class Creature extends Entity{
   final int speed;
   private Map map;
   protected int  hp;
   abstract void  makeMove(Cell currCell) ;

    public Creature(String picture, int speed, int hp, Map map) {
        super(picture);
        this.speed = speed;
        this.hp = hp;
        this.map = map;
    }
    public Set<Cell> getAvalibleMoveCells() {
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

    private boolean isCellAvailableForMove(Cell newCell, Map map) {
        return !map.isEmptyCell(newCell);
    }
    }
