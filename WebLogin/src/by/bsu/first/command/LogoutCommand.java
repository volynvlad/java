package by.bsu.first.command;

import by.bsu.first.service.DefaultService;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    private DefaultService receiver = new DefaultService();

    public LogoutCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return receiver.getPath();
    }
}
