package by.vlad.SimplePizzaFactory;

public class ClamPizza extends Pizza {
    String type = "Clam";
    public void prepare(){
        System.out.println(type + " preparing\n");
    }
    public void bake(){
        System.out.println(type + " baking\n");
    }
    public void cut(){
        System.out.println(type + "cuting\n");
    }
    public void box(){
        System.out.println(type + "boxing\n");
    }
}
