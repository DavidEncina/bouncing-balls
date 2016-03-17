import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        ArrayList<BouncingBall> listaBolas = new ArrayList<>(numeroBolas);
        
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        int posicionX = 50;
        int posicionY = 50;
        for (int i = 0; i < numeroBolas; i++) {            
            BouncingBall ball = new BouncingBall(posicionX, posicionY, 16, Color.BLUE, ground, myCanvas);
            ball.draw();
            listaBolas.add(ball);
            posicionX += 30;
            posicionY -= 30;
        }
        
        // make them bounce
        boolean finished =  false;        
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (int i = 0; i < listaBolas.size(); i++) {
                listaBolas.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if(listaBolas.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }            
        }
    }
}
