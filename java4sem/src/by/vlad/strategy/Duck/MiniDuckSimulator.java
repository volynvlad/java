package by.vlad.strategy.Duck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        System.out.println("%Mallard duck simulator%");
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
