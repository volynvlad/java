package com.company.gift.action;

import com.company.gift.entity.Gift;
import com.company.gift.entity.Sweet;
import com.company.gift.exception.IncorrectValueException;

import java.util.LinkedList;
import java.util.List;

public class SweetFinder {
    public LinkedList<Sweet> findBySugar(Gift gift, float minSugarCont, float maxSugarCont) throws IncorrectValueException {
        if(minSugarCont >= 0 && maxSugarCont >= 0 && minSugarCont <= maxSugarCont){
            LinkedList<Sweet> result = new LinkedList<>();
            List<Sweet> sweets = gift.getSweets();
            for(Sweet sweet : sweets){
                if(sweet.getAmountOfSugar() >= minSugarCont && sweet.getAmountOfSugar() <= maxSugarCont){
                    result.add(sweet);
                }
            }
            return result;
        }else{
            throw new IncorrectValueException("Incorrect arguments");
        }
    }
}
