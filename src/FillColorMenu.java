import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FillColorMenu extends JMenuItem {
	StateManager stateManager;
	Color color;
	public FillColorMenu(StateManager stateManager, String menuName, Color color) {
		super(menuName);
		this.color = color;
		addActionListener(new FillColorListener());
		this.stateManager = stateManager;
	}
	
	class FillColorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			med.setColor(color);
		}
	}
}

