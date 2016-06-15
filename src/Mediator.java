import java.util.Enumeration;
import java.util.Vector;
import java.awt.*;

public class Mediator {
	Vector<MyDrawing> drawings;
	MyCanvas canvas;
	MyDrawing selectedDrawing = null;
	
	public Mediator(MyCanvas canvas) {
		this.canvas = canvas;
		drawings = new Vector<MyDrawing>();
	}
	
	public Enumeration<MyDrawing> drawingsElements() {
		return drawings.elements();
	}
	
	public void addDrawing(MyDrawing d) {
		drawings.add(d);
		setSelectedDrawing(d);
	}
	
	public void removeDrawing(MyDrawing d) {
		drawings.remove(d);
		selectedDrawing = null;
		repaint();
	}
	
	public void removeDrawing() {
		if(selectedDrawing != null) {
			drawings.remove(selectedDrawing);
			selectedDrawing = null;
		}
		repaint();
	}
	
	public MyDrawing getSelectedDrawing() {
		return selectedDrawing;
	}
	
	public void move(int dx, int dy) {
		if (selectedDrawing != null)
			selectedDrawing.move(dx, dy);
	}
	
	public void repaint() {
		canvas.repaint();
	}
	
	public void setSelected(int x, int y) {
		selectedDrawing.setX(x);
		selectedDrawing.setY(y);
	}
	
	public void setSelectedDrawing(MyDrawing d) {
		selectedDrawing = d;
	}

	public Vector<MyDrawing> getDrawings() {
		return drawings;
	}

	public void setDrawings(Vector<MyDrawing> drawings) {
		this.drawings = drawings;
	}

	public MyCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(MyCanvas canvas) {
		this.canvas = canvas;
	}
	
	public void setColor(Color color) {
		if(selectedDrawing != null && selectedDrawing.isSelected() != false) {
			selectedDrawing.setFillColor(color);
		}
		repaint();
	}
	
	public void setLineColor(Color color) {
		if(selectedDrawing != null && selectedDrawing.isSelected() != false) {
			selectedDrawing.setLineColor(color);
		}
		repaint();
	}
	
	public void setLineWidth(int width) {
		if(selectedDrawing != null && selectedDrawing.isSelected() != false) {
			selectedDrawing.setLineWidth(width);
		}
		repaint();
	}
	
	public void setShadowed(boolean isShadowed) {
		if(selectedDrawing != null && selectedDrawing.isSelected() != false) {
			selectedDrawing.setShadowed(isShadowed);
		}
		repaint();
	}
	

}
