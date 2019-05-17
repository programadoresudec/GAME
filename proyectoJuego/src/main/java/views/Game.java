package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import assets.Sound;
import assets.SoundException;
import controllers.GameListener;
import assets.Resources;
import java.awt.image.*;
public class Game extends JPanel implements MouseMotionListener
{
    // change of image in the cursor
     private static final Cursor CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(
             new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(), "null");
     // BufferendImaged It is used to handle and manipulate the image data. 
     private BufferedImage backgroundImg;
     private BufferedImage cursorImg;
     private Rectangle cursorRectangle;
     private GameThread gameThread;
     private Sound shootSound;
     private GameListener gameListener;
     private boolean isGameFinished;
     private String nombreHilo;
    
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
        Resources.getSound("/sounds/PlayGame.wav").play(10);
        backgroundImg = Resources.getImage("/images/gameBackground.png");
        cursorImg = Resources.getImage("/images/mira.png");
        shootSound = Resources.getSound("/sounds/SniperRifle.wav");
        cursorRectangle = new Rectangle();
        cursorRectangle.setSize(cursorImg.getWidth(null), cursorImg.getHeight(null));
        cursorRectangle.setLocation(-cursorImg.getWidth(null), -cursorImg.getHeight(null));
        gameThread = new GameThread();
         this.addMouseListener(new MouseAdapter() 
         {
            @Override
            public void mousePressed(MouseEvent e)
            {
                shootSound.play();
            }
        });
    }
    
    
     public void addListener(GameListener pListener) 
     {
         gameListener = pListener;
         GameListener gameListener = pListener;
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
                for (int contar=0; contar<1000; contar++) 
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
