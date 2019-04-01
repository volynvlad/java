package com.company.gift.compare;

import com.company.gift.entity.Sweet;

import java.util.Comparator;

public class SweetWeightComparator implements Comparator<Sweet>{
    @Override
    public int compare(Sweet o1, Sweet o2) {
        if(o1.getWeight() > o2.getWeight()){
            return 1;
        }else if(o1.getWeight() < o2.getWeight()){
            return -1;
        }else{
            return 0;
        }
    }

}
