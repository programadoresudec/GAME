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

    //Object of some classes.
    private Menu menuPanel;
    private boolean playerDataEntry = false;
    private Game gamePanel;
    private Player playerPanel;
    private Instructions instructionsPanel;
    private GoBackToMenu goBack; 
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
        initPanel(menuPanel, true);
        
        instructionsPanel = new Instructions();
        initPanel(instructionsPanel, false);
        
        playerPanel = new Player();
        initPanel(playerPanel, false);
        goBack = new GoBackToMenu();
        
        menuPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Point hitPoint = e.getPoint();
                //entry to player data.
                if (hitPoint.x > 165 && hitPoint.x < 393 && hitPoint.y > 401 && hitPoint.y < 443) 
                {
                    if (playerDataEntry == false) 
                    {
                    //entry to the game panel. 
                    System.out.println("Registrando datos del jugador...");
                    // it's called the setPanel method of the GoBackToMenu class.
                    goBack.setPanel(playerPanel);
                    // it's called the method to swap panel.
                    swapPanel(menuPanel, playerPanel);
                    playerDataEntry = true;  
                    playerPanel.addMouseListener(new MouseAdapter() 
                    {
                        @Override
                        public void mousePressed(MouseEvent e2)
                        {
                            Point hitPoint = e2.getPoint();
                            // validate if the data entry was already done.
                            if (playerDataEntry == true && hitPoint.x > 510 && hitPoint.x < 769 && hitPoint.y > 596 && hitPoint.y < 626) 
                            {
                                System.out.println("Entrando a juego dispara y programa...");
                                gamePanel = new Game();
                                initPanel(gamePanel, true);
                                gamePanel.addListener(MainFrame.this);
                                // it's called the setPanel method of the GoBackToMenu class
                                goBack.setPanel(gamePanel);
                                //it is disabled while the thread ends.
                                goBack.setEnabled(false);
                                // keyboard function to be returned from the panel with the ESC key.
                                gamePanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).
                                        put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), ESCTOGOBACK);
                                gamePanel.getActionMap().put(ESCTOGOBACK, goBack);
                                // it's called the method to swap panel.
                                swapPanel(playerPanel, gamePanel);
                            }
                        }
                     });
                    }
                } 
                // valid to enter the instruction panel
                else if (hitPoint.x > 41 && hitPoint.x < 556 && hitPoint.y > 518 && hitPoint.y < 545) 
                {
                    System.out.println("Entrando a instrucciones del juego...");
                     // it's called the setPanel method of the GoBackToMenu class.
                     goBack.setPanel(instructionsPanel);
                    //keyboard function to be returned from the panel with the ESC key.
                    instructionsPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).
                            put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), ESCTOGOBACK);
                    instructionsPanel.getActionMap().put(ESCTOGOBACK, goBack);
                    // it's called the method to swap panel.
                    swapPanel(menuPanel, instructionsPanel);
                }
                // Exit to the Game.
                else if (hitPoint.x > 186 && hitPoint.x < 357 && hitPoint.y > 632 && hitPoint.y < 657) 
                {
                    System.out.println("saliendo del juego...");
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
        // default builder
        public GoBackToMenu() {}
        //method to receive the panel
        public void setPanel(JPanel pPanel)
        {
            this.panel = pPanel;
        }
        //method to remove the current panel and move to the menu.
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
                else if (panel.equals(instructionsPanel)) 
                {
                    swapPanel(panel, menuPanel);
                }
            }
        }
    }
}

   