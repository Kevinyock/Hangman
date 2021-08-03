import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Window extends JPanel{

	private JFrame Difficulty = new JFrame("Difficulty");
	
	public Window()
	{
		System.out.println("Hello");
		//
		Difficulty.setTitle("Difficulty");
		Difficulty.setBounds(50,50,500,70);
		Difficulty.setResizable(true);
		Difficulty.setLocationRelativeTo(this);
		Difficulty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Difficulty.setContentPane(new DifficultyPanel());
		Difficulty.setVisible(true);
		//
		
	}
	
	public class DifficultyPanel extends JPanel implements ActionListener,KeyListener
	{
		public DifficultyPanel()
		{	
			setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
