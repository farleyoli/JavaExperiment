import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class OvalButton extends JButton {
	StateManager stateManager;
	public OvalButton(StateManager stateManager) {
		super("Oval");
		
		addActionListener(new OvalListener());
		
		this.stateManager = stateManager;
	}
	
	class OvalListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new OvalState(stateManager));
		}
	}

}

class OvalState extends State {
	StateManager stateManager;
	
	public OvalState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		stateManager.addDrawing(new MyOval(x, y));
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
