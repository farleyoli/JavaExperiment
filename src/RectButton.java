import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class RectButton extends JButton {
	StateManager stateManager;
	public RectButton(StateManager stateManager) {
		super("Rectangle");
		addActionListener(new RectListener());
		this.stateManager = stateManager;
	}
	
	class RectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new RectState(stateManager));
		}
	}

}

class RectState extends State {
	StateManager stateManager;
	
	public RectState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		//kadai2
		//MyRectangle myRectangle = new MyRectangle(x, y);
		MyRectangle myRectangle = new MyRectangle(x, y, 0, 0, Color.black, Color.white, 1);
		stateManager.addDrawing(myRectangle);
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
