package paint;

import javax.swing.JPanel;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.text.*;


public class SaveImage {

    // saving the image to an external file

    public static void makePanelImage(JPanel canvas) {
        BufferedImage image = new BufferedImage(
                canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
        canvas.paint(image.getGraphics());


        try {
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
            String filename = "snapshot_".concat(timeStamp).concat(".png");
            ImageIO.write(image, "png", new File(filename));
            System.out.println("Panel saved as Image.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {};
}


