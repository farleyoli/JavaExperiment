public class StateManager {
	private State state;
	private MyCanvas canvas;
	MyDrawing myDrawing;
	private boolean isDashed;
	private boolean isShadowed;
	private boolean isSelected;
	

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
	}

	public void addDrawing(MyDrawing myDrawing) {
		this.myDrawing = myDrawing; 
		if(isDashed())
			myDrawing.setDashed(true);
		else myDrawing.setDashed(false);
		if(isShadowed())
			myDrawing.setShadowed(true);
		else myDrawing.setShadowed(false);
		if(isSelected())
			myDrawing.setSelected(true);
		else myDrawing.setSelected(false);
		canvas.addDrawing(myDrawing);
		canvas.repaint();
	}

	public boolean isShadowed() {
		return isShadowed;
	}

	public void setShadowed(boolean isShadowed) {
		this.isShadowed = isShadowed;
	}
	
	public void repaint() {
		canvas.repaint();
	}

	public MyCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(MyCanvas canvas) {
		this.canvas = canvas;
	}

	public MyDrawing getMyDrawing() {
		return myDrawing;
	}

	public void setMyDrawing(MyDrawing myDrawing) {
		this.myDrawing = myDrawing;
	}

	public boolean isDashed() {
		return isDashed;
	}

	public void setDashed(boolean isDashed) {
		this.isDashed = isDashed;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void mouseDown(int x, int y) {
		if(state != null)
			state.mouseDown(x, y);
	}
	
	public void mouseDragged(int x, int y) {
		if(state != null)
			state.mouseDrag(x, y);
	}
	
	public void mouseUp(int x, int y) {
		if(state != null)
			state.mouseUp(x, y);
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
