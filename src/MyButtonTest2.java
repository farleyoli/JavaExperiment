import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyButtonTest2 extends JFrame{
	public MyButtonTest2() {
		super("MyButtonTest");
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		getContentPane().add(jp);
		
		Button rectButton = new Button("Rectangle");
		rectButton.addActionListener(new RectButtonListener());
		jp.add(rectButton);
		
		Button circleButton = new Button("Circle");
		circleButton.addActionListener(new CircleButtonListener());
		jp.add(circleButton);
		
		Button triangleButton = new Button("Triangle");
		triangleButton.addActionListener(new TriangleButtonListener());
		jp.add(triangleButton);
		
		setSize(300, 250);
	}
	
	public static void main(String[] args) {
		MyButtonTest2 myapp = new MyButtonTest2();
		myapp.setVisible(true);
	}
}

//event listener of Rect buttons
class RectButtonListener implements ActionListener {
	//what happens when some Rect button is pressed
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Rect is pressed.");
	}
}

//event listener of Circle buttons
class CircleButtonListener implements ActionListener {
	//what happens when some Circle button is pressed
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Circle is pressed.");
	}
}


//event listener of Triangle buttons 
class TriangleButtonListener implements ActionListener {
	//what happens when some Triangle button is pressed 
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Triangle is pressed.");
	}
}