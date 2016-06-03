import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ShadowedButton extends JButton {
	StateManager stateManager;
	public ShadowedButton(StateManager stateManager) {
		super("Change Shadow");
		addActionListener(new ShadowedListener());
		this.stateManager = stateManager;
	}
	
	class ShadowedListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setShadowed(!stateManager.isShadowed());
		}
	}

}
