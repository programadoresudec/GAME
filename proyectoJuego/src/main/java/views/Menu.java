package views;
import assets.Resources;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Menu extends JPanel
{
     private static final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
    private BufferedImage backgroundImg;

    public Menu() {
        init();
    }

    private void init() {
        this.setLayout(null);
        backgroundImg = Resources.getImage("/images/menuBackground.png");
        this.setCursor(HAND_CURSOR);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawImage(backgroundImg, 0, 0, getParent());
    }

}
