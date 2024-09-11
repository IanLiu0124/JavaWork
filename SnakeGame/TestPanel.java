import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;

public class TestPanel extends JPanel {
    public TestPanel() {
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.requestFocusInWindow(); // Ensure focus
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key Pressed: " + e.getKeyCode());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        TestPanel panel = new TestPanel();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}