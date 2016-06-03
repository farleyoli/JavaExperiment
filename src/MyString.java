import java.awt.*;

public class MyString extends MyDrawing {
		private String str;
		public MyString(String str, int xpt, int ypt) {
			super();
			setLocation(xpt, ypt);
			this.str = str;
		}
		
		public MyString(String str, int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth) {
			super(x, y, w, h, lineColor, fillColor, lineWidth);
			this.str = str;
		}
		
		public void draw(Graphics g) {
			int x = getX();
			int y = getY();
			int w = getW();
			int h = getH();
			
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
			g2.setColor(getLineColor());
			g2.drawString(str, x, y);
			super.draw(g);
		}
		

}
