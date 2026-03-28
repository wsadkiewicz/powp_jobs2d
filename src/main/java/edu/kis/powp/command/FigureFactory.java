package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureFactory {

    public static ComplexCommand drawSquare(Job2dDriver driver, int size) {
        ComplexCommand command = new ComplexCommand();

        command.addCommand(new SetPositionCommand(driver, 0 , 0));
        command.addCommand(new OperateToCommand(driver, size, 0));
        command.addCommand(new OperateToCommand(driver, size, size));
        command.addCommand(new OperateToCommand(driver, 0, size));
        command.addCommand(new OperateToCommand(driver, 0, 0));

        return command;
    }

    public static ComplexCommand drawTriangle(Job2dDriver driver, int size) {
        ComplexCommand command = new ComplexCommand();

        command.addCommand(new SetPositionCommand(driver, 0 , 0));
        command.addCommand(new OperateToCommand(driver, size/2, size));
        command.addCommand(new OperateToCommand(driver, -size/2, size));
        command.addCommand(new OperateToCommand(driver, 0, 0));

        return command;
    }
}
