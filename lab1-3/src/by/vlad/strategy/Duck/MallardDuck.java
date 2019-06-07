package by.vlad.strategy.Duck;

public class MallardDuck extends Duck {
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display(){
        System.out.println("A'm a real Mallard duck!");
    }
}
