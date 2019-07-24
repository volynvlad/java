package by.bsu.first.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request);
    default void refresh(){/* code */} // метод для возвращения на ту же самую страницу
}
