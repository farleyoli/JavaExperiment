import java.awt.event.*;

import javax.swing.*;

import java.util.*;

@SuppressWarnings("serial")
public class SelectedButton extends JButton {
	StateManager stateManager;
	public SelectedButton(StateManager stateManager) {
		super("Select");
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
		for(MyDrawing drawing : vecD) {
			if(drawing.contains(x, y)) {
				drawing.changeSelected();
				break;
			}
		}
		stateManager.repaint();
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {
	}
}