package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controllers.GameListener;
import assets.Resources;

public class MainFrame extends JFrame implements GameListener 
{
    private static final Dimension FRAMESIZE = new Dimension(1280, 720);
    private Menu menuPanel;
    private Game gamePanel;
    public MainFrame()
    {
        initFrame();
    }

    @Override
    public void gameIsFinished() 
    {
       
    }

    private void initFrame()
    {
        this.setUndecorated(true);
        this.setIconImage(Resources.getImage("/images/"));
        Resources.getSound("/sounds/menuIntro.wav").play();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(FRAMESIZE);
        this.setLocationRelativeTo(null);
        menuPanel = new Menu();
        initPanel(menuPanel, true);
        menuPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Point hitPoint = e.getPoint();
                if (hitPoint.x > 120 && hitPoint.x < 430 && hitPoint.y > 440 && hitPoint.y < 490) 
                {
                    gamePanel = new Game();
                    initPanel(gamePanel, false);
                    gamePanel.addListener(MainFrame.this);
                    swapPanel(menuPanel, gamePanel);
                } 
                else if (hitPoint.x > 90 && hitPoint.x < 385 && hitPoint.y > 587 && hitPoint.y < 645) 
                {
                    System.exit(0);
                }
            }
        });
    }
    
    // method to show and hide the panel
    private void initPanel(JPanel pPanel, boolean pValue) 
    {
        pPanel.setSize(FRAMESIZE);
        pPanel.setVisible(pValue);
        this.add(pPanel);
    }
    
    // method to exchange the panel
    private void swapPanel(JPanel pFrom, JPanel pTo) 
    {
        pTo.setVisible(true);
        pFrom.setVisible(false);
    }
}

   