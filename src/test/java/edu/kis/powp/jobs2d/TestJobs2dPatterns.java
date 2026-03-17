package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.DriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigureOptionListener1 = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), 1);
		SelectTestFigureOptionListener selectTestFigureOptionListener2 = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), 2);
		SelectTestFigureOptionListener selectTestFigureOptionListener3 = new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), 3);

		application.addTest("Figure Joe 1", selectTestFigureOptionListener1);
		application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
		application.addTest("Figure Jane", selectTestFigureOptionListener3);
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		DrawPanelController drawPanelController = DrawerFeature.getDrawerController();

		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		Job2dDriver testDriver = new DriverAdapter(drawPanelController);
		DriverFeature.addDriver("Buggy Simulator", testDriver);

		LineDrawerAdapter lineDriver = new LineDrawerAdapter(drawPanelController, LineFactory.getBasicLine());
		DriverFeature.addDriver("Line Driver", lineDriver);
		setupLineSettings(application, lineDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	private static void setupLineSettings(Application application, LineDrawerAdapter adapter) {
		application.addComponentMenu(LineDrawerAdapter.class, "Line Settings", 4);
		application.addComponentMenuElement(LineDrawerAdapter.class, "Basic Line",
				(ActionEvent e) -> adapter.setLine(LineFactory.getBasicLine()));
		application.addComponentMenuElement(LineDrawerAdapter.class, "Dotted Line",
				(ActionEvent e) -> adapter.setLine(LineFactory.getDottedLine()));
		application.addComponentMenuElement(LineDrawerAdapter.class, "Cyan Dotted Line",
				(ActionEvent e) -> adapter.setLine(LineFactory.getSpecialLine()));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
