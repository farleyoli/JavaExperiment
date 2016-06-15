import java.awt.*;
import java.util.*;
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
		MyStar myStar = new MyStar(x, y, 0, 0, Color.black, Color.white, 1);
		Vector<MyDrawing> vecD = new Vector<MyDrawing>(stateManager.getCanvas().getMediator().getDrawings());
		//select only one of the figures
		for(MyDrawing drawing : vecD) {
			drawing.setSelected(false);
		}
		stateManager.addDrawing(myStar);
		myStar.setSelected(true);
		stateManager.getCanvas().getMediator().setSelectedDrawing(myStar);
			
		stateManager.repaint();
		
		
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {
		int x0 = stateManager.getMyDrawing().getX();
		int y0 = stateManager.getMyDrawing().getY();
		int w = x - x0, h = y - y0;
		stateManager.getMyDrawing().setW(w);
		stateManager.getMyDrawing().setH(h);	
		stateManager.repaint();
	}
}
