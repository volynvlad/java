package by.bsu.vlad.entity;

public abstract class Place extends Entity {
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public Place(long id) {
        super(id);
    }

}