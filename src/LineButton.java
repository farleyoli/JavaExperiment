import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LineButton extends JButton {
	StateManager stateManager;
	public LineButton(StateManager stateManager) {
		super("Line");
		addActionListener(new LineListener());
		this.stateManager = stateManager;
	}
	
	class LineListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new LineState(stateManager));
		}
	}
}

class LineState extends State {
	StateManager stateManager;
	
	public LineState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		if(stateManager.isSelected()) {
						
		} 
		else {
			MyLine myLine = new MyLine(x, y, 0, 0, Color.black, Color.white, 1);
			
			Vector<MyDrawing> vecD = new Vector<MyDrawing>(stateManager.getCanvas().getMediator().getDrawings());
			//select only one of the figures
			for(MyDrawing drawing : vecD) {
				drawing.setSelected(false);
			}
			
			stateManager.addDrawing(myLine);
			myLine.setSelected(true);
			stateManager.getCanvas().getMediator().setSelectedDrawing(myLine);
			
			stateManager.repaint();
			
		}
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
