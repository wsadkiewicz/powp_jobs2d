package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;
    private ILine line;

    public LineDrawerAdapter(ILine type) {
        this.drawPanelController = DrawerFeature.getDrawerController();
        this.line = type;
    }

    public void setLine(ILine type) {
        this.line = type;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);

        drawPanelController.drawLine(line);

        setPosition(x, y);
    }

    @Override
    public String toString() {
        return "Line Driver Adapter";
    }
}
