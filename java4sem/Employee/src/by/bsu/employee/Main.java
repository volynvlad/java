package by.bsu.employee;

import by.bsu.employee.entity.Employee;
import by.bsu.employee.entity.Engineer;
import by.bsu.employee.entity.Head;

public class Main {
    public static void main(String[] args) {
        Employee engineer = new Engineer();
        engineer.doingWork();
        Head head = new Head();
        head.doingWork();
        head.giveTaskToEngineer("make project");
    }
}
