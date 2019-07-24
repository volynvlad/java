package by.bsu.first.command;


import by.bsu.first.service.UserService;

public enum CommandType {
    LOGIN(new LoginCommand(new UserService())),
    LOGOUT(new LogoutCommand()),
    ALL_ABONENTS(new AbonentCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
