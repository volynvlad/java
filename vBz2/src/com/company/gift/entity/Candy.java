package com.company.gift.entity;

//+
//Конфета=сладость+вкус
public abstract class Candy extends Sweet {
    private Taste taste;

    public Candy(long sweetId, String name, Producer producer, double weight, double amountOfSugar, Taste taste) {
        super(sweetId, name, producer, weight, amountOfSugar);
        this.taste = taste;
    }

    public Taste getTaste() {
        return taste;
    }

}
