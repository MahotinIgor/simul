package ru.makhotin.entities;

public class Cell {
    public final int x;
    public final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Cell shift(CellShift shift) {
        return new Cell(this.x+shift.shiftX, this.y+shift.shiftY);
    }
    public boolean canShift(CellShift shift, int xMax, int yMax) {
        int resX = shift.shiftX + this.x;
        if (resX<0 || resX > xMax) return false;
        int resY = shift.shiftY + this.y;
        if (resY<0 || resY > yMax) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
