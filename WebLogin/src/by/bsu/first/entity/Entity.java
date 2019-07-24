package by.bsu.first.entity;

import java.io.Serializable;

/**
 * Created by Ihar_Blinou on 10/21/2015.
 */
public abstract class Entity implements Serializable, Cloneable {
    private int id;

    @Override
    public int hashCode() {
        return id;
    }

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
