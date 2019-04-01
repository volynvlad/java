package com.company.gift.action;

import com.company.gift.entity.Gift;
import com.company.gift.exception.StorageException;
import com.company.gift.store.SweetStorage;

public class GiftMaker {
    public Gift make(int countOfSweet) throws StorageException {
        SweetStorage storage = SweetStorage.getInstance();
        Gift gift = new Gift();
        if(storage.countOfSweets() >= countOfSweet){
            for(int i = 0; i < countOfSweet; i++){
                gift.addSweet(storage.takeSweet());
            }
            return gift;
        } else {
            throw new StorageException("Storage do not have enough sweets");
        }
    }
}
