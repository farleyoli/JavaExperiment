import java.awt.*;

public class MyOval extends MyDrawing {
	public MyOval(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
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
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillOval(x, y, w, h);
		g2.setColor(getLineColor());
		g2.drawOval(x, y, w, h);
	}
}