package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import assets.Sound;
import assets.SoundException;
import controllers.GameListener;
import assets.Resources;
import controllers.DuckController;
import controllers.Questions;
import java.awt.image.*;
<<<<<<< HEAD
import models.Questionnaire;
=======
import models.Duck;
>>>>>>> b37b62943f4413fceeee89c320e8029abb6d8fc6
public class Game extends JPanel implements MouseMotionListener
{
    Questionnaire qs = new Questionnaire();
    // change of image in the cursor
     private static final Cursor CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(
             new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(), "null");
     // BufferendImaged It is used to handle and manipulate the image data. 
     private BufferedImage backgroundImg;
     private BufferedImage cursorImg;
     private Rectangle cursorRectangle;
     private GameThread gameThread;
     private Sound shootSound;
     private BufferedImage duckCurrentImage;
     private DuckController duckController;
     private Duck duck;
     private GameListener gameListener;
     private boolean isGameFinished;
     private String nombreHilo;
     private Questions question;
    public Game() 
    {
        initPanel();
        gameThread.start();
    }
   
    private void initPanel() 
    {
        question = new Questions();
        this.setLayout(null);
        this.setCursor(CURSOR);
        this.addMouseMotionListener(this);
        Resources.getSound("/sounds/PlayGame.wav").play(10);
        backgroundImg = Resources.getImage("/images/gameBackground.png");
        duckCurrentImage = Resources.getImage("/images/duckUpRight0.png");
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
<<<<<<< HEAD
                qs.apliQuestionnaire();
=======
                Point hitPoint = e.getPoint();
                if (duck != null) 
                {
                    hitPoint.x -= duck.getX();
                    hitPoint.y -= duck.getY();
                    if (contains(duckController.getCurrentImage(), hitPoint.x, hitPoint.y)) 
                    {
                        duckController.theDuckWasHit(true);
                        question.easy();
                    }
                }
>>>>>>> b37b62943f4413fceeee89c320e8029abb6d8fc6
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
        if (duckController.isDuckVisible())
        {
            g2D.drawImage(duckCurrentImage, duck.getX(), duck.getY(), this);
        }
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
    
    public boolean contains(BufferedImage image, int x, int y) 
    {
        if (x < 0 || y < 0 || x >= image.getWidth() || y >= image.getHeight())
        {
            return false;
        }
        Color pixel = new Color(image.getRGB(x, y), true);
        return pixel.getAlpha() > 128;
    }
    
    public void setDuckCurrentImage(BufferedImage pImage) 
    {
        this.duckCurrentImage = pImage;
    }
    
      public void notifyGameStatus() 
      {
        if (isGameFinished) {
            gameListener.gameIsFinished();
        }
    }
    public class GameThread implements Runnable 
    {
        private Thread thread;
        public GameThread()
        {
            duckController = DuckController.getIstance();
            duckController.setPanel(Game.this);
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
                 duck = new Duck();
                 duckController.setDuck(duck);
                 duckController.getDuckAnimation().start();
                 
            }catch (InterruptedException exc)
            {
                System.out.println(nombreHilo + "Interrumpido.");
            }
            System.out.println("Terminando "+nombreHilo);
        }
    }
    
}
