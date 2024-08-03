import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TicTacToe extends JFrame implements ActionListener{

	JFrame myFrame = new JFrame();
	static JButton myButtons[] = new JButton[9];
	static JPanel myPanel = new JPanel();
	static JButton startButton = new JButton("Start");
	static JLabel playerLabel;
	static boolean player1Turn;
	static boolean win;
	public TicTacToe()
	{
		myFrame.setSize(230, 350);
		myFrame.setVisible(true);
		myFrame.setLayout(new BorderLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setLayout(new GridLayout(3, 3, 10, 10));
		
		for(int i=0 ; i<myButtons.length; i++)
		{
			myButtons[i] = new JButton("");
			myButtons[i].setPreferredSize(new Dimension(40, 40));
			myButtons[i].addActionListener(this);
			myPanel.add(myButtons[i]);
		}
		myFrame.add(myPanel, BorderLayout.NORTH);
		startButton.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		myFrame.add(startButton, BorderLayout.SOUTH);
		myPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		ActionListener myAction = (ActionEvent e)->
		{
			resetGame();
		};
	}
	
	public static void resetGame()
	{
		for (JButton button : myButtons) {
            button.setText("");
        }
        player1Turn = true;
        playerLabel.setText("Player X's Turn");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
