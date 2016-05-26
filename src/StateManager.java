public class StateManager {
	private State state;
	private MyCanvas canvas;
	MyDrawing myDrawing;
	private boolean isDashed;
	//kadai3
	private boolean isShadowed;
	

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
	}

	public void addDrawing(MyDrawing myDrawing) {
		this.myDrawing = myDrawing; 
		if(isDashed())
			myDrawing.setDashed(true);
		else myDrawing.setDashed(false);
		//kadai3
		if(isShadowed())
			myDrawing.setShadowed(true);
		else myDrawing.setShadowed(false);
		canvas.addDrawing(myDrawing);
		canvas.repaint();
	}

	public boolean isShadowed() {
		return isShadowed;
	}

	public void setShadowed(boolean isShadowed) {
		this.isShadowed = isShadowed;
	}

	//kadai2
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
		state.mouseDown(x, y);
	}
	
	//kadai2
	public void mouseDragged(int x, int y) {
		state.mouseDrag(x, y);
	}
	//KADAI2
}
