package by.bsu.lecture.first;

class Picture{}
public class Main {
    public static void main(String[] args) {
        /*
        ExtendedAction extendedAction = null;
        // статические методы не рекомендуется вызывать через ссылку на объект(с объектами тоже самое)
        // get set не пишутся для static полей
        // static редко бывают приватными и
        // доступ к статическим полям и методам через имя класса
        extendedAction.doAction();
        int a = ExtendedAction.value;
        //SimpleAction action = new ExtendedAction();
        //Client client = new Client();
        //client.execute(action);

        Role role = Role.valueOf("guest".toUpperCase());
        role.method();
        System.out.println("Current " + role.getCurrentUserNumber());
        role.setCurrentUserNumber(256);
        System.out.println("Current " + role.getCurrentUserNumber());
        */

        Post<Long, String> post = new Post<>();
        post.setMessage("123");
        Post post1 = new Post(); // так не писать
        Post<Short, Picture> post2 = new Post<>();
        post1 = post;
        post2 = post1;
        // String s = post.getMessage();
        Picture sb = post2.getMessage();
        // post = post2;
    }
}
