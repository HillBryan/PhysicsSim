import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Panel extends JPanel{
	
	public static ArrayList<Ball> balls = new ArrayList<Ball>();		//ArrayList of ball object for each simulation
	public static boolean collisionable = true;						//boolean for checking for collisions
	public static boolean Gravity = true;							//boolean for applying gravity
	public static int tick = 0;										//int the is incrememnted every .02 seconds (frame rate) and is used for applying gravity
	
	
    /* Panel constructor that fills the ball arrayList
     * Adds compnents to the JPanel
     * and adds an actionListener to the simulate button
     */ 
	public Panel() {
	    
		moveBalls();									//Starting the moveBalls Timer
		addFields();									//adding Components to the JPanel
		EnviromentController.addActionListener();	//adding the actionListener to the Simulate Button
	}
	
    // Basic paintComponent Method that is drawing the background, balls, text, and components
	public void paintComponent(Graphics g) {
	    
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(Color.LIGHT_GRAY);
		g2.fillRect(390, 0, 20, 800);						//Drawing the dividing bar between the balls and controlls
		EnviromentController.drawControlls(g2);				//Drawing the text, textBoxes, button, and drop down menues
		BallMovement.drawBalls(g2);							//Drawing the balls in the frame
	}
	
    /* The moveBalls method is a timer that is ticked every .02 seconds. In this time,
     *  Collisions are being checked, ball movement is applied, and gravity is applied as well.
     *  The frame is also repainted in this intervial as well.
     */
	public void moveBalls() {

		Timer time = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (collisionable) {
					BallMovement.checkCollisions();			//Collisions Check
				}
				BallMovement.moveBalls();					//Moving the balls
				if (Gravity) {
					BallMovement.applyGravity();				//Applying Gravity
				}
				repaint();									//repainting the frame
				tick++;
		}});
		time.start();
	}
	
    /* Adds the components to the JPanel
     * Components Include: textBoxes, drop-down Menues, and Buttons
     */
	public void addFields() {
		add(EnviromentController.numberOfBalls);				//adding the number of balls JTextField
		add(EnviromentController.maxSpawnX);					//adding the maxSpawnX JTextField
		add(EnviromentController.maxSpawnY);					//adding the maxSpawnY JTextField
		add(EnviromentController.color);						//adding the color JComboBox
		add(EnviromentController.collisions);				//adding the collisions JComboBox
		add(EnviromentController.gravity);					//adding the gravity JComboBox
		add(EnviromentController.start);						//adding the simulate JButton
		EnviromentController.start.setFocusable(false);		//removing the focus from the start button on start up
	}
}
