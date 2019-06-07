package by.bsu.lecture.first;

public class SimpleAction {
    static int value;
    static {
        MAX_VALUE = 2;
    } // сработает раньше всех один раз за время выполнения всего приложения
    private static final int MAX_VALUE;
    //{
    //    System.out.println(this.value1);  // выведится 0
    //value1 = 77;
    //} // выполняется перед конструктором
    private int value1 = 5;
    // когда еще ни один конструктор не вызвался уже выделилась память под объект

    public SimpleAction(){
        // не надо вызывать из конструктора полиморфные методы
        // можно final static private
        //this.doAction();
        init();
    }
    // если писать метод(а не лог блок, то можно забыть вызвать этот метод в конструкторе,
    // а лог блоком вызывается автоматически для всех конструкторов
    public SimpleAction(int value1) {
        this.value1 = value1;
        // при вызове любого конструктора будет вызыватся лог блок { }
    }
    public void init(){
        System.out.println(this.value1);
    }

    private static void doAction(){
        // static method вызываются без создания объекта
        // и поля нельзя вызывать
        // статическое можно
        System.out.println(value + "doAction");
    }
}
