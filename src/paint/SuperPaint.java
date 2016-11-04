package paint;

import javax.swing.*;
import java.awt.*;


public class SuperPaint extends JFrame {

    static Color penColor = Color.black;
    static boolean abstractON = false;


    public SuperPaint() {

        // Define the defaults for the JFrame
        this.setSize(1200, 700);
        this.setTitle("Super Paint");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Swing box and JPanel that will hold all the buttons
        JPanel buttonPanel = new JPanel();
        JPanel canvasPanel = new DrawingBoard();

        Box buttonBox = Box.createVerticalBox();

        // Creating the new canvas button
        JButton newCanvasButton = PaintButton.createNewButton(canvasPanel);

        //  Button for choosing colors
        JButton colorButton = PaintButton.colorPicker();

        //  Creating the save button
        JButton saveBtn = PaintButton.createSaveButton(canvasPanel);

        // Buttons for abstract or simple version of paint
        JButton simplePaintButton = PaintButton.chooseSimple();
        JButton abstractPaintButton = PaintButton.chooseAbstract();

        // Add the buttons to the box
        buttonBox.add(newCanvasButton);
        buttonBox.add(colorButton);
        buttonBox.add(simplePaintButton);
        buttonBox.add(abstractPaintButton);
        buttonBox.add(saveBtn);

        // Add the box of buttons to the panel
        buttonPanel.add(buttonBox);
        buttonPanel.setBackground(Color.DARK_GRAY);
        this.add(canvasPanel, BorderLayout.CENTER);

        // Position the buttons on the left side of the frame
        this.add(buttonPanel, BorderLayout.WEST);

        // Show the frame and disable resizing option
        this.setVisible(true);
        this.setResizable(false);
    }


    public static void main(String[] args) {
        new SuperPaint();
    }
}
