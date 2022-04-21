import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Super Class Window
 * 
 * @author Kevin
 *
 */
public class Window extends JFrame implements ActionListener {

	/**
	 * hangman game itself
	 */
	public void setWindowVisible(boolean visible) {
		setVisible(visible);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
