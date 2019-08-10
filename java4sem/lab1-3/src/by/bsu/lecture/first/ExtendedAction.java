package by.bsu.lecture.first;

public class ExtendedAction extends SimpleAction{
    public ExtendedAction() {
        this.doAction();
    }


    public static void doAction(){
        System.out.println(42);
    }
}
