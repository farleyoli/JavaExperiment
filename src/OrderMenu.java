import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

@SuppressWarnings("serial")
public class OrderMenu extends JMenuItem {
	StateManager stateManager;
	String menuName;
	public OrderMenu(StateManager stateManager, String menuName) {
		super(menuName);
		addActionListener(new IOListener());
		this.stateManager = stateManager;
		this.menuName = menuName;
	}
	
	class IOListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			Vector<MyDrawing> drawings = med.getDrawings();
			Vector<MyDrawing> selected = med.getSelectedDrawings();
			int size = drawings.size();
			if(size <= 1) return;
			if(menuName.equals("Move one position back")) {
				for(int i = 1; i <= size - 1; i++) {
					if(selected.contains(drawings.elementAt(i)) && !selected.contains(drawings.elementAt(i-1))) {
						Collections.swap(drawings, i, i-1);
					}
				}
				med.repaint();
			}
			else if(menuName.equals("Move to the background")){
				Vector<MyDrawing> drawingsC = new Vector<MyDrawing>(med.getDrawings());
				Collections.reverse(drawingsC);
				for(MyDrawing d : drawingsC) {
					if(selected.contains(d)) {
						drawings.remove(d);
						drawings.add(0, d);
					}
				}
				med.repaint();
			}
			else if(menuName.equals("Move one position to the front")) {
				for(int i = size - 1; i >= 1; i--) {
					if(!selected.contains(drawings.elementAt(i)) && selected.contains(drawings.elementAt(i-1))) {
						Collections.swap(drawings, i, i-1);
					}
				}
				med.repaint();
			}
			else {
				Vector<MyDrawing> drawingsC = new Vector<MyDrawing>(med.getDrawings());
				for(MyDrawing d : drawingsC) {
					if(selected.contains(d)) {
						drawings.remove(d);
						drawings.add(d);
					}
				}
				med.repaint();
			}
			med.repaint();
		}
	}
}