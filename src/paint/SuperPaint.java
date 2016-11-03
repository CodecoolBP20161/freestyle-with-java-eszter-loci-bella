package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuperPaint extends JFrame {

    Color penColor = Color.black;
    boolean abstractON = false;


    public SuperPaint() {

    // Define the defaults for the JFrame
        this.setSize(1200, 700);
        this.setTitle("Super Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Swing box and JPanel that will hold all the buttons
        JPanel buttonPanel = new JPanel();

        Box buttonBox = Box.createVerticalBox();

    // Button and method for creating a new canvas
        JButton newCanvasButton = new JButton("Create new");

        newCanvasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

    //  Button for choosing colors
        JButton colorButton = this.colorPicker();


    // Buttons for abstract or simple version of paint
        JButton simplePaintButton = chooseSimple();
        JButton abstractPaintButton = chooseAbstract();

    // Add the buttons to the box
        buttonBox.add(newCanvasButton);
        buttonBox.add(colorButton);
        buttonBox.add(simplePaintButton);
        buttonBox.add(abstractPaintButton);


    // Add the box of buttons to the panel

        buttonPanel.add(buttonBox);
        buttonPanel.setBackground(Color.DARK_GRAY);
        this.add(new DrawingBoard(), BorderLayout.CENTER);

    // Position the buttons on the left side of the frame
        this.add(buttonPanel, BorderLayout.WEST);


    // Show the frame and disable resizing option

        this.setVisible(true);
        this.setResizable(false);
    }


    public JButton chooseSimple(){
        JButton button = new JButton("Simple paint");
        button.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                abstractON = false;
            }
        });
        return button;
    };

    public JButton chooseAbstract(){
        JButton button = new JButton("Abstract paint");
        button.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                abstractON = true;
            }
        });

        return button;
    };



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

        Point drawEnd, drawStart;


        public DrawingBoard() {

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {

                    if(!(abstractON)){

                // get pos of x and y in case of simple painting
                        drawEnd = new Point(e.getX(), e.getY());

                    } else {
                // get pos of x and y in case of abstract painting
                        drawStart = new Point(e.getX(), e.getY());
                        drawEnd = drawStart;
                    }
                }
            });

            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Graphics g = getGraphics();
                    g.setColor(penColor);

                    if (!(abstractON)){
                        g.drawLine(drawEnd.x, drawEnd.y, e.getX(), e.getY());
                        drawEnd = new Point(e.getX(), e.getY());}
                    else {
                        g.drawLine(drawStart.x, drawStart.y, e.getX(), e.getY());
                        drawEnd = new Point(e.getX(), e.getY());}
                }
            });
        }
    }
    public static void main(String [] args) {
        new SuperPaint();
    }
}
