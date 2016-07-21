import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class KochButton extends JButton {
	StateManager stateManager;
	public KochButton(StateManager stateManager) {
		super("Koch Snowflake");
		
		addActionListener(new KochListener());
		
		this.stateManager = stateManager;
	}
	
	class KochListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new KochState(stateManager));
		}
	}

}

class KochState extends State {
	StateManager stateManager;
	
	public KochState(StateManager stateManager) {
		this.stateManager = stateManager;
	}
	
	public void mouseDown(int x, int y) {
		MyKoch myKoch = new MyKoch(x, y, 0, 0, Color.black, Color.white, 1);
		Vector<MyDrawing> vecD = new Vector<MyDrawing>(stateManager.getCanvas().getMediator().getDrawings());
		//select only one of the figures
		for(MyDrawing drawing : vecD) {
			drawing.setSelected(false);
		}
		stateManager.addDrawing(myKoch);
		myKoch.setSelected(true);
		stateManager.getCanvas().getMediator().setSelectedDrawing(myKoch);
			
		stateManager.repaint();
		
		
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {
		int x0 = stateManager.getMyDrawing().getX();
		int y0 = stateManager.getMyDrawing().getY();
		int w = x - x0, h = y - y0;
		stateManager.getMyDrawing().setW(w);
		stateManager.getMyDrawing().setH(w);	
		stateManager.repaint();
	}
}