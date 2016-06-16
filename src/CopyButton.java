import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CopyButton extends JButton {
	StateManager stateManager;
	public CopyButton(StateManager stateManager) {
		super("Copy");
		
		addActionListener(new CopyListener());
		
		this.stateManager = stateManager;
	}
	
	class CopyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			med.copy();
		}
	}

}

