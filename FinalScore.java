import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Amit Singh Mehmi
 * Description: This class method gets called after question fifteen is completed and shows
 * 				the user's score with a grade level and prompts if the user would like to play
 * 				again
 *
 */
public class FinalScore extends JFrame implements ActionListener {

	// Making the continue button a global variable to access it within different methods 
	JButton continuation = new JButton("Play Again");
	
	ImageIcon gameOver = new ImageIcon ("gameOver.png");
	
	/**
	 * 
	 */
	public FinalScore() {
		
		// set title, in the middle of the screen, and size
		super("Final Score");
		pack();
		setSize(900,700);
		setLocationRelativeTo(null);
		
		// Declaring and initializing the user's grade level as an empty string
		String gradeLevel = null;
		
		// User's total score is the sum of all the scores at each question answered, scores were accessed by writing the class name then dot the variable name to access
		int totalScore = FirstQuestion.score1 + SecondQuestion.score2 + ThirdQuestion.score3 + FourthQuestion.score4 + 
				FifthQuestion.score5 + SixthQuestion.score6 + SeventhQuestion.score7 + EighthQuestion.score8 + NinethQuestion.score9 
				+ TenthQuestion.score10 + EleventhQuestion.score11 + TwelvethQuestion.score12 + ThirteenthQuestion.score13 + FourteenthQuestion.score14 + 
				FifteenthQuestion.score15;
		
		// User's average 
		double average = (totalScore / 15.0) * 100;
		
		// Setting up deciaml format for user's average 
		DecimalFormat oneDigit = new DecimalFormat("#0");
		
		// Conditions of the user's average, setting grade level accordingly 
		if (average < 50) {
			gradeLevel = "R";
		}
		else if (average >= 50 && average < 53) {
			gradeLevel = "1-";
		}
		else if (average >= 53 && average < 57) {
			gradeLevel = "1";
		}
		else if (average >= 57 && average < 60) {
			gradeLevel = "1+";
		}
		else if (average >= 60 && average < 63) {
			gradeLevel = "2-";
		}
		else if (average >= 63 && average < 67) {
			gradeLevel = "2";
		}
		else if (average >= 67 && average < 70) {
			gradeLevel = "2+";
		}
		else if (average >= 70 && average < 73) {
			gradeLevel = "3-";
		}
		else if (average >= 73 && average < 77) {
			gradeLevel = "3";
		}
		else if (average >= 77 && average < 80) {
			gradeLevel = "3+";
		}
		else if (average >= 80 && average < 87) {
			gradeLevel = "4-";
		}
		else if (average >= 87 && average < 95) {
			gradeLevel = "4";
		}
		else if (average >= 95 && average < 98) {
			gradeLevel = "4+";
		}
		else {
			gradeLevel = "4++";
		}
		
		// setting continue button size, font and listener 
		continuation.setBounds(600,575,250,50);
		continuation.setFont(new Font("Serif", Font.BOLD, 18));
		continuation.addActionListener(this);
		
		// User's answer label with their name 
		JLabel usersAnswersLabel = new JLabel();
		usersAnswersLabel.setText(CTAApplication.username + "'s Answers");
		usersAnswersLabel.setBounds(40,60,300,20);
		usersAnswersLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label titled correct answers 
		JLabel correctAnswersLabel = new JLabel();
		correctAnswersLabel.setText("Correct Answers");
		correctAnswersLabel.setBounds(340,60,300,20);
		correctAnswersLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label titled number of tries 
		JLabel triesLabel = new JLabel();
		triesLabel.setText("Number of Tries");
		triesLabel.setBounds(540,60,300,20);
		triesLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label titled grade level
		JLabel gradeLevelLabel = new JLabel();
		gradeLevelLabel.setText("Grade Level: " + gradeLevel);
		gradeLevelLabel.setBounds(400,560,300,20);
		gradeLevelLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label with the number of correct answers 
		JLabel numCorrectLabel = new JLabel();
		numCorrectLabel.setText("Number of Correct Answers: " + totalScore);
		numCorrectLabel.setBounds(50,560,300,20);
		numCorrectLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label with the number of incorrect answers 
		JLabel numWrongLabel = new JLabel();
		numWrongLabel.setText("Number of Incorrect Answers: " + (15 - totalScore));
		numWrongLabel.setBounds(50,600,300,20);
		numWrongLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label with user's percentage 
		JLabel percentageLabel = new JLabel();
		percentageLabel.setText("Percentage: " + oneDigit.format(average) + "%");
		percentageLabel.setBounds(400,600,300,20);
		percentageLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Label titled scores 
		JLabel scoresLabel = new JLabel();
		scoresLabel.setText("Scores");
		scoresLabel.setBounds(750,60,300,20);
		scoresLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// question 15, user's answer, correct answer, user's tries, and their score  
		JLabel answer15 = new JLabel();
		answer15.setText("Question 15:   " + FifteenthQuestion.answer15);
		answer15.setBounds(40,520,300,20);
		JLabel correctAnswers15 = new JLabel();
		correctAnswers15.setText("C - Three Oceans");
		correctAnswers15.setBounds(340,520,300,20);
		JLabel numTries15 = new JLabel();
		numTries15.setText(FifteenthQuestion.tries15 + "/3");
		numTries15.setBounds(600,520,150,20);
		JLabel score15 = new JLabel();
		score15.setText(Integer.toString(FifteenthQuestion.score15) + "/1");
		score15.setBounds(765,520,150,20);
		
		// question 14, user's answer, correct answer, user's tries, and their score  
		JLabel answer14 = new JLabel();
		answer14.setText("Question 14:   " + FourteenthQuestion.answer14);
		answer14.setBounds(40,490,200,20);
		JLabel correctAnswers14 = new JLabel();
		correctAnswers14.setText("B - Six Time Zones");
		correctAnswers14.setBounds(340,490,300,20);
		JLabel numTries14 = new JLabel();
		numTries14.setText(FourteenthQuestion.tries14 + "/3");
		numTries14.setBounds(600,490,150,20);
		JLabel score14 = new JLabel();
		score14.setText(Integer.toString(FourteenthQuestion.score14) + "/1");
		score14.setBounds(765,490,150,20);
		
		// question 13, user's answer, correct answer, user's tries, and their score  
		JLabel answer13 = new JLabel();
		answer13.setText("Question 13:   " + ThirteenthQuestion.answer13);
		answer13.setBounds(40,460,300,20);
		JLabel correctAnswers13 = new JLabel();
		correctAnswers13.setText("D - Blueberries");
		correctAnswers13.setBounds(340,460,300,20);
		JLabel numTries13 = new JLabel();
		numTries13.setText(ThirteenthQuestion.tries13 + "/3");
		numTries13.setBounds(600,460,150,20);
		JLabel score13 = new JLabel();
		score13.setText(Integer.toString(ThirteenthQuestion.score13) + "/1");
		score13.setBounds(765,460,150,20);
		
		// question 12, user's answer, correct answer, user's tries, and their score  
		JLabel answer12 = new JLabel();
		answer12.setText("Question 12:   " + TwelvethQuestion.answer12);
		answer12.setBounds(40,430,300,20);
		JLabel correctAnswers12 = new JLabel();
		correctAnswers12.setText("A - Ice Hockey");
		correctAnswers12.setBounds(340,430,300,20);
		JLabel numTries12 = new JLabel();
		numTries12.setText(TwelvethQuestion.tries12 + "/3");
		numTries12.setBounds(600,430,150,20);
		JLabel score12 = new JLabel();
		score12.setText(Integer.toString(TwelvethQuestion.score12) + "/1");
		score12.setBounds(765,430,150,20);
		
		// question 11, user's answer, correct answer, user's tries, and their score  
		JLabel answer11 = new JLabel();
		answer11.setText("Question 11:   " + EleventhQuestion.answer11);
		answer11.setBounds(40,400,300,20);
		JLabel correctAnswers11 = new JLabel();
		correctAnswers11.setText("C - 11 Points");
		correctAnswers11.setBounds(340,400,300,20);
		JLabel numTries11 = new JLabel();
		numTries11.setText(EleventhQuestion.tries11 + "/3");
		numTries11.setBounds(600,400,150,20);
		JLabel score11 = new JLabel();
		score11.setText(Integer.toString(EleventhQuestion.score11) + "/1");
		score11.setBounds(765,400,150,20);
		
		// question 10, user's answer, correct answer, user's tries, and their score  
		JLabel answer10 = new JLabel();
		answer10.setText("Question 10:   " + TenthQuestion.answer10);
		answer10.setBounds(40,370,300,20);
		JLabel correctAnswers10 = new JLabel();
		correctAnswers10.setText("B - Charles Tupper");
		correctAnswers10.setBounds(340,370,300,20);
		JLabel numTries10 = new JLabel();
		numTries10.setText(TenthQuestion.tries10 + "/3");
		numTries10.setBounds(600,370,150,20);
		JLabel score10 = new JLabel();
		score10.setText(Integer.toString(TenthQuestion.score10) + "/1");
		score10.setBounds(765,370,150,20);
		
		// question 9, user's answer, correct answer, user's tries, and their score  
		JLabel answer9 = new JLabel();
		answer9.setText("Question 9:   " + NinethQuestion.answer9);
		answer9.setBounds(40,340,300,20);
		JLabel correctAnswers9 = new JLabel();
		correctAnswers9.setText("B - Wilfrid Laurier");
		correctAnswers9.setBounds(340,340,300,20);
		JLabel numTries9 = new JLabel();
		numTries9.setText(NinethQuestion.tries9 + "/3");
		numTries9.setBounds(600,340,150,20);
		JLabel score9 = new JLabel();
		score9.setText(Integer.toString(NinethQuestion.score9) + "/1");
		score9.setBounds(765,340,150,20);
		
		// question 8, user's answer, correct answer, user's tries, and their score  
		JLabel answer8 = new JLabel();
		answer8.setText("Question 8:   " + EighthQuestion.answer8);
		answer8.setBounds(40,310,300,20);
		JLabel correctAnswers8 = new JLabel();
		correctAnswers8.setText("D - Joe Clark");
		correctAnswers8.setBounds(340,310,300,20);
		JLabel numTries8 = new JLabel();
		numTries8.setText(EighthQuestion.tries8 + "/3");
		numTries8.setBounds(600,310,150,20);
		JLabel score8 = new JLabel();
		score8.setText(Integer.toString(EighthQuestion.score8) + "/1");
		score8.setBounds(765,310,150,20);
		
		// question 7, user's answer, correct answer, user's tries, and their score  
		JLabel answer7 = new JLabel();
		answer7.setText("Question 7:   " + SeventhQuestion.answer7);
		answer7.setBounds(40,280,300,20);
		JLabel correctAnswers7 = new JLabel();
		correctAnswers7.setText("A - Kim Campbell");
		correctAnswers7.setBounds(340,280,300,20);
		JLabel numTries7 = new JLabel();
		numTries7.setText(SeventhQuestion.tries7 + "/3");
		numTries7.setBounds(600,280,150,20);
		JLabel score7 = new JLabel();
		score7.setText(Integer.toString(SeventhQuestion.score7) + "/1");
		score7.setBounds(765,280,150,20);
		
		// question 6, user's answer, correct answer, user's tries, and their score  
		JLabel answer6 = new JLabel();
		answer6.setText("Question 6:   " + SixthQuestion.answer6);
		answer6.setBounds(40,250,300,20);
		JLabel correctAnswers6 = new JLabel();
		correctAnswers6.setText("D - The Right Honourable");
		correctAnswers6.setBounds(340,250,300,20);
		JLabel numTries6 = new JLabel();
		numTries6.setText(SixthQuestion.tries6 + "/3");
		numTries6.setBounds(600,250,150,20);
		JLabel score6 = new JLabel();
		score6.setText(Integer.toString(SixthQuestion.score6) + "/1");
		score6.setBounds(765,250,150,20);
		
		// question 5, user's answer, correct answer, user's tries, and their score  
		JLabel answer5 = new JLabel();
		answer5.setText("Question 5:   " + FifthQuestion.answer5);
		answer5.setBounds(40,220,300,20);
		JLabel correctAnswers5 = new JLabel();
		correctAnswers5.setText("C - 18 Years Old");
		correctAnswers5.setBounds(340,220,300,20);
		JLabel numTries5 = new JLabel();
		numTries5.setText(FifthQuestion.tries5 + "/3");
		numTries5.setBounds(600,220,150,20);
		JLabel score5 = new JLabel();
		score5.setText(Integer.toString(FifthQuestion.score5) + "/1");
		score5.setBounds(765,220,150,20);
		
		// question 4, user's answer, correct answer, user's tries, and their score  
		JLabel answer4 = new JLabel();
		answer4.setText("Question 4:   " + FourthQuestion.answer4);
		answer4.setBounds(40,190,300,20);
		JLabel correctAnswers4 = new JLabel();
		correctAnswers4.setText("B - 79 Years Old");
		correctAnswers4.setBounds(340,190,300,20);
		JLabel numTries4 = new JLabel();
		numTries4.setText(FourthQuestion.tries4 + "/3");
		numTries4.setBounds(600,190,150,20);
		JLabel score4 = new JLabel();
		score4.setText(Integer.toString(FourthQuestion.score4) + "/1");
		score4.setBounds(765,190,150,20);
		
		// question 3, user's answer, correct answer, user's tries, and their score  
		JLabel answer3 = new JLabel();
		answer3.setText("Question 3:   " + ThirdQuestion.answer3);
		answer3.setBounds(40,160,300,20);
		JLabel correctAnswers3 = new JLabel();
		correctAnswers3.setText("C - Sir Wilfrid Laurier");
		correctAnswers3.setBounds(340,160,300,20);
		JLabel numTries3 = new JLabel();
		numTries3.setText(ThirdQuestion.tries3 + "/3");
		numTries3.setBounds(600,160,150,20);
		JLabel score3 = new JLabel();
		score3.setText(Integer.toString(ThirdQuestion.score3) + "/1");
		score3.setBounds(765,160,150,20);
		
		// question 2, user's answer, correct answer, user's tries, and their score  
		JLabel answer2 = new JLabel();
		answer2.setText("Question 2:   " + SecondQuestion.answer2);
		answer2.setBounds(40,130,300,20);
		JLabel correctAnswers2 = new JLabel();
		correctAnswers2.setText("A - Conservatives");
		correctAnswers2.setBounds(340,130,300,20);
		JLabel numTries2 = new JLabel();
		numTries2.setText(SecondQuestion.tries2 + "/3");
		numTries2.setBounds(600,130,150,20);
		JLabel score2 = new JLabel();
		score2.setText(Integer.toString(SecondQuestion.score2) + "/1");
		score2.setBounds(765,130,150,20);
		
		// question 1, user's answer, correct answer, user's tries, and their score  
		JLabel answer1 = new JLabel();
		answer1.setText("Question 1:   " + FirstQuestion.answer1);
		answer1.setBounds(40,100,300,20);
		JLabel correctAnswers1 = new JLabel();
		correctAnswers1.setText("A - John A. MacDonald");
		correctAnswers1.setBounds(340,100,300,20);
		JLabel numTries1 = new JLabel();
		numTries1.setText(FirstQuestion.tries1 + "/3");
		numTries1.setBounds(600,100,150,20);
		JLabel score1 = new JLabel();
		score1.setText(Integer.toString(FirstQuestion.score1) + "/1");
		score1.setBounds(765,100,150,20);
		
		// Adding all elements to the window 
		add(continuation);
		add(answer15);
		add(answer14);
		add(answer13);
		add(answer12);
		add(answer11);
		add(answer10);
		add(answer9);
		add(answer8);
		add(answer7);
		add(answer6);
		add(answer5);
		add(answer4);
		add(answer3);
		add(answer2);
		add(answer1);
		add(usersAnswersLabel);
		add(correctAnswers1);
		add(correctAnswers2);
		add(correctAnswers3);
		add(correctAnswers4);
		add(correctAnswers5);
		add(correctAnswers6);
		add(correctAnswers7);
		add(correctAnswers8);
		add(correctAnswers9);
		add(correctAnswers10);
		add(correctAnswers11);
		add(correctAnswers12);
		add(correctAnswers13);
		add(correctAnswers14);
		add(correctAnswers15);
		add(correctAnswersLabel);
		add(triesLabel);
		add(numTries1);
		add(numTries2);
		add(numTries3);
		add(numTries4);
		add(numTries5);
		add(numTries6);
		add(numTries7);
		add(numTries8);
		add(numTries9);
		add(numTries10);
		add(numTries11);
		add(numTries12);
		add(numTries13);
		add(numTries14);
		add(numTries15);
		add(gradeLevelLabel);
		add(scoresLabel);
		add(score1);
		add(score2);
		add(score3);
		add(score4);
		add(score5);
		add(score6);
		add(score7);
		add(score8);
		add(score9);
		add(score10);
		add(score11);
		add(score12);
		add(score13);
		add(score14);
		add(score15);
		add(numCorrectLabel);
		add(numWrongLabel);
		add(percentageLabel);
		
		// setting layout to null, setting background color, exiting once x is clicked, and making everything visible to the user
		setLayout(null);
		getContentPane().setBackground(new Color(207,207,207));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	/*
	 * Actionperformed method, listens to the play again button once clicked 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == continuation) {			// Once user clicks play again
			if (CTAApplication.numRedoQuiz < 2) {		// If number of redos is less than 2 reset all scores and tries and execute the main menu again
				CTAApplication.numRedoQuiz++;
				this.dispose();
				try {
					FirstQuestion.score1 = 0;
					SecondQuestion.score2 = 0;
					ThirdQuestion.score3 = 0;
					FourthQuestion.score4 = 0;
					FifthQuestion.score5 = 0;
					SixthQuestion.score6 = 0; 
					SeventhQuestion.score7 = 0; 
					EighthQuestion.score8 = 0; 
					NinethQuestion.score9 = 0;
					TenthQuestion.score10 = 0; 
					EleventhQuestion.score11 = 0; 
					TwelvethQuestion.score12 = 0; 
					ThirteenthQuestion.score13 = 0; 
					FourteenthQuestion.score14 = 0;
					FifteenthQuestion.score15 = 0;
					FirstQuestion.tries1 = 0;
					SecondQuestion.tries2 = 0;
					ThirdQuestion.tries3 = 0;
					FourthQuestion.tries4 = 0;
					FifthQuestion.tries5 = 0;
					SixthQuestion.tries6 = 0;
					SeventhQuestion.tries7 = 0;
					EighthQuestion.tries8 = 0;
					NinethQuestion.tries9 = 0;
					TenthQuestion.tries10 = 0;
					EleventhQuestion.tries11 = 0;
					TwelvethQuestion.tries12 = 0;
					ThirteenthQuestion.tries13 = 0;
					FourteenthQuestion.tries14 = 0;
					FifteenthQuestion.tries15 = 0;
	
					new CTAApplication();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
				}
			}
			
			else {					// otherwise end the quiz with a friendly message 
				this.dispose();
				JOptionPane.showMessageDialog(null,"Maxiumum Amount of Plays Exceeded, Thanks for playing " + CTAApplication.username + "!", "Plays Exceeded!", JOptionPane.INFORMATION_MESSAGE, gameOver);
			}

		}
		
	}

}

