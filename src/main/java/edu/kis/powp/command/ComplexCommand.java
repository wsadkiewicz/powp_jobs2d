package edu.kis.powp.command;

import java.util.ArrayList;

public class ComplexCommand {
    private final ArrayList<DriverCommand> commandList = new ArrayList<DriverCommand>();

    public void addCommand(DriverCommand command) {
        this.commandList.add(command);
    }

    public void execute() {
        for (DriverCommand command : this.commandList) {
            command.execute();
        }
    }
}