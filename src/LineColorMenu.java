import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LineColorMenu extends JMenuItem {
	StateManager stateManager;
	Color color;
	public LineColorMenu(StateManager stateManager, String menuName, Color color) {
		super(menuName);
		this.color = color;
		addActionListener(new LineColorListener());
		this.stateManager = stateManager;
	}
	
	class LineColorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			med.setLineColor(color);
		}
	}
}