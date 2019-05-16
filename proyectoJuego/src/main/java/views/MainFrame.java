package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controllers.GameListener;
import assets.Resources;

public class MainFrame extends JFrame implements GameListener 
{
    private static final Dimension FRAMESIZE = new Dimension(1280, 720);
    private static final String ESCTOGOBACK = "pressEscape";

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
       
    }

    private void initFrame()
    {
        this.setUndecorated(true);
        this.setIconImage(Resources.getImage("/images/icon.jpg"));
        Resources.getSound("/sounds/menuIntro.wav").play();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(FRAMESIZE);
        this.setLocationRelativeTo(null);
        menuPanel = new Menu();
        goBackAction = new GoBackToMenu();
        initPanel(menuPanel, true);
        menuPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Point hitPoint = e.getPoint();
                //entry to the game panel.
                if (hitPoint.x > 120 && hitPoint.x < 430 && hitPoint.y > 440 && hitPoint.y < 490) 
                {
                    gamePanel = new Game();
                    initPanel(gamePanel, false);
                    gamePanel.addListener(MainFrame.this);
                    goBackAction.setPanel(gamePanel);
                    gamePanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).
                            put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), ESCTOGOBACK);
                    gamePanel.getActionMap().put(ESCTOGOBACK, goBackAction);
                    swapPanel(menuPanel, gamePanel);
                } 
                // Exit to the Game.
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
    private void swapPanel(JPanel panelCurrent, JPanel panelNext) 
    {
        panelNext.setVisible(true);
        panelCurrent.setVisible(false);
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
            if (panel != null) {
                if (panel.equals(gamePanel)) 
                {
                    swapPanel(panel, menuPanel);
                    panel.invalidate();
                    panel.removeAll();
                    MainFrame.this.getContentPane().remove(panel);
                    MainFrame.this.invalidate();
                    MainFrame.this.validate();
                } 
//                else if (panel.equals(instructionsPanel)) 
//                {
//                    swapPanel(panel, menuPanel);
//                }
            }
        }
    }
}

   