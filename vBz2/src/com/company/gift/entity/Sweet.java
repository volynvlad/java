package com.company.gift.entity;

//Сладость базовый абстрактный класс
public abstract class Sweet {
    private long sweetId;
    private String name;
    private Producer producer;
    private double weight;
    private double amountOfSugar;

    public Sweet(long sweetId, String name, Producer producer, double weight, double amountOfSugar) {
        this.sweetId = sweetId;
        this.name = name;
        this.producer = producer;
        this.weight = weight;
        this.amountOfSugar = amountOfSugar;
    }

    public long getSweetId() {
        return sweetId;
    }

    public String getName() {
        return name;
    }

    public Producer getProducer() {
        return producer;
    }

    public double getWeight() {
        return weight;
    }

    public double getAmountOfSugar() {
        return amountOfSugar;
    }
}
