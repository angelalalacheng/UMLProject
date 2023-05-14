package mode;

import object.GeneralizationLine;
import object.PortComponent;
import view.Canvas;

import java.awt.event.MouseEvent;

public class GeneralizationLineMode extends Mode{
    private int xStart, yStart, xEnd, yEnd;

    @Override
    public void mousePressed(MouseEvent e) {
        xStart = e.getX();
        yStart = e.getY();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        xEnd = e.getX();
        yEnd = e.getY();

        Canvas canvas = (Canvas) e.getSource();
        PortComponent startClosest = canvas.findClosestPort(xStart, yStart);
        PortComponent endClosest = canvas.findClosestPort(xEnd, yEnd);

        canvas.addElement(new GeneralizationLine(startClosest.getPort().x, startClosest.getPort().y, endClosest.getPort().x, endClosest.getPort().y));
    }
}