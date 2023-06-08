package ru.makhotin.map;

import ru.makhotin.entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {

    public final  int xMax;
    public final  int yMax;

    public Map(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }
    HashMap<Cell, Entity> entitys = new HashMap<>();

    public void setEntity(Cell cell, Entity entity) {
        entity.cell = cell;
        entitys.put(cell, entity);
    }
    public boolean isEmptyCell(Cell cell) {
        return !entitys.containsKey(cell);
    }
    public Entity getEntity(Cell cell) {
        return entitys.get(cell);
    }
    public void render() {
        for (int i = 0; i <this.xMax; i++) {
            for (int j = 0; j < this.yMax; j++) {
                Cell cell = new Cell(i,j);
                if (this.isEmptyCell(cell))
                    System.out.print(i+"."+j+" ");
                else System.out.print(this.getEntity(cell).getPicture()+" ");
            }
            System.out.print("\n");
        }
    }
    public void delete(Cell cell) {
        entitys.remove(cell);
    }
    public void move(Cell start, Cell end) {
        if (!this.isEmptyCell(start) && this.isEmptyCell(end)){
            System.out.println(" start move " + start.x + " "+start.y+" to " + end.x
                    + " " +end.y );
            this.setEntity(end, this.getEntity(start));
            this.delete(start);
        }
    }

    public Set<Creature> getCreaturesFromMap() {
        Set<Creature> creatureSet = new HashSet<>();
        for(Entity entity:entitys.values()) {
            if(entity.getClass().getSimpleName().equals("Herbivore") )//||
                    //entity.getClass().getSimpleName().equals("Carnivore") )
                creatureSet.add((Creature) entity);
        }
        System.out.println(creatureSet.size());
        return creatureSet;
    }
}
