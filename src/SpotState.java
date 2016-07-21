import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;

public class SpotState extends State {
	StateManager stateManager;
	Mediator med;
	boolean isFillColor;
	
	public SpotState(StateManager stateManager, boolean isFillColor) {
		this.stateManager = stateManager;
		this.med = stateManager.getCanvas().getMediator();
		this.isFillColor = isFillColor;
	}
	
	public void mouseDown(int x, int y) {
		//get color of the pixel x, y;
		try {
			Robot robot = new Robot();
			Color color = robot.getPixelColor((int) MouseInfo.getPointerInfo().getLocation().getX(), (int) MouseInfo.getPointerInfo().getLocation().getY());
			if(isFillColor) { med.setColor(color); } else med.setLineColor(color);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {}
}
