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
			int numOfIter = 1;
			String input = null;
			input = JOptionPane.showInputDialog("Choose Number of Iterations (1~7)");
			if(input.matches("\\d+")) {
				//only accepting integers
				int num = Integer.parseInt(input);
				if(num >= 1 && num <= 7)
					numOfIter = num;
			}
			stateManager.setState(new KochState(stateManager, numOfIter));
		}
	}

}

class KochState extends State {
	StateManager stateManager;
	int numOfIter;
	
	public KochState(StateManager stateManager, int numOfIter) {
		this.stateManager = stateManager;
		this.numOfIter = numOfIter;
	}
	
	public void mouseDown(int x, int y) {
		Mediator med = stateManager.getCanvas().getMediator();
		MyKoch myKoch = new MyKoch(x, y, 0, 0, Color.black, Color.white, 1, numOfIter);
		Vector<MyDrawing> vecD = new Vector<MyDrawing>(med.getDrawings());
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