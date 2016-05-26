import java.awt.*;

public class MyDrawing {
	private int x, y, w, h; //coordinates, width, height
	private Color lineColor, fillColor;
	private int lineWidth;
	
	public MyDrawing() {
		x = y = 0;
		w = 200;
		h = 200;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1;
	}
	
	public MyDrawing(int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lineColor = lineColor;
		this.fillColor = fillColor;
		this.lineWidth = lineWidth;
	}
	
	public void draw(Graphics g) {
		//for drawing the object
	}
	
	public void move(int dx, int dy) {
		//for moving the object
		this.x += dx;
		this.y += dy;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
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
	
}
