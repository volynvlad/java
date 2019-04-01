package com.company.gift.entity;

import com.company.gift.exception.InvalidDataException;

import java.util.LinkedList;

public class Gift {
    private LinkedList<Sweet> sweets;
    private double weight;

    public Gift(LinkedList<Sweet> sweets) {
        this.sweets = sweets;
        for(Sweet sweet : sweets){
            this.weight += sweet.getWeight();
        }
    }

    public Gift(){
        this.sweets = new LinkedList<>();
        this.weight = 0;
    }

    public void addSweet(Sweet sweet){
        sweets.addLast(sweet);
        this.weight += sweet.getWeight();
    }

    public LinkedList<Sweet> getSweets(){
        return this.sweets;
    }

    public double getWeight() {
        return weight;
    }

//Метод нужен, чтобы перезанести ту же коллекцию, но в другом порядке, например, отсортированную.
//Просто перезанести новую коллекцию, с новыми, другими членами этим методом нельзя.
    public void setSweets(LinkedList<Sweet> sweets) throws InvalidDataException {
        if(this.sweets.containsAll(sweets) && sweets.containsAll(this.sweets)){
            this.sweets = sweets;
        }
        else{
            throw new InvalidDataException("Contain of gift can not be change with method setSweets");
        }
    }


}
