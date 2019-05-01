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
     private boolean isGameFinished;
     private String nombreHilo;
     private BufferedImage gameResultImage;
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
    public void mouseDragged(MouseEvent e)
    {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        cursorRectangle.x = e.getPoint().x - cursorRectangle.width / 2;
        cursorRectangle.y = e.getPoint().y - cursorRectangle.height / 2;
        repaint();
    }

    public class GameThread implements Runnable 
    {
        private Thread thread;
        public GameThread()
        {
        }
        
        public void start() 
        {
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run()
        {
           System.out.println("Comenzando "+nombreHilo);
            try
            {
                for (int contar=0; contar<10; contar++) 
                {
                    Thread.sleep(400);
                    System.out.println("En "+nombreHilo+", el recuento "+contar);
                }
            }catch (InterruptedException exc)
            {
                System.out.println(nombreHilo + "Interrumpido.");
            }
            System.out.println("Terminando "+nombreHilo);
        }
    }
    
}
