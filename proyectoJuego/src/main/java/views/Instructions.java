package views;
import assets.Resources;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
/**

 */
public class Instructions extends JPanel
{
    //Change the mouse cursor.
     private static final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
     // off screen buffer.
     private BufferedImage backgroundImg;
     
    public Instructions()
    {
        init();
    }
    private void init()
    {
         this.setLayout(null);
        //we add image
        backgroundImg = Resources.getImage("/images/instructions.png");
        this.setCursor(HAND_CURSOR);
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
