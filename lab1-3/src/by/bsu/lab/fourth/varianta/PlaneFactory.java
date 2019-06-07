package by.bsu.lab.fourth.varianta;
import by.bsu.lab.basic.FormRandomNumber;
import by.bsu.lab.fourth.varianta.Chassis.Chassis;
import by.bsu.lab.fourth.varianta.Chassis.SkiChassis;
import by.bsu.lab.fourth.varianta.Chassis.WheelChassis;
import by.bsu.lab.fourth.varianta.Engine.Engine;
import by.bsu.lab.fourth.varianta.Engine.JetEngine;
import by.bsu.lab.fourth.varianta.Engine.TurbojetEngine;
import by.bsu.lab.fourth.varianta.Wing.ArrowWing;
import by.bsu.lab.fourth.varianta.Wing.DirectWing;
import by.bsu.lab.fourth.varianta.Wing.Wing;

public class PlaneFactory {
    public Plane generatePlane() {
        FormRandomNumber formRandomNumber = new FormRandomNumber();
        Plane plane = new Plane() {};

        if (formRandomNumber.generateRandomNumber(0, 9) % 2 == 0) {
            Chassis chassis = new SkiChassis() {};
            plane.setChassis(chassis);
        } else {
            Chassis chassis = new WheelChassis() {};
            plane.setChassis(chassis);
        }

        if (formRandomNumber.generateRandomNumber(0, 9) % 2 == 0) {
            Engine engine = new JetEngine() {};
            plane.setEngine(engine);
        } else {
            Engine engine = new TurbojetEngine() {};
            plane.setEngine(engine);
        }

        if (formRandomNumber.generateRandomNumber(0, 9) % 2 == 0) {
            Wing wing = new ArrowWing(){};
            plane.setWing(wing);
        } else {
            Wing wing = new DirectWing(){};
            plane.setWing(wing);
        }

        return plane;
    }
}
