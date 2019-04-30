package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controllers.GameListener;
import assets.Resources;
import assets.Sound;
import assets.SoundException;
import java.awt.image.*;
public class Game extends JPanel implements MouseMotionListener
{
     private static final Cursor CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(), "null");
     private BufferedImage backgroundImg;
     private BufferedImage cursorImg;
     private GameListener gameListener;
     private Rectangle cursorRectangle;
     private GameThread gameThread;
    public Game() 
    {
        initPanel();
        gameThread.start();
    }
   
    private void initPanel() 
    {
        this.setLayout(null);
        this.setCursor(CURSOR);
        this.addMouseMotionListener(this);
        Resources.getSound("/sounds/gameIntro.wav").play();
        backgroundImg = Resources.getImage("/images/gameBackground.png");
        cursorImg = Resources.getImage("/images/gunsight.png");
        cursorRectangle = new Rectangle();
        cursorRectangle.setSize(cursorImg.getWidth(null), cursorImg.getHeight(null));
        cursorRectangle.setLocation(-cursorImg.getWidth(null), -cursorImg.getHeight(null));
        gameThread = new GameThread();
    }
    
    
     public void addListener(GameListener pListener) 
     {
        gameListener = pListener;
     }
     
     @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.drawImage(backgroundImg, 0, 0, this);
        g2D.drawImage(cursorImg, this.cursorRectangle.x, this.cursorRectangle.y, this);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class GameThread implements Runnable 
    {
        private Thread thread;
        public GameThread()
        {
        }
        
        public void start() 
        {
            reset();
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void reset() 
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
