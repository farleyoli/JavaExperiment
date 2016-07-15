import java.awt.Color;
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
	Mediator med;
	MyDrawing rect;
	int flag;
	
	public SelectedState(StateManager stateManager) {
		this.stateManager = stateManager;
		this.med = stateManager.getCanvas().getMediator();
		flag = 0; //I can use enumarations here later
		// 0: nothing, 1: there are figures, 2: there aren't any figures in (x,y)
	}
	
	public void mouseDown(int x, int y) {
		Vector<MyDrawing> drawings = med.getDrawings();
		Vector<MyDrawing> sDrawings = med.getSelectedDrawings();
		Vector<MyDrawing> vecD = new Vector<MyDrawing>(med.getDrawings()); //copy of drawings, in order to reverse the list
		Collections.reverse(vecD);
		
		//if there are no figures in (x,y), unselect everything
		boolean isThereFig = false;
		for(MyDrawing drawing : vecD) {
			if(drawing.contains(x,y)) {
				isThereFig = true;
				break;
			}
		}
		if(!isThereFig) med.unselectAll();
		
		flag = 2;
		for(MyDrawing drawing : vecD) {
			if(drawing.contains(x, y)) {
				if(drawing.isSelected()) {
					sDrawings.remove(drawing);
					sDrawings.add(drawing);
				}
				else {
					med.unselectAll();
					med.setSelected(drawing);
				}
				drawing.setX0(x);
				drawing.setY0(y);
				flag = 1;
				break;
			}
		}
		
		if(flag == 2) { // there were no figures in (x,y)
			rect = new MyRectangle(x, y, 0, 0, Color.PINK, new Color(255, 255, 255, 0), 2);
			rect.setDashed(true);
			drawings.add(rect); // add the vector to the FRONT of the vector
			//so this rectangle is not over any figure
		}
		stateManager.repaint();
	}
	
	public void mouseUp(int x, int y){
		Vector<MyDrawing> drawings = med.getDrawings();
		if(rect != null && !drawings.isEmpty()) {
			if(rect.getW() < 0) {
				rect.setX(rect.getX() + rect.getW());
				rect.setW(-rect.getW());
			}
			if(rect.getH() < 0) {
				rect.setY(rect.getY() + rect.getH());
				rect.setH(-rect.getH());
			}
			for(MyDrawing d : drawings) {
				boolean xIntersection, yIntersection; // the intersection is not empty (true or false)
				xIntersection = !(rect.getX() + rect.getW() < d.getX() || d.getX() + d.getW() < rect.getX());
				yIntersection = !(rect.getY() + rect.getH() < d.getY() || d.getY() + d.getY() < rect.getY());
				
				if(xIntersection && yIntersection) {
					med.setSelected(d);
				}
			
			}
			flag = 1;
			med.removeDrawing(rect);
			rect = null;
		}
		
	}
	
	
	public void mouseDrag(int x, int y) {
		if(flag == 2) { // select multiple figures
			int x0 = rect.getX();
			int y0 = rect.getY();
			int w = x - x0, h = y - y0;
			rect.setW(w);
			rect.setH(h);	
			med.repaint();
			return;
		}
		else {
			MyDrawing drawing = med.getSelectedDrawing();
			if(med.getSelectedDrawing() == null) // no figures selected
				return;
			Vector<MyDrawing> sDrawings = med.getSelectedDrawings();
			int dx = 0, dy = 0;
			//for(MyDrawing d : sDrawings) {
			//	if(d == drawing) { //will fix this later, so the click has to be in some selected figure
			//		dx = x - drawing.getX0();
			//		dy = y - drawing.getY0(); 
			//		drawing.setX0(x);
			//		drawing.setY0(y);
			//	}
			//	d.move(dx, dy);
			//	stateManager.repaint();
			dx = x - drawing.getX0(); 
			dy = y - drawing.getY0();
			drawing.setX0(x);
			drawing.setY0(y);
			med.move(dx, dy);
			med.repaint();
		}
	}
}