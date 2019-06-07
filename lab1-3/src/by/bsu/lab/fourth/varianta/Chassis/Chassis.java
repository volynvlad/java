package by.bsu.lab.fourth.varianta.Chassis;

public abstract class Chassis {
    private String name;
    protected String type;

    {
        this.name = "My ";
        this.type = "Chassis";
    }

    public Chassis() {
    }

    public Chassis(String name) {
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
