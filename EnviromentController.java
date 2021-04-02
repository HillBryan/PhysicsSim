import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EnviromentController {
	
	public static JTextField numberOfBalls = new JTextField("100");
	public static JTextField maxSpawnX = new JTextField("10");
	public static JTextField maxSpawnY = new JTextField("10");
	
	public static JComboBox<String> color = new JComboBox<String>(new String[]{"Black", "Blue", "Red", "Green", "Orange", "Yellow", "Random"});
	public static JComboBox<String> collisions = new JComboBox<String>(new String[]{"Yes", "No"});
	public static JComboBox<String> gravity = new JComboBox<String>(new String[]{"Yes", "No"});

	public static JButton start = new JButton("Simulate");
	
	public static Font text =  new Font("Lucida Grande", Font.PLAIN, 25);
	
	public static void drawControlls(Graphics2D g2) {
		/* Draws the text above the Components and sets
		 * the size, font, and location of the components
		 */
		g2.setFont(text);
		g2.drawString("Number of Balls: ", 25, 50);			//drawing the text above the components
		g2.drawString("Color of Balls: ", 25, 150);
		g2.drawString("Max Spawn X-Velocity: ", 25, 250);
		g2.drawString("Max Spawn Y-Velocity: ", 25, 350);
		g2.drawString("Apply Gravity?", 25, 450);
		g2.drawString("Check for Collisions?", 25, 550);
		
		numberOfBalls.setLocation(25, 55);					//setting the location, size, and font of the numberOfBalls JTextField
		numberOfBalls.setSize(200, 50);
		numberOfBalls.setFont(text);
		
		maxSpawnX.setLocation(25, 255);						//setting the location, size, and font of the maxSpawnX JTextField
		maxSpawnX.setSize(200, 50);
		maxSpawnX.setFont(text);
		
		maxSpawnY.setLocation(25, 355);						//setting the location, size, and font of the maxSpawnY JTextField
		maxSpawnY.setSize(200, 50);
		maxSpawnY.setFont(text);
		
		color.setLocation(25, 155);							//setting the location, size, and font of the color JComboBox
		color.setPreferredSize(new Dimension(200, 50));
		color.setFont(text);
		
		collisions.setLocation(25, 555);						//setting the location, size, and font of the collisions JComboBox
		collisions.setPreferredSize(new Dimension(200, 50));
		collisions.setFont(text);
		
		gravity.setLocation(25, 455);						//setting the location, size, and font of the gravity JComboBox
		gravity.setPreferredSize(new Dimension(200, 50));
		gravity.setFont(text);
		
		start.setLocation(25, 650);							//setting the location, size, and font of the start JButton
		start.setSize(340, 100);
		start.setFont(text);
		
	}
	
    /* Adds an ActionListener to the simulate Button
     * When Clicked, all conditions from the Compnents above the button are transferred
     * to the new arrayList of Ball objects
     */
	public static void addActionListener() {

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Panel.balls.clear();														//clears the arrayList of Ball objects
				BallMovement.numberOfBalls = Integer.valueOf(numberOfBalls.getText());	//sets the number of ball objects for the new ArrayList
				
				if (Integer.valueOf(maxSpawnX.getText()) > 100) { 						//sets the maxSpawnX in the Ball class
					Ball.setMaxX(Integer.valueOf(100));
				}
				else {
					Ball.setMaxX(Integer.valueOf(maxSpawnX.getText()));
				}
				
				if (Integer.valueOf(maxSpawnY.getText()) > 100) {							//sets the maxSpawnY in the ball class
					Ball.setMaxY(Integer.valueOf(100));
				}
				else {
					Ball.setMaxY(Integer.valueOf(maxSpawnY.getText()));
				}
				
				BallMovement.addBalls();													//fills the ArrayList with new Ball objects
				
				if (collisions.getSelectedIndex() == 0) {								//applies collisions if selected
					Panel.collisionable = true;
				}
				else {
					Panel.collisionable = false;
				}
				
				if (gravity.getSelectedIndex() == 0) {									//applies gravity if selected, the energyLost per collision is also changed
					Panel.Gravity = true;
					BallMovement.energyLost = 14;
				}
				else {
					Panel.Gravity = false;
					BallMovement.energyLost = 0;
				}
				
				for (Ball b : Panel.balls) {												//sets the color of the balls based on the the user Preference
					switch(color.getSelectedIndex()) {
						case (0) : 
							b.setColor(Color.BLACK);
							break;
						case (1) :
							b.setColor(Color.BLUE);
							break;
						case (2) :
							b.setColor(Color.RED);
							break;
						case (3) :
							b.setColor(Color.GREEN);
							break;
						case (4) : 
							b.setColor(Color.ORANGE);
							break;
						case (5) : 
							b.setColor(Color.YELLOW);
							break;
						case (6) : 
							int random = (int)(Math.random() * 7);
							switch(random) {
								case (0) : 
									b.setColor(Color.GREEN);
									break;
								case (1) :
									b.setColor(Color.BLUE);
									break;
								case (2) :
									b.setColor(Color.RED);
									break;
								case (3) :
									b.setColor(Color.BLACK);
									break;
								case (4) : 
									b.setColor(Color.ORANGE);
									break;
								case (5) : 
									b.setColor(Color.YELLOW);
									break;
								case (6) : 
									b.setColor(Color.MAGENTA);
									break;
							}
							break;
					}
				}
			}});
	}
}
