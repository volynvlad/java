package com.company.gift.store;


import com.company.gift.entity.Sweet;
import com.company.gift.exception.StorageException;

import java.util.LinkedList;

public class SweetStorage {
    private LinkedList<Sweet> sweets;
    private static final SweetStorage INSTANCE = new SweetStorage();

    private SweetStorage() {
        this.sweets = new LinkedList<>();
    }

    public static SweetStorage getInstance() {
        return INSTANCE;
    }

    public void addSweet(Sweet sweet){
        sweets.addLast(sweet);
    }

    public Sweet takeSweet() throws StorageException {
        if(!sweets.isEmpty()) {
            return sweets.removeFirst();
        } else {
            throw new StorageException("SweetStorage is empty");
        }
    }

    public int countOfSweets(){
        return this.sweets.size();
    }

    public boolean isEmpty(){
        return sweets.isEmpty();
    }
}
