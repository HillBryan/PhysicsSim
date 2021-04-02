import javax.swing.JFrame;

public class Runner {
    
    /* Basic JFrame setup with certian conditions set to false
     * as to make sure that the painting of components isn't messed up.
     */
	public static void main(String[] args) {
	    
		JFrame window = new JFrame("Gravtity Simulation");
			window.setSize(1200, 800);
			window.setLocationRelativeTo(null);
			window.setContentPane(new Panel());
			window.setVisible(true);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
