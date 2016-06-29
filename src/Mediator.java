import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.awt.*;

public class Mediator {
	Vector<MyDrawing> drawings;
	MyCanvas canvas;
	Vector<MyDrawing> selectedDrawings = null; //vector to save the current selected drawings
	Vector<MyDrawing> buffer = null; // buffer for copying and cutting
	
	public Mediator(MyCanvas canvas) {
		this.canvas = canvas;
		drawings = new Vector<MyDrawing>();
		selectedDrawings = new Vector<MyDrawing>();
		buffer = new Vector<MyDrawing>();
	}
	
	public void clearBuffer() {
		buffer.clear();
	}
	
	public void clearSelectedDrawings() {
		for(MyDrawing d : selectedDrawings)
			d.setSelected(false);
		selectedDrawings.clear(); 
	}
	
	public void copy() {
		clearBuffer();
		for(MyDrawing d : selectedDrawings)
			buffer.addElement(d.clone());
	}
	
	public void cut() {
		clearBuffer();
		if(selectedDrawings.size() > 0) {
			int size = selectedDrawings.size();
			for(int i = size - 1; i >= 0; i--) {
				MyDrawing d = selectedDrawings.elementAt(i);
				buffer.addElement(d.clone());
				removeDrawing(d); // delete selectedDrawing from drawings
				selectedDrawings.remove(d);
			}
		}
	}
	
	public void paste(int x, int y) {
		if(buffer.size() > 0) {
			for(MyDrawing d : buffer) {
				MyDrawing clone = d.clone();
				clone.setLocation(x - (clone.getW()/2), y - (clone.getH()/2));
				addDrawing(clone);
				setSelectedDrawing(clone);
			}
		}
		repaint();
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
		clearSelectedDrawings();
		repaint();
	}
	
	public void removeDrawing() {
		if(selectedDrawings.size() > 0) {
			for(MyDrawing d : selectedDrawings) 
				drawings.remove(d);
			clearSelectedDrawings();
		}
		repaint();
	}
	
	public MyDrawing getSelectedDrawing() {
		//for the time being, this will return the first one in the list
		if(selectedDrawings.size() > 0)
			return selectedDrawings.firstElement();
		else return null;
	}
	
	public void move(int dx, int dy) {
		for(MyDrawing d : selectedDrawings) {
			d.move(dx, dy);
		}
	}
	
	public void repaint() {
		canvas.repaint();
	}
	
	public void setSelected(int x, int y) {
		for(MyDrawing d : selectedDrawings) {
			d.setX(x);
			d.setY(y);
		}
	}
	
	public void setSelectedDrawing(MyDrawing d) {
		clearSelectedDrawings();
		selectedDrawings.add(d);
		d.setSelected(true);
		repaint();
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
		for(MyDrawing d : selectedDrawings) {
			if(d != null && d.isSelected() != false) {
				d.setFillColor(color);
			}
		}
		repaint();
	}
	
	public void setLineColor(Color color) {
		for(MyDrawing d : selectedDrawings) {
			if(d != null && d.isSelected() != false) {
				d.setLineColor(color);
			}
		}
		repaint();
	}
	
	public void setLineWidth(int width) {
		for(MyDrawing d : selectedDrawings) {
			if(d != null && d.isSelected() != false) {
				d.setLineWidth(width);
			}
		}
		repaint();
	}
	
	public void setShadowed(boolean isShadowed) {
		for(MyDrawing d : selectedDrawings) {
			if(d != null && d.isSelected() != false) {
				d.setShadowed(isShadowed);
			}
		}
		repaint();
	}

}
