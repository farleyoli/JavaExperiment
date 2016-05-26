import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class StarButton extends JButton {
	StateManager stateManager;
	public StarButton(StateManager stateManager) {
		super("Star");
		
		addActionListener(new StarListener());
		
		this.stateManager = stateManager;
	}
	
	class StarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new StarState(stateManager));
		}
	}

}

class StarState extends State {
	StateManager stateManager;
	
	public StarState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		stateManager.addDrawing(new MyStar(x, y));
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {
		//kadai2
		int x0 = stateManager.getMyDrawing().getX();
		int y0 = stateManager.getMyDrawing().getY();
		int w = x - x0, h = y - y0;
		stateManager.getMyDrawing().setW(w);
		stateManager.getMyDrawing().setH(h);	
		stateManager.repaint();
	}
}
