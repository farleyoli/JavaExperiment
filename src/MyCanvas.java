import java.util.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyCanvas extends JPanel {
	private Mediator mediator;
	
	public MyCanvas() {
		this.mediator = new Mediator(this);
		setBackground(Color.white);
	}
	
	public void paint( Graphics g ) {
		super.paint(g);
		
		Enumeration<MyDrawing> e = mediator.drawingsElements();
		while(e.hasMoreElements()) {
			MyDrawing d = e.nextElement();
			d.draw(g);
		}
	}
	
	public Mediator getMediator() {
		return mediator;
	}
	
	public void addDrawing(MyDrawing d) {
		mediator.addDrawing(d);
	}
	
	public void removeDrawing(MyDrawing d) {
		mediator.removeDrawing(d);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
