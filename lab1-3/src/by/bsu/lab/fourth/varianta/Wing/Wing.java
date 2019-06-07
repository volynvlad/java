package by.bsu.lab.fourth.varianta.Wing;

public abstract class Wing {
    protected String name;
    protected String type;
    {
        this.name = "My ";
        type = "Wing";
    }

    public Wing() {}

    public Wing(String name) {
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
