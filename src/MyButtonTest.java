import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MyButtonTest extends JFrame {
	public MyButtonTest() {
		super("MyButtonTest");
		
		//uses FlowLayout to create a panel that puts parts from the left
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		getContentPane().add(jp);
		
		Button rectButton = new Button("Rectangle");
		jp.add(rectButton);
		
		Button circleButton = new Button("Circle");
		jp.add(circleButton);
		
		Button triangleButton = new Button("Triangle");
		jp.add(triangleButton);
		
		setSize(300, 250);
	}
	
	public static void main(String args[]) {
		MyButtonTest myapp = new MyButtonTest();
		myapp.setVisible(true);
	}
}
