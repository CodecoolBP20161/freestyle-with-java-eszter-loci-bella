package paint;

import javax.swing.*;
import java.awt.event.*;


public class PaintButton extends JButton {

    public static JButton createNewButton(JPanel panel) {

        // Button and method for creating a new canvas
        JButton newCanvasButton = new JButton("New canvas");
        newCanvasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        return newCanvasButton;
    }

    public static JButton colorPicker() {

        JButton colorPicker = new JButton("Choose a color");
        colorPicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SuperPaint.penColor = JColorChooser.showDialog(null, "Pick a color", SuperPaint.penColor);
            }
        });
        return colorPicker;
    }

    public static JButton createSaveButton(JPanel panel) {

        JButton saveBtn = new JButton("Save image");
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveImage.makePanelImage(panel);
            }
        });
        return saveBtn;
    }

    public static JButton chooseSimple() {
        JButton button = new JButton("Simple paint");
        button.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                SuperPaint.abstractON = false;
            }
        });
        return button;
    }

    public static JButton chooseAbstract() {
        JButton button = new JButton("Abstract paint");
        button.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                SuperPaint.abstractON = true;
            }
        });
        return button;
    }


    public static void main(String[] args) {
    }
}