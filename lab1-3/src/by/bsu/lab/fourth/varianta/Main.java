package by.bsu.lab.fourth.varianta;


/**
 * Created by vlad on 02.03.2019
 *
 * @version 1.0.0
 * @author  Volynets V.O.
 */

public class Main {
    /**
     * 3. Создать объект класса Самолет, используя классы Крыло, Шасси,
     * Двигатель. Методы: летать, задавать маршрут, вывести на консоль маршрут.
     */
    public static void main(String[] args) {
        PlaneFactory planeFactory = new PlaneFactory();

        Plane plane = planeFactory.generatePlane();

        System.out.println(plane.toString());

    }
}
