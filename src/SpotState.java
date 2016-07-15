import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;

public class SpotState extends State {
	StateManager stateManager;
	Mediator med;
	boolean isFill;
	
	public SpotState(StateManager stateManager, boolean isFill) {
		this.stateManager = stateManager;
		this.med = stateManager.getCanvas().getMediator();
		this.isFill = isFill;
	}
	
	public void mouseDown(int x, int y) {
		//get color of the pixel x, y;
		System.out.println("test");
		try {
			Robot robot = new Robot();
			Color color = robot.getPixelColor((int) MouseInfo.getPointerInfo().getLocation().getX(), (int) MouseInfo.getPointerInfo().getLocation().getY());
			if(isFill) { med.setColor(color); } else med.setLineColor(color);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void mouseUp(int x, int y){}
	public void mouseDrag(int x, int y) {}
}
