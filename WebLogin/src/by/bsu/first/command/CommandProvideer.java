package by.bsu.first.command;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;

public class CommandProvideer {

    public static Optional<Command> defineCommand(String commandName) {
        Optional<Command> current;
        if (commandName == null || commandName.isBlank()) {
            return Optional.empty();
        }

        try {
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = Optional.of(type.getCommand());
        } catch (IllegalArgumentException e) {
            // log.error
            current = Optional.empty();
        }
        return current;
    }

    public static Optional<Command> takeCommand(String commandName) {

        return Arrays.stream(CommandType.values())
                .filter(o -> o.name().equalsIgnoreCase(commandName))
                .map(CommandType::getCommand)
                .findAny();
        // Optional.ofNullable(type.orElse(null).getCommand());
    }
}




