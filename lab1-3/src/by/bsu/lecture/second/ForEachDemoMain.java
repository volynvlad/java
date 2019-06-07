package by.bsu.lecture.second;

import java.util.ArrayList;

public class ForEachDemoMain {
    public static void main(String[] args) {
        // StringBuilder - меняет внутреннее состояние
        //инициализация или анонимный класс
        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>() {
            {
                this.add(new StringBuilder("one"));
                this.add(new StringBuilder("two"));
                this.add(new StringBuilder("three"));
                this.add(new StringBuilder("four"));
                this.add(new StringBuilder("five"));
            }
        };

        // eto toge consumer
        list.removeIf(o -> o.toString().length() < 4);
        // another variant
        /*
        list.removeIf(o -> {
            boolean b = o.toString().length() < 4;
            return b;
        });
         */
        // tut nahoditsya lambda-function
        // eto consumer
        // parametr -> telo
        // lambda - anomimniy class
        list.forEach((o) -> o.append(" 1"));
        list.forEach(o -> {
            o.append(" 2");
            o.append(" 3");
        });
        System.out.println(list);
        list.stream().forEach((o) -> o.append(" 4")); //
        System.out.println(list);
        //list.stream().forEach(o -> o); tut vivodit oshibku
        list.stream().forEach(o -> new StringBuilder());
        System.out.println(list);
    }
}
