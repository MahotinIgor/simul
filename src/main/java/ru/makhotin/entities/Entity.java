package ru.makhotin.entities;

abstract public class Entity {
    public final String picture;

    public Entity(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public Cell cell;
}
