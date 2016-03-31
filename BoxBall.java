import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{

    private static final int GRAVITY = 0;  // effect of gravity

    private int ballDegradation = 0;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private boolean direccionX;
    private boolean direccionY;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int groundPos, Canvas drawingCanvas, boolean direccionX, boolean direccionY)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        this.direccionX = direccionX;
        this.direccionY = direccionY;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        if(direccionY){
            yPosition += ySpeed;
        }
        else
        {
            yPosition -= ySpeed;
        }
        
        if(!direccionX)
        {
            xPosition +=1;
        }
        else
        {
            xPosition -=1;
        }

        // comprueba si toca el rectangulo
        if(((xPosition <= 20) || ((xPosition  >= 400 - diameter)))) {
            direccionX = !direccionX;
        }
        
        if(((yPosition <= 20)) || ((yPosition  >= 400- diameter))){
            direccionY = !direccionY;
        }
        
        // draw again at new position
        draw();
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

