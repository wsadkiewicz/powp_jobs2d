package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commandList;

    public ComplexCommand() {
        this.commandList = new ArrayList<>();
    }

    public void addCommand(DriverCommand command) {
        this.commandList.add(command);
    }

    public void execute() {
        for (DriverCommand command : this.commandList) {
            command.execute();
        }
    }
}