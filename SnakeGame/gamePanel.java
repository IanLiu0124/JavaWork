import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class gamePanel extends JPanel implements ActionListener{
	
	static final int SCREEN_WIDTH = 600	;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT = 25;
	static final int GAME_UNIT = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT;
	static final int DELAY = 95;
	int[] x = new int[GAME_UNIT];
	int[] y = new int[GAME_UNIT];
	int body = 7;
	int score;
	int numberOfApples =2 ;
	int[] appleX = new int[numberOfApples];
	int[] appleY = new int[numberOfApples];
	char direction = 'R';
	boolean start = false;
	boolean collided = false;
	char nextDirection = 'R';
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
		for(int i = 1; i < body; i++)
		{
			x[i] = 0;
			y[i] = 0;
		}
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
			for(int i = 0; i < numberOfApples; i++)
			{
				g.setColor(Color.red);
				g.fillOval(appleX[i], appleY[i], UNIT, UNIT);
			}
			
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
			g.setColor(Color.yellow);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + score, (SCREEN_WIDTH - metrics.stringWidth("Score: " + score)) /2 ,g.getFont().getSize());
		if(!start)
		{
			gameOver(g);
		}
		
	}
	public void newApple()
	{
		//Generate a new apple whenever this is called
		//My method:
		for(int i =0 ; i < numberOfApples; i++)
		{
			appleX[i] = random.nextInt((int)(SCREEN_WIDTH / UNIT))* UNIT;
			appleY[i] = random.nextInt((int)(SCREEN_HEIGHT / UNIT)) * UNIT;
		}
	}
	public void colidedApple(int x)
	{
		appleX[x] = random.nextInt((int)(SCREEN_WIDTH / UNIT))* UNIT;
		appleY[x] = random.nextInt((int)(SCREEN_HEIGHT / UNIT)) * UNIT;
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
		for(int i = 0; i < numberOfApples ; i++)
		{
			if(x[0] == appleX[i] && y[0] == appleY[i])
			{
				body++;
				score++;
				colidedApple(i);
				timer.setDelay(timer.getDelay()-3);
			}
		}

	}
	public void checkCollisions()
	{
		for (int i = body; i > 0; i--)
		{
			if(x[0] == x[i] && y[0] == y[i])
			{
				timer.stop();
				start = false;
			}
		}
		
		if(x[0] > SCREEN_WIDTH || x[0] < 0)
		{
			timer.stop();
			start = false;
		}
		if(y[0] < 0 || y[0] > SCREEN_HEIGHT)
		{
			timer.stop();
			start = false;
		}
	}
	public void gameOver(Graphics g)
	{
		//Game Overtext
		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT / 2);
		g.setColor(Color.yellow);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Score: " + score, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + score)) /2 ,g.getFont().getSize());
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		String continuing = "Press Space To Continue...";
		g.drawString(continuing, (SCREEN_WIDTH - metrics3.stringWidth(continuing)) /2, SCREEN_HEIGHT - 100 );
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(start)
		{
			if(directionApproved(nextDirection))
			{
				direction = nextDirection;
				move();
			}

			checkApple();
			checkCollisions();
		}
		repaint();
	}
	public boolean directionApproved(char dir)
	{
		return (dir == 'U' && direction !='D') || (dir == 'D' && direction != 'U') || 
				(dir == 'L' && direction != 'R') || (dir == 'R' && direction != 'L');
	}
	
	public void restart()
	{
		timer.stop();
		body = 7;
		score = 0;
		direction = 'R';
		nextDirection = 'R';
		x[0] = 0;
		y[0] = 0;
		startGame();
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
					nextDirection = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction !='L')
				{
					nextDirection = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D')
				{
					nextDirection = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U')
				{
					nextDirection = 'D';
					
				}
				break;
			case KeyEvent.VK_SPACE:
			{
				if(start!=true)
				{					
					restart();
				}
				break;	
			}
			
			}
	}
	
	}
}
