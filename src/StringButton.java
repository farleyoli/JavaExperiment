import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class StringButton extends JButton {
	StateManager stateManager;
	public StringButton(StateManager stateManager) {
		super("String");
		
		addActionListener(new StringListener());
		
		this.stateManager = stateManager;
	}
	
	class StringListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new StringState(stateManager));
		}
	}

}

class StringState extends State {
	StateManager stateManager;
	
	public StringState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		stateManager.addDrawing(new MyString("Test", x, y));
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {}
}
