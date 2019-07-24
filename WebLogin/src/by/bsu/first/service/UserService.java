package by.bsu.first.service;

public class UserService {
    public boolean checkUser(String login, String password) {

        return login.equalsIgnoreCase(password); // stub
    }
    // другие методы
}
