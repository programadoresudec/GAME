package views;
import assets.Resources;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class PlayerView extends JPanel
{
    private BufferedImage backgroundImg;
    public JTextField inputName, inputCountry;
    public JButton btnRegister;
    public PlayerView() 
    {
        init();
    }
    private void init()
    {
        this.setLayout(null);
        //we add image
        backgroundImg = Resources.getImage("/images/DataPlayer.png");
        inputName = new JTextField(15);
        inputCountry = new JTextField(15);
        btnRegister = new JButton("");
        inputName.setBounds(new Rectangle(560, 240, 350, 30));
        inputCountry.setBounds(new Rectangle(560, 405, 350, 30));
        btnRegister.setContentAreaFilled(false);
        btnRegister.setBounds(new Rectangle(490, 580, 300, 80));
        add(inputName);
        add(inputCountry);
        add(btnRegister);
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

