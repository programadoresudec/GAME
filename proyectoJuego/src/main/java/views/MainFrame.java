package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controllers.GameListener;
import assets.Resources;
/**
 * @author Vittorio Polverino
 */
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
        
                menuPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point hitPoint = e.getPoint();
                if (hitPoint.x > 100 && hitPoint.x < 200 && hitPoint.y > 100 && hitPoint.y < 200) 
                {
                    gamePanel = new Game();
                    initPanel(gamePanel, false);
                } 
                else if (hitPoint.x > 100 && hitPoint.x < 350 && hitPoint.y > 100 && hitPoint.y < 400) 
                {
                    System.exit(0);
                }
            }
        });
    }
    
    private void initPanel(JPanel pPanel, boolean pValue) 
    {
        pPanel.setSize(FRAMESIZE);
        pPanel.setVisible(pValue);
        this.add(pPanel);
    }
}

   