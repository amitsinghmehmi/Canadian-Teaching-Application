import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

/**
 * 
 */

/**
 * @author Amit Singh Memhi
 * Date: April 12th, 2022
 * Description: The purpose of the software is to quiz students about Canada. There will be 15 questions.
 * 10 related to prime ministers and 5 random trivia of Canada.  
 *
 */
public class CTAApplication extends JFrame implements ActionListener{
	
	
	// Global variables to access them in different methods within the class
	
	// Declare and initialize positional values for animation
	int x = 355, y = 100, delay = 10;
	ImageIcon backGnd;	// Background image with maple leafs

	// Making static variables to access them within different classes 
	static int numRedoQuiz = 1;			// Initialize number of times user re-does the quiz
	static String username, studentNum; 	// Declare users name and student number

	JButton continuation = new JButton("Continue");		// continuation button declared to access within different methods 
	
	// Adding audio learned from YouTube video: https://www.youtube.com/watch?v=SyZQVJiARTQ
	File file = new File("intromusic.wav");
	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	Clip clip = AudioSystem.getClip();

	/**
	 * Constructor
	 * @throws IOException 
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 */
	public CTAApplication() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		// Setting size, title, and layout
		super("Canadian Teaching Assistant (CTA)");	
		pack();										// Puts window in the middle
		setSize(613,355);							
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Initializing background variable to the background image 
		backGnd = new ImageIcon("main_background.png");
		
		// Open the audio and start the main menu music 
		clip.open(audioStream);
		clip.start();
		
		// Add the continuation button to the window
		continuation.setBounds(220, 200, 150, 25);
		continuation.setFont(new Font("Serif", Font.BOLD, 14));
		continuation.addActionListener(this);
		add(continuation);
		
		// Closes when x clicked, and makes it visble to the user 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/*
	 *  Paint Method 
	 */
	public void paint(Graphics g) {
		
		// The word Canadian moving on the screen until a certain location reached 
		for (int i = 0 ; i < 1000 ; i++) {

			backGnd.paintIcon(this, g, 0, 0);
			x = x - 5;							// moving to the left


			g.setFont(new Font("Serif", 3, 36));
			g.drawString("Canadian",x, 180);

			try {
				Thread.sleep(delay);		// creating a delay to trick as animation
			}
			catch(Exception error) {

			}

			if (x < 100) {
				x = 613;	
				break;		// break out of for loop after reaching 100x
			}
		}
		
		// The word teaching moving on the screen until a certain location reached 
		for (int i = 0 ; i < 1000 ; i++) {

			backGnd.paintIcon(this, g, 0, 0);

			g.setFont(new Font("Serif", 3, 36));
			g.drawString("Canadian",100, 180);

			x = x - 5;				// moving to the left

			g.setFont(new Font("Serif", 3, 36));
			g.drawString("Teaching", x, 180);


			try {
				Thread.sleep(delay);	// delaying for animation
			}
			catch(Exception error) {

			}

			if (x < 250) {
				x = 0;
				break;			// break out of for loop after reaching 250x
			}
		}
		
		// The word assistant moving on the screen
		for (int i = 0 ; i < 1000 ; i++) {

			backGnd.paintIcon(this, g, 0, 0);

			g.setFont(new Font("Serif", 3, 36));
			g.drawString("Teaching", 250, 180);


			g.setFont(new Font("Serif", 3, 36));
			g.drawString("Canadian",100, 180);

			x = x + 5;		// moving to the right 

			g.setFont(new Font("Serif", 3, 36));
			g.drawString("Assistant", x, 180);


			try {
				Thread.sleep(delay);		// delaying for animation
			}
			catch(Exception error) {

			}

			if (x > 390) {
				break;			// break out of for loop after reaching 390x
			}


		}

	}

	/**
	 * @param args
	 * @throws UnsupportedAudioFileException 
	 * @throws IOException 
	 * @throws LineUnavailableException 
	 */
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		new CTAApplication();	// calling the constructor in the main method to run it

	}

	/*
	 * Getting user information window method
	 */
	public static void enterNameWindow() {
		
		// If user's first try, ask them for their name 
		if (CTAApplication.numRedoQuiz == 1) {
			JTextField name = new JTextField();		// JTextField to allow the user to input
			JTextField number = new JTextField();

			Object[] fields = {						// Making an object with the name and number to make it display in joptiopane
					"Enter Name:", name,
					"Enter Student Number:", number
			};
			
			// Window with the fields object 
			int option = JOptionPane.showConfirmDialog(null, fields, "ENTER INFORMATION",JOptionPane.OK_CANCEL_OPTION);
			
			// Storing user's name and student number
			username = name.getText();
			studentNum = number.getText();
			
			// If the user clicks the ok button continue to the first question
			if(option == JOptionPane.OK_OPTION) {
				try {
					new FirstQuestion();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  e) {	// handle the exceptions to avoid rewriting throws declaration

				} 
			}

		}
		
		else {	// otherwise the user must be on the second try 
			
			try {
				new FirstQuestion();	// skip asking the user's name and go straight to first question again
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  e) {

			} 
			
		}

	}
	
	/*
	 * ActionPerformed method 
	 * Allows the program to go to the user information window once continue is clicked in the animation window 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == continuation){
			clip.stop();	// stops the audio
			this.dispose();		// closes the window 
			enterNameWindow();	// goes to the user information window
		}

	}

}
