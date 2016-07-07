import java.awt.*;
import java.io.*;

public class MyDrawing implements Cloneable, Serializable {
	private int x, y, w, h; //coordinates, width, height
	private int x0, y0;
	private Color lineColor, fillColor;
	private int lineWidth;
	
	private boolean isDashed = false;
	private boolean isShadowed = false;
	private boolean isSelected = false;
	private Shape region;
	final int SIZE = 7;
	
	public boolean isShadowed() {
		return isShadowed;
	}

	public void setShadowed(boolean isShadowed) {
		this.isShadowed = isShadowed;
	}

	public boolean isDashed() {
		return isDashed;
	}

	public MyDrawing() {
		x = y = 0;
		w = h = 0;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1;
		setRegion();
	}
	
	public MyDrawing(int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lineColor = lineColor;
		this.fillColor = fillColor;
		this.lineWidth = lineWidth;
		setRegion();
	}
	
	public MyDrawing clone() {
		MyDrawing clone = new MyDrawing(x, y, w, h, lineColor, fillColor, lineWidth);
		if(this.isShadowed())
			clone.setShadowed(true);
		if(this.isDashed())
			clone.setDashed(true);
		return clone;
	}
	
	public void draw(Graphics g) {
		//for drawing the object that represents whether the original object is selected or not
		if(isSelected) {
			g.setColor(Color.black);
			g.fillRect(x + w/2 - SIZE/2, y - SIZE/2, SIZE, SIZE);
			g.fillRect(x - SIZE/2, y + h/2 - SIZE/2, SIZE, SIZE);
			g.fillRect(x + w/2 - SIZE/2, y + h - SIZE/2, SIZE, SIZE);
			g.fillRect(x + w - SIZE/2, y + h/2 - SIZE/2, SIZE, SIZE);
			g.fillRect(x - SIZE/2, y - SIZE/2, SIZE, SIZE);
			g.fillRect(x + w - SIZE/2, y - SIZE/2, SIZE, SIZE);
			g.fillRect(x - SIZE/2, y + h - SIZE/2, SIZE, SIZE);
			g.fillRect(x + w - SIZE/2, y + h - SIZE/2, SIZE, SIZE);
		}
		setRegion();
	}
	
	public void move(int dx, int dy) {
		//for moving the object
		this.x += dx;
		this.y += dy;
		setRegion();
	}
	
	public boolean contains(int x, int y) {
		setRegion();
		return region.contains((double) x, (double) y);
	}
	
	public void setRegion() {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		//if the width or height is a negative number
		if(w < 0) {
			x += w;
			w *= -1;
		}
		
		if(h < 0) {
			y += h;
			h *= -1;
		}
		this.region = new Rectangle(x, y, w, h);
	}
	
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		setRegion();
	}
	
	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
		setRegion();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		setRegion();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		setRegion();
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
		setRegion();
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
		setRegion();
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public boolean getDashed() {
		return isDashed;
	}

	public void setDashed(boolean isDashed) {
		this.isDashed = isDashed;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
		setRegion();
	}
	
	public void changeSelected() {
		this.isSelected = !this.isSelected;
		setRegion();
	}

	public Shape getRegion() {
		return region;
	}

	public void setRegion(Shape region) {
		this.region = region;
	}

	public int getSIZE() {
		return SIZE;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}
	
}