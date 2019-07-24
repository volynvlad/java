package by.bsu.first.command;

import by.bsu.first.service.UserService;
import by.bsu.first.manager.MessageManager;
import javax.servlet.http.HttpServletRequest;
import static by.bsu.first.command.PagePath.*;

public class LoginCommand implements Command {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";

    private UserService service;

    public LoginCommand(UserService service) {
        this.service = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String loginValue =  request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);
        // валидация : вынести в отдельный класс Validator
        if(loginValue != null && !loginValue.isEmpty() && passValue != null && !passValue.isEmpty()) {
            if (service.checkUser(loginValue, passValue)) {
                request.setAttribute("user", loginValue);
                page = MAIN;
            } else {
                request.setAttribute("errorLoginPassMessage", MessageManager.EN.getMessage("message.loginerror"));
                page = LOGIN;
            }
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.EN.getMessage("message.login.empty"));
            page = LOGIN;
        }
        return page;
    }
}
