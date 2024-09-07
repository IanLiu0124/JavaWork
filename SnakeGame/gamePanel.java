import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class gamePanel extends JPanel implements ActionListener{
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT = 25;
	static final int GAME_UNIT = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT;
	static final int DELAY = 75;
	int[] x = new int[GAME_UNIT];
	int[] y = new int[GAME_UNIT];
	int body = 7;
	int score;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean start = false;
	Timer timer;
	Random random;
	
	
	
	JButton myButton = new JButton();
	gamePanel()
	{
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new  MyKeyAdapter());
		startGame();
	}
	
	public void startGame()
	{
		newApple();
		start = true;
		timer = new Timer(DELAY, this);
		timer.start();
		
		
		
	}
	public void paintComponent(Graphics g) 
	//gets automatically called when the window is displayed
	{
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g)
	{
		for (int i=0; i<SCREEN_HEIGHT / UNIT ; i++)
		{
			g.drawLine(i*UNIT, SCREEN_HEIGHT, i*UNIT, 0);
			g.drawLine(0, i*UNIT, SCREEN_WIDTH, i*UNIT);
		}
	}
	public void newApple()
	{
		
	}
	public void move()
	{
		
	}
	public void checkApple()
	{
		
	}
	public void checkCollisions()
	{
		
	}
	public void gameOver(Graphics g)
	{
		
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e)
		{
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
