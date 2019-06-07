package by.vlad.strategy.Sort;

public class Strategy {
    public static void main(String[] args){
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1,5,6,-12};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {66,5,8,-2};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr1);

        int[] arr2 = {9,-7,-5,12};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);
    }
}
