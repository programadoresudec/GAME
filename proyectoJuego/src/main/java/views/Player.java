package views;
import assets.Resources;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/**
 */
public class Player extends JPanel
{
    private BufferedImage backgroundImg;
    public JTextField inputName, inputCountry;
    public Player() 
    {
        init();
    }
    private void init()
    {
         this.setLayout(null);
        //we add image
        backgroundImg = Resources.getImage("/images/DataPlayer.png");
    }
    // method to paint a BufferedImage
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawImage(backgroundImg, 0, 0, getParent());
    }
}
