package views;
import assets.Resources;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
//this is class de menu with an inheritance jpanel
public class Menu extends JPanel
{
    private BufferedImage backgroundImg;
    //this is builder
    public Menu() 
    {
        init();
    }
    private void init() 
    {
        this.setLayout(null);
        //we add image
        backgroundImg = Resources.getImage("/images/menuBackground.png");
    }
    //method
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawImage(backgroundImg, 0, 0, getParent());
    }
}
