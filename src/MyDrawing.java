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
		//for changing the position of the object
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int w, int h) {
		//to change the size of the object
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		//to get the value of the x coordinate
		return this.x;
		
	}
	
	public int getY() {
		//to get the value of the y coordinate
		return this.y;
	}
	
	public int getW() {
		return this.w;
	}
	
	public int getH() {
		return this.h;
	}
	
	public Color getLineColor() {
		return this.lineColor;
	}
	
	public Color getFillColor() {
		return this.fillColor;
	}
	
	public int getLineWidth() {
		return this.lineWidth;
	}
}
