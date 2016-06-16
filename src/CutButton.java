import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CutButton extends JButton {
	StateManager stateManager;
	public CutButton(StateManager stateManager) {
		super("Cut");
		
		addActionListener(new CutListener());
		
		this.stateManager = stateManager;
	}
	
	class CutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			med.cut();
		}
	}

}
