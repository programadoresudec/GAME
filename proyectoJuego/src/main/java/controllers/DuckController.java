package controllers;
import assets.*;
import views.Game;
import models.Duck;

import java.awt.image.BufferedImage;

/**
 *
 * @author Vittorio Polverino
 */
public class DuckController {

    private static final int LEFT = -3;
    private static final int RIGHT = 3;
    private static final int UP = -3;
    private static final int DOWN = 3;
    private static final int DELAY = 200;

    private static DuckController duckControllerIstance = null;
    private Spritesheet spriteSheet;
    private BufferedImage currentImage;
    private DuckAnimation duckAnimation;
    private Game panel;
    private Duck duck;
    private int xDirection;
    private int yDirection;
    private int x;
    private int y;
    private boolean isDuckVisible;
    private boolean wasDuckHit;
    
    private DuckController() 
    {
        currentImage = Resources.getImage("/images/duckUpRight0.png");
        spriteSheet = new Spritesheet();
        duckAnimation = new DuckAnimation();
        xDirection = RIGHT;
        yDirection = DOWN;
        isDuckVisible = false;
        wasDuckHit = false;
        x = 0;
        y = 0;
    }

    public static DuckController getIstance() 
    {
        if (duckControllerIstance == null)
        {
            return duckControllerIstance = new DuckController();
        }
        return duckControllerIstance;
    }

    public void setPanel(Game pPanel) 
    {
        this.panel = pPanel;
    }

    public void setDuck(Duck pDuck)
    {
        this.duck = pDuck;
    }

    public Duck getDuck()
    {
        return duck;
    }

    private void flight() 
    {
        if (xDirection == RIGHT && yDirection == UP) {
            spriteSheet.setFrames(2, "duckUpRight");
            spriteSheet.setDelay(DELAY);
            spriteSheet.update();
            currentImage = spriteSheet.getCurrentFrame();
        } else if (xDirection == RIGHT && yDirection == DOWN) {
            spriteSheet.setFrames(2, "duckRight");
            spriteSheet.setDelay(DELAY);
            spriteSheet.update();
            currentImage = spriteSheet.getCurrentFrame();
        } else if (xDirection == LEFT && yDirection == UP) {
            spriteSheet.setFrames(2, "duckUpLeft");
            spriteSheet.setDelay(DELAY);
            spriteSheet.update();
            currentImage = spriteSheet.getCurrentFrame();
        } else {
            spriteSheet.setFrames(2, "duckLeft");
            spriteSheet.setDelay(DELAY);
            spriteSheet.update();
            currentImage = spriteSheet.getCurrentFrame();
        }

        x = duck.getX();
        y = duck.getY();
        x += xDirection;
        y += yDirection;
        duck.setX(x);
        duck.setY(y);

        if (duck.getX() <= 0) 
        {
            this.xDirection = RIGHT;
        } else if (duck.getX() + 40 >= 1200)
        {
            this.xDirection = LEFT;
        }
        if (duck.getY() <= 0) {
            this.yDirection = DOWN;
        } else if (duck.getY() >= 390)
        {
            this.yDirection = UP;
        }
    }

    public void theDuckWasHit(boolean pValue)
    {
        this.wasDuckHit = pValue;
    }
    private void precipitate() 
    {
        spriteSheet.setFrames(4, "duckPrecipitate");
        spriteSheet.setDelay(DELAY);
        spriteSheet.update();
        currentImage = spriteSheet.getCurrentFrame();
        y = duck.getY();
        y += 6;
        duck.setY(y);
    }

    public BufferedImage getCurrentImage() 
    {
        return currentImage;
    }

    public boolean isDuckVisible()
    {
        return isDuckVisible;
    }

 

    public DuckAnimation getDuckAnimation()
    {
        return duckAnimation;
    }

    public class DuckAnimation implements Runnable
    {

        private Thread thread;

        public void start() throws InterruptedException
        {
            reset();
            thread = new Thread(this);
            thread.start();
            thread.join();
        }

        public void stop()
        {
            if (thread != null && thread.isAlive())
            {
                thread.interrupt();
            }
        }

        private void reset() 
        {
            isDuckVisible = true;
            wasDuckHit = false;
        }

        @Override
        public void run() 
        {
            while (!wasDuckHit)
            {                
            flight();
            panel.setDuckCurrentImage(currentImage);
            panel.repaint();
            }
            try 
            {
                panel.setDuckCurrentImage(currentImage);
                panel.repaint();
                Thread.sleep(500);
                while (duck.getY() < 420) 
                {
                    precipitate();
                    panel.setDuckCurrentImage(currentImage);
                    panel.repaint();
                }
            } catch (InterruptedException ex)
            {
                System.out.println("an error occured during duck animation thread");
                stop();
            }
            isDuckVisible = false;
            stop();
        }
    }

}
