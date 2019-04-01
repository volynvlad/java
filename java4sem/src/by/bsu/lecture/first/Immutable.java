package by.bsu.lecture.first;

public class Immutable {
    private int a;
    private String str;
    //это неизменяемый тип данных
    //у него должен быть 1 конструктор
    public Immutable(int a, String str) {
        this.a = a;
        this.str = str;
    }

    public int getA() {
        return a;
    }

    public String getStr() {
        return str;
    }
}
