package by.bsu.first.command;
import java.util.Arrays;
import java.util.Optional;

public class CommandProvider2 {
    private static CommandProvider2 instance;

    private CommandProvider2() {
    }

    public static CommandProvider2 getInstance() {
        if (instance == null) {
            instance = new CommandProvider2();
        }
        return instance;
    }

    public Optional<Command> defineCommand(String commandName) {
        return Arrays.stream(CommandType.values())
                .filter(command -> command.name().equalsIgnoreCase(commandName))
                .findFirst()
                .map(CommandType::getCommand);
    }
}
