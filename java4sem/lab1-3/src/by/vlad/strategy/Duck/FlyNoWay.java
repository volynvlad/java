package by.vlad.strategy.Duck;

public class FlyNoWay implements FlyBehavior {
    public void fly(){
        System.out.println("A can't fly!!!");
    }
}
