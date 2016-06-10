import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyApp extends JFrame {
	StateManager stateManager;
	MyCanvas canvas;
	
	public MyApp() {
		super("My App!");
		
		canvas = new MyCanvas();
		canvas.setBackground(Color.white);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		stateManager = new StateManager(canvas);
		
		RectButton rectButton = new RectButton(stateManager);
		jp.add(rectButton);
		OvalButton ovalButton = new OvalButton(stateManager);
		jp.add(ovalButton);
		StarButton starButton = new StarButton(stateManager);
		jp.add(starButton);
//		StringButton stringButton = new StringButton(stateManager);
//		jp.add(stringButton);
		ShadowedButton shadowedButton = new ShadowedButton(stateManager);
		jp.add(shadowedButton);
		SelectedButton selectedButton = new SelectedButton(stateManager);
		jp.add(selectedButton);
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jp, BorderLayout.NORTH);
		getContentPane().add(canvas, BorderLayout.CENTER);
		
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				stateManager.mouseDown(e.getX(), e.getY());
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				stateManager.mouseDragged(e.getX(), e.getY());
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		
	}
	
	public static void main(String[] args) {
		MyApp app = new MyApp();
		app.pack();
		app.setSize(1000, 1000);
		app.setVisible(true);
	}
}