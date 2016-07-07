import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

@SuppressWarnings("serial")
public class IOMenu extends JMenuItem {
	StateManager stateManager;
	String menuName;
	public IOMenu(StateManager stateManager, String menuName) {
		super(menuName);
		addActionListener(new IOListener());
		this.stateManager = stateManager;
		this.menuName = menuName;
	}
	
	class IOListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getCanvas().getMediator();
			if(menuName.equals("Read File")) {
				// I feel like using a string to control the flow here is bad style,
				// but I don't have enough time to do things the right way.
				try {
					FileInputStream fin = new FileInputStream("file.txt");
					ObjectInputStream in = new ObjectInputStream(fin);
					
					med.setDrawings((Vector<MyDrawing>) in.readObject() );
					fin.close();
					
				} catch(Exception ex) {
				}	
			}
			else { // load File
				try {
					FileOutputStream fout = new FileOutputStream("file.txt");
					ObjectOutputStream out = new ObjectOutputStream(fout);

					out.writeObject(med.getDrawings());
					out.flush();
					fout.close();
				} catch(Exception ex) {
				}
			}
			med.repaint();
		}
	}
}
