package object;

import java.awt.*;
import java.awt.Component;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class UseCaseComponent extends UMLElement {
    private int xCor, yCor;
    private ArrayList<PortComponent> port = new ArrayList<PortComponent>();

    public UseCaseComponent(int xCor, int yCor) {
        this.xCor = xCor;
        this.yCor = yCor;
        setPorts();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawString(this.getName(), xCor, yCor);
        g2d.drawOval(xCor, yCor, 100, 50);

        if (getSelected()) {
            showPorts(g2d);
        }
    }

    public Rectangle2D getBound() {
        return new Rectangle2D.Double(xCor, yCor, 100, 50);
    }

    public void setPorts() {
        port.add(new PortComponent(new Point(xCor+50, yCor), -1)); //N
        port.add(new PortComponent(new Point(xCor+100, yCor+25), -1)); //E
        port.add(new PortComponent(new Point(xCor+50, yCor+50), -1)); //S
        port.add(new PortComponent(new Point(xCor, yCor+25), -1)); //W
    }

    public void showPorts (Graphics2D g2d) {
        for (PortComponent p : port) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(p.getPort().x, p.getPort().y, 5, 5);
        }
    }

    public ArrayList<PortComponent> getPorts() {
        return port;
    }

    public void move(int xS, int yS, int xE, int yE) {
        xCor += xS;
        yCor += yS;
        updatePorts(xS, yS);
    }

    public void updatePorts(int x, int y) {
        for (PortComponent p : port) {
            p.move(x,y);
        }
    }
}