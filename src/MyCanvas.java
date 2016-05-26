import java.util.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyCanvas extends JPanel {
	private Vector<MyDrawing> drawings;
	
	public MyCanvas() {
		setBackground(Color.white);
		
		drawings = new Vector<MyDrawing>();
	}
	
	public void paint( Graphics g ) {
		super.paint(g);
		for(MyDrawing d : drawings) {
			d.draw(g);
		}
	}
	
	public void addDrawing(MyDrawing d) {
		drawings.add(d);
	}
	
	public void removeDrawing(MyDrawing d) {
		drawings.remove(d);
	}
}
