package com.company.gift.entity;
//+
//Глазированная конфета=коннфета+глазурь
public class GlazedCandy extends Candy {
    private Frosting frosting;

    public GlazedCandy(long sweetId, String name, Producer producer, double weight, double amountOfSugar, Taste taste, Frosting frosting) {
        super(sweetId, name, producer, weight, amountOfSugar, taste);
        this.frosting = frosting;
    }

    public Frosting getFrosting() {
        return frosting;
    }

    @Override
    public String toString() {
        return "GlazedCandy{" +
                "id=" + getSweetId() +
                ", name='" + getName() +
                ", producer=" + getProducer() +
                ", weight=" + getWeight() +
                ", amount of sugar=" + getAmountOfSugar() +
                ", taste=" + getTaste() +
                ", frosting=" + frosting +
                "}\n";
    }
}
