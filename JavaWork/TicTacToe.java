import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TicTacToe extends JFrame implements ActionListener{

	JFrame myFrame = new JFrame("Tic-Tac-Toe");
	static JButton myButtons[] = new JButton[9];
	static JPanel myPanel = new JPanel();
	static JButton startButton = new JButton("Start");
	static JLabel playerLabel = new JLabel("Player 1's Turn");
	static JPanel southPanel = new JPanel();
	static boolean player1Turn;
	static boolean win;
	public TicTacToe()
	{
		myFrame.setSize(230, 350);
		myFrame.setVisible(true);
		myFrame.setLayout(new BorderLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setLayout(new GridLayout(3, 3, 10, 10));
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		ActionListener resetGame = (ActionEvent e)->
		{
			resetGame();
		};
		
		startButton.addActionListener(resetGame);
		
		for(int i=0 ; i<myButtons.length; i++)
		{
			myButtons[i] = new JButton("");
			myButtons[i].setPreferredSize(new Dimension(40, 40));
			myButtons[i].addActionListener(this);
			myPanel.add(myButtons[i]);
		}
		myFrame.add(myPanel, BorderLayout.NORTH);
		playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
		southPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		southPanel.add(playerLabel);
		southPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		southPanel.add(startButton);
		
		//myFrame.add(startButton, BorderLayout.SOUTH);
		myFrame.add(southPanel, BorderLayout.SOUTH);
		myPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
}

	
	public static void resetGame()
	{
		for (JButton button : myButtons) {
            button.setText("");
        }
        player1Turn = true;
        playerLabel.setText("Player 1's Turn");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    JButton clickedButton = (JButton) e.getSource(); //Casting it to JButton because e.getSource() returns object

	        if (clickedButton.getText().equals("")) {
	            clickedButton.setText(player1Turn ? "X" : "O");
	            player1Turn = !player1Turn;
	            playerLabel.setText("Player " + (player1Turn ? "2" : "1") + "'s Turn");
		
	}
	        if (checkWin()) {
                JOptionPane.showMessageDialog(myFrame, "Player " + (player1Turn ? "1" : "2") + " wins!");
                resetGame();
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(myFrame, "The game is a draw!");
                resetGame();
            }

}
    private boolean checkWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < myButtons.length; i++) {
            board[i / 3][i % 3] = myButtons[i].getText();
        }

        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) {
                return true;
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return true;
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (JButton button : myButtons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }
}

