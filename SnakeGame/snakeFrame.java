import java.awt.*;

import javax.swing.*;
public class snakeFrame extends JFrame{
	gamePanel gamePanel = new gamePanel();
	buttonPanel buttons = new buttonPanel(gamePanel);
	snakeFrame()
	{
		this.setTitle("Snake");
		this.setLayout(new BorderLayout());
		this.setSize(613, 700);

		this.add(gamePanel, BorderLayout.NORTH);
//		this.add(new buttonPanel(gamePanel));
		this.add(buttons, BorderLayout.SOUTH);
		buttons.setBounds(600, 600, 600, 100);
		this.setVisible(true);
		

		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gamePanel myPanel = new gamePanel();

//		this.pack();
		this.setLocationRelativeTo(null);
	}

	
}
