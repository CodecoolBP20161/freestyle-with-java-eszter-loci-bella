package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DrawingBoard extends JPanel {

    Point drawEnd, drawStart;

    public DrawingBoard() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (SuperPaint.abstractON) {
                    // get pos of x and y in case of abstract painting
                    drawStart = new Point(e.getX(), e.getY());
                    drawEnd = drawStart;

                } else {
                    // get pos of x and y in case of simple painting
                    drawEnd = new Point(e.getX(), e.getY());
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = getGraphics();
                g.setColor(SuperPaint.penColor);

                if (SuperPaint.abstractON) {
                    g.drawLine(drawStart.x, drawStart.y, e.getX(), e.getY());
                    drawEnd = new Point(e.getX(), e.getY());
                } else {
                    g.drawLine(drawEnd.x, drawEnd.y, e.getX(), e.getY());
                    drawEnd = new Point(e.getX(), e.getY());
                }
            }
        });
    }

    public static void main(String[] args) {
    }
}