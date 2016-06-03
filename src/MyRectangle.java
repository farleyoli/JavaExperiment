import java.awt.*;

public class MyRectangle extends MyDrawing {
	public MyRectangle(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
	}
	
	public MyRectangle(int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth) {
		super(x, y, w, h, lineColor, fillColor, lineWidth);
		setRegion();
	}
	
	public void draw(Graphics g) {
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
		
		Graphics2D g2 = (Graphics2D) g;
		
		if(getDashed()) 
			g2.setStroke(new MyDashStroke(getLineWidth()));
		else
			g2.setStroke(new BasicStroke(getLineWidth()));
		
		if(isShadowed()) {
			g2.setColor(Color.black);
			g2.fillRect(x + 10, y + 10, w, h);
			g2.drawRect(x + 10, y + 10, w, h);
			
		}
		
		g2.setColor(getFillColor());
		g2.fillRect(x, y, w, h);
		g2.setColor(getLineColor());
		g2.drawRect(x, y, w, h);
		
		super.draw(g);
	}
}