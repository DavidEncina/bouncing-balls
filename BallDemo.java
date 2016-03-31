import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
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
        Random r = new Random();
        Random g = new Random();
        Random b = new Random();
        Random diametro = new Random();
        Random posicionX = new Random();
        Random posicionY = new Random();
        
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        
        for (int i = 0; i < numeroBolas; i++) {
            Color color = new Color(r.nextInt(256), g.nextInt(256), b.nextInt(256));
            BouncingBall ball = new BouncingBall(posicionX.nextInt(70), posicionY.nextInt(70), (diametro.nextInt(80)), color, ground, myCanvas);
            ball.draw();
            listaBolas.add(ball);            
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
    
    /**
     * Dibuja un rectángulo sin relleno en la pantalla y tantas bolas como se indiquen como parámetro en la invocación del método dentro de dicho rectángulo.
     * Las bolas rebotan cambiando de dirección cuando golpeen las paredes del rectángulo.
     */
    public void boxBounce(int numeroBolas)
    {
        int ground = 400;
        myCanvas.setVisible(true);
        
        myCanvas.drawLine(20, 20, 400, 20);
        myCanvas.drawLine(400, 20, 400, 400);
        myCanvas.drawLine(400, 400, 20, 400);
        myCanvas.drawLine(20, 400, 20, 20);
        
        ArrayList<BoxBall> listaBolas = new ArrayList<>(numeroBolas);
        Random r = new Random();
        Random g = new Random();
        Random b = new Random();
        Random diametro = new Random();
        Random posicionX = new Random();
        Random posicionY = new Random();
        Random direccion = new Random();
        
        for (int i = 0; i < numeroBolas; i++) {
            Color color = new Color(r.nextInt(256), g.nextInt(256), b.nextInt(256));
            BoxBall ball = new BoxBall(posicionX.nextInt(70) + 81, posicionY.nextInt(70) + 81, (diametro.nextInt(80)), color, ground, myCanvas, direccion.nextBoolean());
            ball.draw();
            listaBolas.add(ball);            
        }
        
        boolean finished =  false;        
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (int i = 0; i < listaBolas.size(); i++) {
                listaBolas.get(i).move();                
            }            
        }
    }
}
