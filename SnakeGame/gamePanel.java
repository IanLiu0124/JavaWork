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
		this.requestFocusInWindow();
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
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNIT, UNIT);
		
		for (int i = 0; i < body ; i++)
		{
			if (i==0)
			{
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT, UNIT);
			}
			else
			{
				g.setColor(new Color(45,180,0));
				g.fillRect(x[i], y[i], UNIT, UNIT);
				}
		}
		
		
	}
	public void newApple()
	{
		//Generate a new apple whenever this is called
		//My method:
		appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT))* UNIT;
		appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT)) * UNIT;
		

		
	}
	public void move()
	{			
		for(int i= body; i>0 ; i--)
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction)
		{
		case 'U':
			y[0] = y[0] - UNIT;
			break;
		case 'D':
			y[0] = y [0] + UNIT;
			break;
		case 'R':
			x[0] = x[0] + UNIT;
			break;
		case 'L':
			x[0] = x[0] - UNIT;
			break;
		}
	}
	public void checkApple()
	{
		if(x[0] == appleX && y[0] == appleY)
		{
			newApple();
		}
	}
	public void checkCollisions()
	{
		for (int i = body; i > 0; i--)
		{
			if(x[0] == x[i] && y[0] == y[i])
			{
				start = false;
			}
		}
		
		if(x[0] > SCREEN_WIDTH || x[0] < 0)
		{
			start = false;
		}
		if(y[0] < 0 || y[0] > SCREEN_HEIGHT)
		{
			start = false;
		}
	}
	public void gameOver(Graphics g)
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(start)
		{
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e)
		{
			 System.out.println("Key Pressed: " + e.getKeyCode());
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_LEFT:
				if(direction !='R')
				{
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction !='L')
				{
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D')
				{
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U')
				{
					direction = 'D';
					
				}
				break;
				
		}
	}
	
	}
}
