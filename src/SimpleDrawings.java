//package task01;
//import java.awt.*;
//import javax.swing.*;
//
//public class SimpleDrawings extends JFrame {
//	public SimpleDrawings() {
//		super("My Painter");
//		
//		JPanel jp = new JPanel(new BorderLayout());
//		getContentPane().add(jp);
//		
//		MyCanvas canvas = new MyCanvas();
//		jp.add(BorderLayout.CENTER, canvas);
//		
//		setSize(new Dimension(360,380));
//		setVisible(true);
//	}
//	
//	public static void main(String[] argv){
//		new SimpleDrawings();
//	}
//}
//
//class MyCanvas extends JPanel{
//	MyCanvas(){
//		setBackground(Color.white);
//	}
//	
//	public void paint(Graphics g){
//		super.paint(g);
//		
//		g.setColor(Color.black);
//		g.drawLine(20, 20, 100, 80);
//		g.setColor(Color.green);
//		g.drawRect(20, 100, 80, 60);
//		g.setColor(Color.red);
//		g.drawRoundRect(20, 180, 80, 60, 10, 10);
//		g.setColor(Color.orange);
//		g.drawOval(159, 20, 80, 60);
//		g.setColor(Color.blue);
//		g.drawString("Hello World!!", 150, 150);
//		
//		g.setColor(Color.pink);
//		g.fillArc(150, 180, 80, 60, -155, 310);
//		g.setColor(Color.cyan);
//		g.fillRect(260, 20, 80, 60);
//		g.setColor(Color.yellow);
//		g.fillRoundRect(260, 100, 80, 60, 10, 10);
//		g.setColor(Color.gray);
//		g.fillOval(260, 180, 80, 60);
//	}
//}
