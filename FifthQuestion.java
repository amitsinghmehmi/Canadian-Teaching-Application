import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 * 
 */

/**
 * @author Amit Singh Mehmi
 * Date: April 14th, 2022
 * Description: This class is called and executed after the fourth question. It is the fifth question
 *
 */
public class FifthQuestion extends JFrame implements ActionListener {
	
	// Static variables to access them within different classes, set tries and score to zero initially
	static int tries5 = 0;
	static int score5 = 0;
	
	// Setting up suspenseful audio
	File file2 = new File("suspense.wav");
	AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
	Clip clip2 = AudioSystem.getClip();
	
	// Setting up incorrect audio when user is wrong 
	File file3 = new File("wrong.wav");
	AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
	Clip clip3 = AudioSystem.getClip();
	
	// Setting up correct audio when user is correct 
	File file4 = new File("correct.wav");
	AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
	Clip clip4 = AudioSystem.getClip();
	
	// Static to access within different classes, set to whatever the user clicks
	static String answer5;
	
	// Creating buttons for the user to click with the options written on them
	JButton answerA = new JButton("A - 21 Years Old");
	JButton answerB = new JButton("B - 20 Years Old");
	JButton answerD = new JButton("D - 19 Years Old");
	JButton answerC = new JButton("C - 18 Years Old");
	
	// Declaring and initializing correct answer friendly image and incorrect answer image  
	ImageIcon correctAnswer = new ImageIcon("correctAnswer.png");
	ImageIcon tryAgain = new ImageIcon("tryAgain.png");


	/**
	 * @throws IOException, UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 *  Constructor 
	 */
	public FifthQuestion() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		// Setting size, title, and making it in the middle initially
		super("QUESTION 5");
		pack();
		setSize(815,550);
		setLocationRelativeTo(null);
		
		// Opening audio files and starting the suspenseful music
		clip2.open(audioStream2);
		clip3.open(audioStream3);
		clip4.open(audioStream4);
		clip2.start();
		
		// Answer A button
		answerA.setBounds(10,290,380,75);
		answerA.setFont(new Font("Serif", Font.BOLD, 20));
		answerA.setBackground(Color.WHITE);
		answerA.addActionListener(this);
		
		// Answer B button
		answerB.setBounds(10,390,380,75);
		answerB.setFont(new Font("Serif", Font.BOLD, 20));
		answerB.setBackground(Color.WHITE);
		answerB.addActionListener(this);
		
		// Answer D button
		answerD.setBounds(410,390,380,75);
		answerD.setFont(new Font("Serif", Font.BOLD, 20));
		answerD.setBackground(Color.WHITE);
		answerD.addActionListener(this);
		
		// Answer C button
		answerC.setBounds(410,290,380,75);
		answerC.setFont(new Font("Serif", Font.BOLD, 20));
		answerC.setBackground(Color.WHITE);
		answerC.addActionListener(this);
		
		// Putting an image with the question on it, on a button
		ImageIcon question = new ImageIcon("questionFive.png");
		JButton questionPic = new JButton(question);
		questionPic.setBounds(0,0,815,266);
		questionPic.setBorderPainted(false);
		
		// adding elements to the window 
		add(questionPic);
		add(answerA);
		add(answerB);
		add(answerC);
		add(answerD);
		
		// closing once x is clicked, setting background color, making it visible
		setLayout(null);
		getContentPane().setBackground(new Color(207,207,207));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	/*
	 * actionPerformed method to listen to buttons clicked 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Making the user's answer to whatever they click
		if (e.getSource() == answerA) {
			answer5 = "A - 21 Years Old";
		}
		else if (e.getSource() == answerB) {
			answer5 = "B - 20 Years Old";
		}
		else if (e.getSource() == answerC) {
			answer5 = "C - 18 Years Old";
			score5++;		// Adding one to the score if it answered correctly
		}
		else {
			answer5 = "D - 19 Years Old";
		}

		// If the user answers incorrectly before 3 tries, displaying incorrect and rerunning the same class method
		if (tries5 < 2 && e.getSource() != answerC) {

			clip2.stop();
			this.dispose();
			tries5 ++;
			clip3.start();
			JOptionPane.showMessageDialog(null, "Incorrect Answer! Try again! \nTries: " + tries5 + "/3", "Incorrect!", 
					JOptionPane.INFORMATION_MESSAGE, tryAgain);
			try {
				new FifthQuestion();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			}

		}
		// Otherwise if the user answer incorrectly after 3 tries, display they ran out of lives, the correct answer and move on to next question
		else if (tries5 < 3 && e.getSource() != answerC) {
			tries5++;
			clip2.stop();
			this.dispose();
			clip3.start();
			JOptionPane.showMessageDialog(null, "Sorry you ran out of tries! \nTries: " + tries5 + "/3" + "\n Answer was: C - 18 Years Old", 
					"Out of tries!", JOptionPane.INFORMATION_MESSAGE);
			try {
				new SixthQuestion();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  e2) {
				
			} 
		}
		// Otherwise the user must have a correct answer, display correct, move on to next question
		else {
			clip2.stop();
			this.dispose();
			clip4.start();
			tries5++;
			JOptionPane.showMessageDialog(null, "Correct Answer!" + "\nTries: " + tries5 + "\nAnswer was: C - 18 Years Old", 
					"Correct!", JOptionPane.INFORMATION_MESSAGE, correctAnswer);
			try {
				new SixthQuestion();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  e2) {
				
			} 
		}



	}


}
