package com.company.gift.entity;

//+
//Вафля сладость + аромат
public class Wafer extends Sweet {
    private Aroma aroma;

    public Wafer(long sweetId, String name, Producer producer, double weight, double amountOfSugar, Aroma aroma) {
        super(sweetId, name, producer, weight, amountOfSugar);
        this.aroma = aroma;
    }

    public Aroma getAroma() {
        return aroma;
    }

    @Override
    public String toString() {
        return "Wafer{" +
                "id=" + getSweetId() +
                ", name='" + getName()  +
                ", producer=" + getProducer() +
                ", weight=" + getWeight() +
                ", amount of sugar" + getAmountOfSugar() +
                ", aroma=" + aroma +
                "}\n";
    }
}
