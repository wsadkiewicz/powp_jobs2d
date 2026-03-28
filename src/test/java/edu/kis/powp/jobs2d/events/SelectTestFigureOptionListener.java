package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import edu.kis.powp.command.FigureFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int option;

	public SelectTestFigureOptionListener(DriverManager driverManager, int option) {
		this.driverManager = driverManager;
		this.option = option;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(this.option) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				FiguresJane.figureScript(new AbstractDriverAdapter(driverManager.getCurrentDriver()));
				break;
			case 4:
				FigureFactory.drawSquare(driverManager.getCurrentDriver(), 100).execute();
				break;
			case 5:
				FigureFactory.drawTriangle(driverManager.getCurrentDriver(), 200).execute();
				break;
			default:
				break;
		}
	}
}
