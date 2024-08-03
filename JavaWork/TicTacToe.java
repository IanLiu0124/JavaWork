import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {

	JFrame myFrame = new JFrame();
	JButton myButtons[] = new JButton[9];
	JPanel myPanel = new JPanel();
	public TicTacToe()
	{
		myFrame.setSize(900, 400);
		myFrame.setVisible(true);
		myFrame.setLayout(new BorderLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setLayout(new GridLayout(3, 3, 10, 10));
		
		for(int i=0 ; i<myButtons.length; i++)
		{
			myButtons[i] = new JButton(" Hello ");
			myButtons[i].setSize(50, 50);
			myPanel.add(myButtons[i]);
		}
		myFrame.add(myPanel, BorderLayout.NORTH);
		myPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe();
	}

}
