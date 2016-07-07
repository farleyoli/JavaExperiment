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
			if(menuName.equals("Load File")) {
				// I feel like using a string to control the flow here is bad style,
				// but I don't have enough time to do things the right way.
				JFileChooser fc = new JFileChooser();
				
				int returnVal = fc.showOpenDialog(null);  

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						FileInputStream fin = new FileInputStream(file);
						ObjectInputStream in = new ObjectInputStream(fin);
					
						med.setDrawings((Vector<MyDrawing>) in.readObject() );
						fin.close();
					
					} catch(Exception ex) {
						
					}
				}
			}
			else { // read File
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(null);  // ファイルロード用のダイアログを開く

				if (returnVal == JFileChooser.APPROVE_OPTION) {  // OKボタンが押されたとき
				    File file = fc.getSelectedFile();
				    try {
						FileOutputStream fout = new FileOutputStream(file);
						ObjectOutputStream out = new ObjectOutputStream(fout);

						out.writeObject(med.getDrawings());
						out.flush();
						fout.close();
					} catch(Exception ex) {
					}
				}
			}
			med.repaint();
		}
	}
}
