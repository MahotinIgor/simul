package ru.makhotin.entities;

import java.util.Arrays;
import java.util.HashSet;
import ru.makhotin.map.Map;
import java.util.Set;

public class Carnivore extends Creature{
    private int attak;
    public Carnivore(int speed, int hp, int attak, Map map) {
        super("Хищ", speed, hp, map);
        this.attak = attak;
    }

    @Override
    void makeMove(Cell currCell) {

    }

    @Override
    protected Set<CellShift> getCreatureMoves() {
        return new HashSet<>(Arrays.asList(
                new CellShift( 1, - 1),
                new CellShift(- 1, 0),
                new CellShift( - 1,  1),
                new CellShift(0,  1),
                new CellShift( 1,  1),
                new CellShift( 1, 0),
                new CellShift( 1,  - 1),
                new CellShift(0,  - 1))
        );
    }
}
