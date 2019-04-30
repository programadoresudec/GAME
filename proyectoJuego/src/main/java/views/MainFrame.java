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
    private GoBackToMenu goBackAction;
    public MainFrame()
    {
        initFrame();
    }

    @Override
    public void gameIsFinished() 
    {
        goBackAction.setEnabled(true);
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
                if (hitPoint.x > 100 && hitPoint.x < 200 && hitPoint.y > 100 && hitPoint.y < 200) 
                {
                    gamePanel = new Game();
                    initPanel(gamePanel, false);
                    gamePanel.addListener(MainFrame.this);
                    goBackAction.setPanel(gamePanel);
                    goBackAction.setEnabled(false);
                    swapPanel(menuPanel, gamePanel);
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
    
    private void swapPanel(JPanel pFrom, JPanel pTo) 
    {
        pTo.setVisible(true);
        pFrom.setVisible(false);
    }
    
     public class GoBackToMenu extends AbstractAction
     {

        private JPanel panel;

        public GoBackToMenu()
        {
        }

        public void setPanel(JPanel pPanel)
        {
            this.panel = pPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (panel != null)
            {
                if (panel.equals(gamePanel))
                {
                    swapPanel(panel, menuPanel);
                    panel.invalidate();
                    panel.removeAll();
                    MainFrame.this.getContentPane().remove(panel);
                    MainFrame.this.invalidate();
                    MainFrame.this.validate();
                }
            }
        }
    }
}

   