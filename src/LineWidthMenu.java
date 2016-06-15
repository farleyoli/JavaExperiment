import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LineWidthMenu extends JMenuItem {
	StateManager stateManager;
	int width;
	public LineWidthMenu(StateManager stateManager, String menuName, int width) {
		super(menuName);
		this.width = width;
		addActionListener(new LineWidthListener());
		this.stateManager = stateManager;
	}
	
	class LineWidthListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			med.setLineWidth(width);
		}
	}
}