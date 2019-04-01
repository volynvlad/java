package com.company.gift.valid;

import com.company.gift.entity.*;
import com.company.gift.util.SweetTags;
import com.company.gift.util.TypeSweet;
//валидация, является ли строка информацией о сладости
public class SweetValidator {

    public static boolean isValidSweet(String sweet){
        sweet = sweet.toUpperCase();
        return sweet.contains(SweetTags.ID) && sweet.contains(SweetTags.NAME) && sweet.contains(SweetTags.PRODUCER) &&
                sweet.contains(SweetTags.TYPE) && sweet.contains(SweetTags.SUGAR) && sweet.contains(SweetTags.WEIGHT);
    }

    public static boolean isValidCandy(String sweet){
        sweet = sweet.toUpperCase();
        return isValidSweet(sweet) && sweet.contains(SweetTags.TASTE);
    }

    public static boolean isValidGlazedCandy(String sweet){
        sweet = sweet.toUpperCase();
        return isValidCandy(sweet) && sweet.contains(SweetTags.FROSTING);
    }

    public static boolean isValidLollipop(String sweet){
        sweet = sweet.toUpperCase();
        return isValidCandy(sweet) && sweet.contains(SweetTags.FORM);
    }

    public static boolean isValidWafer(String sweet){
        sweet = sweet.toUpperCase();
        return isValidSweet(sweet) && sweet.contains(SweetTags.AROMA);
    }

    public static boolean isValidAroma(String aromaStr){
        Aroma[] aromas = Aroma.values();
        for(Aroma aroma : aromas){
            if(aroma.toString().equalsIgnoreCase(aromaStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidForm(String formStr){
        Form[] forms = Form.values();
        for(Form form : forms){
            if(form.toString().equalsIgnoreCase(formStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidTaste(String tasteStr){
        Taste[] tastes = Taste.values();
        for(Taste taste : tastes){
            if(taste.toString().equalsIgnoreCase(tasteStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidProducer(String producerStr){
        Producer[] producers = Producer.values();
        for(Producer producer : producers){
            if(producer.toString().equalsIgnoreCase(producerStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidFrosting(String frostingStr){
        Frosting[] frostings = Frosting.values();
        for(Frosting frosting : frostings){
            if(frosting.toString().equalsIgnoreCase(frostingStr)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSweetType(String typSweetStr){
        TypeSweet[] typeSweets = TypeSweet.values();
        for(TypeSweet typeSweet : typeSweets){
            if(typeSweet.toString().equalsIgnoreCase(typSweetStr)){
                return true;
            }
        }
        return false;
    }
}
