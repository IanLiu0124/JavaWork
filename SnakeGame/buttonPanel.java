import java.awt.event.*;
import java.awt.Shape.*;
import java.awt.*;
import javax.swing.*;

public class buttonPanel extends JPanel implements ActionListener{
	gamePanel game = new gamePanel();
	JButton reset = new JButton("Restart");
	JButton pause = new JButton("Pause");
	
	public buttonPanel(gamePanel game)
	{
		this.setLayout(null);
		this.setBackground(Color.black);
		this.game = game;
		reset.addActionListener(this);
		pause.addActionListener(this);
		this.setPreferredSize(new Dimension(600, 100));
		reset.setBounds(100, 55, 80, 40);
		pause.setBounds(400, 55, 80, 40);
//		reset.setBorder(new RoundedBorder(10));
		this.add(pause);
		this.add(reset);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g)
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getSource());
		if(e.getSource() == reset)	
		{
//			System.out.println("test");
			game.restart();
		}
		if(e.getSource() == pause)
		{
//			System.out.println("tw");
			if(pause.getText() == "Pause")
			{
//				System.out.println("test");
				game.timer.stop();
				pause.setText("Contine");
			}
			else
			{
				game.timer.start();
				pause.setText("Pause");
			}
		}
		
		
	}

}
