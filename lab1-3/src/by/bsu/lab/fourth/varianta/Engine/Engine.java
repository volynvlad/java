package by.bsu.lab.fourth.varianta.Engine;

public abstract class Engine {
    protected String name;
    protected String type;
    {
        this.name = "My ";
        this.type = "Engine";
    }

    public Engine() {
    }

    public Engine(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return this.name + this.type;
    }
}
