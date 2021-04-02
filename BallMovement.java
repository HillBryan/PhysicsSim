import java.awt.Color;
import java.awt.Graphics2D;

public class BallMovement {
	
	public static int energyLost = 50;
	public static int numberOfBalls = 100;
	
	
   /* Applies gravity by incrementing the Y component of the ball's velocity
    * whenever the method is called (every .02 seconds).
    * In other words, this method applies a constant acceleration of 100 pixles / second / second
    */
	public static void applyGravity() {

		for (Ball b : Panel.balls) {
			b.setyVelocity(b.getyVelocity() + 2);
		}
	}
	
    /* moves the balls by adding the balls velocity to it's position.
     * before moving the ball, boundries are checked and velocity is reversed if a boundry collision is going to happen in the next frame.
     * Also makes the balls "lose energy" on each collision with the bottom boundry
     */
	public static void moveBalls() {
		for (Ball b : Panel.balls) {
			if (b.getxPOS() + b.getxVelocity() < 410 || b.getxPOS() + b.getxVelocity() > (1200 - (b.getMass() * 7))) { //checking next frame for boundry collision
				b.setxVelocity(-b.getxVelocity());																	//reverseing velocity if true
			}
			if (b.getyPOS() + b.getyVelocity() < 0) {
				b.setyVelocity(-(b.getyVelocity()));
			}
			if (b.getyPOS() + b.getyVelocity() > (800 - (b.getMass() * 7)) - 22) { //on each collision with the floor, decrease the balls X and Y velocity
				b.setyVelocity(-(b.getyVelocity() - energyLost));
				if (Panel.tick % 7 == 0 && Panel.Gravity) {
					if (b.getxVelocity() < 0) {
						b.setxVelocity(b.getxVelocity() + 1);
					}
					if (b.getxVelocity() > 0) {
						b.setxVelocity(b.getxVelocity() - 1);
					}
				}
			}
			if (!(b.getyPOS() + b.getyVelocity() > (800 - (b.getMass() * 7)) - 22)) { //applying motion in the Y direction only if the ball is not resting on the floor
				b.setyPOS(b.getyPOS() + b.getyVelocity());
			}
			else {
				b.setyPOS((800 - (b.getMass() * 7)) - 22);
			}
			
			b.setxPOS(b.getxPOS() + b.getxVelocity()); //motion is always applied in the X direction
		}
	}
	
    /* Collisions are check by comparing each Ball object to each other Ball object in the arrayList using .intersects() (no equal comparisions)
     * If a collision is found, reverse the velocity of the two Ball objects
     */
	public static void checkCollisions() {
	    
		for (Ball b1 : Panel.balls) {
			for (Ball b2 : Panel.balls) {
				if (b1.Bounds().intersects(b2.Bounds()) && !b1.equals(b2)) {			//checking for collision and no equals comparisions
					int vX = b1.getxVelocity();
					int vY = b1.getyVelocity();
					b1.setxVelocity(b2.getxVelocity());								//reversing velocities of each Ball object
					b1.setyVelocity(b2.getyVelocity());
					b2.setxVelocity(vX);
					b2.setyVelocity(vY);
				}
			}
		}
	}
	
	public static void addBalls() {
		//Populates the ArrayList of Balls with new Ball objects
		for (int i = 0; i < numberOfBalls; i++) {
			Panel.balls.add(new Ball());
		}
	}
	
	public static void drawBalls(Graphics2D g2) {
		//Draws the balls at their given X, Y, and sixeX, and sizeY values
		for (Ball b : Panel.balls) {
			g2.setColor(b.getColor());
			g2.fillOval(b.getxPOS(), b.getyPOS(), b.getMass() * 7, b.getMass() * 7);
			g2.setColor(Color.black);
		}
	}
}
