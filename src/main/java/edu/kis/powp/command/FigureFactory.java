package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureFactory {
    private Job2dDriver driver;
    private static ComplexCommand command = new ComplexCommand();

    public static void drawSquare(Job2dDriver driver, int size) {
       command.addCommand(new SetPositionCommand(driver, 0 , 0));
       command.addCommand(new OperateToCommand(driver, size, 0));
       command.addCommand(new OperateToCommand(driver, size, size));
       command.addCommand(new OperateToCommand(driver, 0, size));
       command.addCommand(new OperateToCommand(driver, 0, 0));

       command.execute();
    }

    public static void drawTriangle(Job2dDriver driver, int size) {
        command.addCommand(new SetPositionCommand(driver, 0 , 0));
        command.addCommand(new OperateToCommand(driver, size/2, size));
        command.addCommand(new OperateToCommand(driver, -size/2, size));
        command.addCommand(new OperateToCommand(driver, 0, 0));

        command.execute();
    }
}
