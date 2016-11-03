package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuperPaint extends JFrame {

    Color penColor = Color.black;

    public SuperPaint() {
        // Define the defaults for the JFrame

        this.setSize(1200, 700);
        this.setTitle("Super Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();

        // Swing box that will hold all the buttons

        Box buttonBox = Box.createVerticalBox();

        // Button for creating a new canvas
        JButton newCanvasButton = new JButton("Create new");

        newCanvasButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                repaint();
            }
        });

        //  Button for choosing colors
        JButton colorButton = this.colorPicker();


        // Add the buttons to the box
        buttonBox.add(newCanvasButton);
        buttonBox.add(colorButton);


        // Add the box of buttons to the panel

        buttonPanel.add(buttonBox);
        buttonPanel.setBackground(Color.DARK_GRAY);

        // Position the buttons on the left side of the frame

        this.add(buttonPanel, BorderLayout.WEST);

        // Make the drawing area take up the rest of the frame

        this.add(new DrawingBoard(), BorderLayout.CENTER);

        // Show the frame and disable resizing option

        this.setVisible(true);
        this.setResizable(false);
    }

    public JButton colorPicker() {
        JButton colorPicker = new JButton("Choose a color");

        colorPicker.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                penColor = JColorChooser.showDialog(null, "Pick a color", penColor);
            }
        });
        return colorPicker;
    }

    private class DrawingBoard extends JComponent {


        Point drawStart, drawEnd;

        // Monitors events on the drawing area of the frame

        public DrawingBoard() {
            this.addMouseListener(new MouseAdapter() {
                                      @Override
                                      public void mousePressed(MouseEvent e) {

                // When the mouse is pressed get x & y position
                drawStart = new Point(e.getX(), e.getY());
                drawEnd = drawStart;
            }
            });

            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Graphics g = getGraphics();
                    g.setColor(penColor);
                    g.drawLine(drawStart.x, drawStart.y, e.getX(), e.getY());
                    drawEnd = new Point(e.getX(), e.getY());
//                    g.dispose();
//                    repaint();
                }
            });
        };

    }

    public static void main(String [] args) {
        new SuperPaint();
    }
}
