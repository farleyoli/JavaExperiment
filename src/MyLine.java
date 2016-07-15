
import java.awt.*;

public class MyLine extends MyDrawing {
	public MyLine(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
		super.setW(2 * super.getH());
	}
	
	public MyLine(int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth) {
		super(x, y, w, h, lineColor, fillColor, lineWidth);
		setRegion();
	}
	
	public MyLine clone() {
		MyLine clone = new MyLine(getX(), getY(), getW(), getH(),
				getLineColor(), getFillColor(), getLineWidth());
		if(this.isShadowed())
			clone.setShadowed(true);
		if(this.isDashed())
			clone.setDashed(true);
		return clone;
	}
	
	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		Graphics2D g2 = (Graphics2D) g;
		if(getDashed()) 
			g2.setStroke(new MyDashStroke(getLineWidth()));
		else
			g2.setStroke(new BasicStroke(getLineWidth()));
		
		//kadai3
		if(isShadowed()) {
			//there's no such thing as shadowed for lines
		}
		
		g2.setColor(getFillColor());
		g2.setColor(getLineColor());
		g2.drawLine(x, y, x + w, y + h);
		super.draw(g);
	}
}
