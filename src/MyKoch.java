import java.awt.*;

public class MyKoch extends MyDrawing {
	
	public int numOfIter;
	public int[] xPoints;
	public int[] yPoints;
	public double[] xPointsD;
	public double[] yPointsD;
	
	public MyKoch(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
	}
	
	public MyKoch(int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth) {
		super(x, y, w, h, lineColor, fillColor, lineWidth);
		//if(numOfIter > 0) setH((int) (getH() - getH()*Math.sqrt(5)/6) * 0);
		numOfIter = 7;
		setPoints(numOfIter);
		setRegion();
	}
	
	public MyKoch(int x, int y, int w, int h, Color lineColor, Color fillColor, int lineWidth, int numOfIter) {
		super(x, y, w, h, lineColor, fillColor, lineWidth);
		//if(numOfIter > 0) setH((int) (getH() - getH()*Math.sqrt(5)/6) * 0);
		this.numOfIter = numOfIter;
		setPoints(numOfIter);
		setRegion();
	}
	
	public static int power(int a, int b) {
		if(b == 0) return 1;
		int power = 1;
		for(int c = 0; c < b; c++)
			power *= a;
		return power;
    }
	
	public void setPoints(int numOfIter) {
		//process the points in a clockwise fashion
		//beginning from the most south-western one
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		h = ((int) (getH() - w*0.29));
		int numOfSides = 3 * power(4, numOfIter);
	
		
		if(numOfIter == 0) {
			xPointsD = new double[numOfSides];
			yPointsD = new double[numOfSides];
			
			xPointsD[2] = x;
			yPointsD[2] = y + h;
			
			xPointsD[1] = (double) x + ((double) w)/2;
			yPointsD[1] = y;
			
			xPointsD[0] = x + w;
			yPointsD[0] = y + h;
		} else {
			setPoints(numOfIter - 1);
			int numOfSidesBefore = xPoints.length;
			double[] xPointsDB = xPointsD;
			double[] yPointsDB = yPointsD;
			xPointsD = new double[numOfSides];
			yPointsD = new double[numOfSides];
			
			for(int i = 0; i < numOfSidesBefore; i++) {
				xPointsD[4*i] = xPointsDB[i];
				yPointsD[4*i] = yPointsDB[i];
				
				double nextXPointsDB;
				double nextYPointsDB;
				if(i < numOfSidesBefore - 1) {
					nextXPointsDB = xPointsDB[i+1];
					nextYPointsDB = yPointsDB[i+1];
				} else {
					nextXPointsDB = xPointsDB[0];
					nextYPointsDB = yPointsDB[0];
				}
				
				//4i + 1 --> U = (2A+B)/3
				xPointsD[4*i + 1] = (2 * xPointsDB[i] + nextXPointsDB)/3;
				yPointsD[4*i + 1] = (2 * yPointsDB[i] + nextYPointsDB)/3;
				
				//4i + 2 --> this one is complicated --> V = U + (AB/3)*(cos(ang(AB) + pi.3), sin(ang(AB) + pi/3))
				double angAB = Math.atan2(nextYPointsDB-yPointsDB[i], nextXPointsDB-xPointsDB[i]);
				xPointsD[4*i + 2] = xPointsD[4*i + 1] + 
						(Math.sqrt((nextXPointsDB - xPointsDB[i])*(nextXPointsDB - xPointsDB[i]) +
								(nextYPointsDB - yPointsDB[i])*(nextYPointsDB - yPointsDB[i]))/3.0) *
						Math.cos(angAB + Math.PI/3.0); 
				
				yPointsD[4*i + 2] = yPointsD[4*i + 1] + 
						(Math.sqrt((nextXPointsDB - xPointsDB[i])*(nextXPointsDB - xPointsDB[i]) +
								(nextYPointsDB - yPointsDB[i])*(nextYPointsDB - yPointsDB[i]))/3.0) *
						Math.sin(angAB + Math.PI/3.0);
				
				//4i + 3 --> W = (A + 2B)/3
				xPointsD[4*i + 3] = (xPointsDB[i] + 2 * nextXPointsDB)/3;
				yPointsD[4*i + 3] = (yPointsDB[i] + 2 * nextYPointsDB)/3;
				
			}
			
			
		}
		
		
		xPoints = new int[numOfSides];
		yPoints = new int[numOfSides];
		for(int i = 0; i < numOfSides; i++) {
			xPoints[i] = (int) xPointsD[i];
			yPoints[i] = (int) yPointsD[i];
		}
		
	}
	
	public MyKoch clone() {
		MyKoch clone = new MyKoch(getX(), getY(), getW(), getH(),
				getLineColor(), getFillColor(), getLineWidth());
		if(this.isShadowed())
			clone.setShadowed(true);
		if(this.isDashed())
			clone.setDashed(true);
		return clone;
	}
	
	public void draw(Graphics g) {
		setPoints(numOfIter);
		Graphics2D g2 = (Graphics2D) g;
		if(getDashed()) 
			g2.setStroke(new MyDashStroke(getLineWidth()));
		else
			g2.setStroke(new BasicStroke(getLineWidth()));
		
		if(isShadowed()) {
			int[] xPoints2 = new int[xPoints.length], yPoints2 = new int[yPoints.length];
			for(int i = 0; i < xPoints.length; i++)
				xPoints2[i] = xPoints[i] + 10;
			for(int i = 0; i < yPoints.length; i++)
				yPoints2[i] = yPoints[i] + 10;
			g2.setColor(Color.black);
			g2.fillPolygon(xPoints2, yPoints2, xPoints2.length);
			g2.drawPolygon(xPoints2, yPoints2, xPoints2.length);
		}
		
		g2.setColor(getFillColor());
		g2.fillPolygon(xPoints, yPoints, xPoints.length);
		g2.setColor(getLineColor());
		g2.drawPolygon(xPoints, yPoints, xPoints.length);
		super.draw(g);
	}
}