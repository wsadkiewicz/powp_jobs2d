package edu.kis.powp.command;

import java.util.ArrayList;

public class ComplexCommand {
    private ArrayList<DriverCommand> commandList;

    public void addCommand(DriverCommand command) {
        this.commandList.add(command);
    }

    public void execute() {
        for (DriverCommand command : this.commandList) {
            command.execute();
        }
    }
}