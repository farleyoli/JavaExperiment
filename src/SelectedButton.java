	import java.awt.event.*;

import javax.swing.*;

import java.util.*;

@SuppressWarnings("serial")
public class SelectedButton extends JButton {
	StateManager stateManager;
	public SelectedButton(StateManager stateManager) {
		super("Select/Move");
		addActionListener(new SelectedListener());
		this.stateManager = stateManager;
	}
	
	class SelectedListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new SelectedState(stateManager));
		}
	}
}

class SelectedState extends State {
	StateManager stateManager;
	
	public SelectedState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		Vector<MyDrawing> vecD = new Vector<MyDrawing>(stateManager.getCanvas().getMediator().getDrawings());
		Collections.reverse(vecD);
		
		//select only one of the figures
		for(MyDrawing drawing : vecD) {
			drawing.setSelected(false);
		}
		
		
		for(MyDrawing drawing : vecD) {
			if(drawing.contains(x, y)) {
				drawing.changeSelected();
				stateManager.getCanvas().getMediator().setSelectedDrawing(drawing);
				drawing.setX0(x);
				drawing.setY0(y);
				break;
			}
		}
		stateManager.repaint();
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {
		MyDrawing drawing = stateManager.getCanvas().getMediator().getSelectedDrawing();
		if(drawing.contains(x,y)) {
			int dx = x - drawing.getX0();
			int dy = y - drawing.getY0(); 
			drawing.setX0(x);
			drawing.setY0(y);
			drawing.move(dx, dy);
			stateManager.repaint();
		}
	}
}