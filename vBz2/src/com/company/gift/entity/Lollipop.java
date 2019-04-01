package com.company.gift.entity;
//+
//леденец=конфета+форма
public class Lollipop extends Candy {
    private  Form form;

    public Lollipop(long sweetId, String name, Producer producer, double weight, double amountOfSugar, Taste taste, Form form) {
        super(sweetId, name, producer, weight, amountOfSugar, taste);
        this.form = form;
    }

    public Form getForm() {
        return form;
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                "id=" + getSweetId() +
                ", name='" + getName() +
                ", producer=" + getProducer() +
                ", weight=" + getWeight() +
                ", amount of sugar=" + getAmountOfSugar() +
                ", taste=" + getTaste() +
                ", form=" + form +
                "}\n";
    }
}
