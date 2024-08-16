import javax.swing.*;
public class snakeFrame extends JFrame{
	
	snakeFrame()
	{
		this.setTitle("Snake");
		this.setSize(500, 200);
		this.setVisible(true);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gamePanel myPanel = new gamePanel();
		this.add(new gamePanel());
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args)
	{
		
	}

	
}
