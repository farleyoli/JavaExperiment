import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyApp extends JFrame implements ActionListener {
	StateManager stateManager;
	MyCanvas canvas;
	Mediator med;
	
	private JMenuBar menuBar;
	private JMenu colorMenu;
	private JMenuItem redItem, blueItem, greenItem, whiteItem, blackItem, yellowItem, otherItem;
	
	public MyApp() {
		super("My App!");
		
		canvas = new MyCanvas();
		canvas.setBackground(Color.white);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		stateManager = new StateManager(canvas);
		med = canvas.getMediator();
		
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
		
		
		//this is not the best way, but done is better than perfect
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		colorMenu = new JMenu("Color");
		redItem = new JMenuItem("Red");
		blueItem = new JMenuItem("Blue");
		greenItem = new JMenuItem("Green");
		whiteItem = new JMenuItem("White");
		blackItem = new JMenuItem("Black");
		yellowItem = new JMenuItem("Yellow");
		otherItem = new JMenuItem("Other Colors");
		colorMenu.add(redItem);
		colorMenu.add(blueItem);
		colorMenu.add(greenItem);
		colorMenu.add(whiteItem);
		colorMenu.add(blackItem);
		colorMenu.add(yellowItem);
		colorMenu.add(otherItem);
		redItem.addActionListener(this);
		blueItem.addActionListener(this);
		greenItem.addActionListener(this);
		whiteItem.addActionListener(this);
		blackItem.addActionListener(this);
		yellowItem.addActionListener(this);
		otherItem.addActionListener(this);
		menuBar.add(colorMenu);
		
		
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == redItem) {
			med.setColor(Color.red);
		}
		else if(e.getSource() == blueItem) {
			med.setColor(Color.blue);
		}
		else if(e.getSource() == greenItem) {
			med.setColor(Color.green);
		}
		else if(e.getSource() == whiteItem) {
			med.setColor(Color.white);
		}
		else if(e.getSource() == blackItem) {
			med.setColor(Color.black);
		}
		else if(e.getSource() == yellowItem) {
			med.setColor(Color.yellow);
		}
		else {
			Color color = JColorChooser.showDialog(this, "Choose background color", Color.white);
			med.setColor(color);
		}
	}
}