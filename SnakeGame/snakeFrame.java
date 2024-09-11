import javax.swing.*;
public class snakeFrame extends JFrame{
	gamePanel gamePanel = new gamePanel();
	buttonPanel buttons = new buttonPanel(gamePanel);
	snakeFrame()
	{
		this.setTitle("Snake");
//		this.setLayout(null);
		this.setSize(600, 700);

//		this.add(gamePanel);
//		this.add(new buttonPanel(gamePanel));
		this.add(buttons);
		buttons.setBounds(600, 600, 600, 100);
		this.setVisible(true);
		

		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gamePanel myPanel = new gamePanel();

//		this.pack();
		this.setLocationRelativeTo(null);
	}

	
}
