import java.awt.Color;
import java.awt.Rectangle;

public class Ball {
	
	 //Ball object class complete with instance variables, a constructor, getters, and setters
	
	private int xPOS;
	private int yPOS;
	private int xVelocity;
	private int yVelocity;
	private int mass;
	private static int maxX;
	private static int maxY;
	private Color color;
	
    /*  Constructor that sets and xPOS, yPOS, xVelocity, and yVelocity at random values in their ranges
     *  Mass is set at 1 and the Color is set to Black
     */
	public Ball() {
		xPOS = (int)(Math.random() * 780) + 410;
		yPOS = (int)(Math.random() * 630);
		xVelocity = (int)((Math.random() * maxX));
		yVelocity = -(int)((Math.random() * maxY));
		mass = 1;
		color = Color.BLACK;
	}
	
   /*
	* Getters for each instance variable
	*/
	
	public int getxPOS() {
		return xPOS;
	}
	public int getyPOS() {
		return yPOS;
	}
	public int getxVelocity() {
		return xVelocity;
	}
	public int getyVelocity() {
		return yVelocity;
	}
	public int getMass() {
		return mass;
	}
	public Color getColor() {
		return color;
	}
	
	/*
	 * Setters for each instance variable
	 */
	
	public void setxPOS(int x) {
		xPOS = x;
	}
	public void setyPOS(int y) {
		yPOS = y;
	}
	public void setxVelocity(int xV) {
		xVelocity = xV;
	}
	public void setyVelocity(int yV) {
		yVelocity = yV;
	}
	public void setMass(int m) {
		mass = m;
	}
	public static void setMaxX(int x) {
		maxX = x;
	}
	public static void setMaxY(int y) {
		maxY = y;
	}
	public void setColor(Color c) {
		color = c;
	}
	
	/*
	 *  The Bounds() method will return the ball object as a rectange. This is used for collsions detection
	 *  with the .intersects() method.
	 */
	
	public Rectangle Bounds() {
		return new Rectangle(xPOS + xVelocity, yPOS + yVelocity, mass * 7, mass * 7);
	}
}
