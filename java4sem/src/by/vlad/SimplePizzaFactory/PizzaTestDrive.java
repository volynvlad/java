package by.vlad.SimplePizzaFactory;

public class PizzaTestDrive {
    public static void main(String[] args) {

        System.out.println("%java PizzaTestDrive");

        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel oredered a " + pizza.getName() + "\n");
    }
}
