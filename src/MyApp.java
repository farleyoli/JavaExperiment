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
	private JMenu lineColorMenu;
	private JMenu lineWidthMenu;
	private JMenu IO;
	private JMenu order;
	private JMenuItem redItem, blueItem, greenItem, whiteItem, blackItem, yellowItem, otherFillColor, spotFillColor;
	private JMenuItem lineRed, lineBlue, lineGreen, lineWhite, lineBlack, lineYellow, otherLineColor, spotLineColor;
	private JMenuItem width1, width2, width3, width4, width5, otherWidth;
	private JMenuItem read, load;
	private JMenuItem oneBack, oneFront, allBack, allFront;
	
	public MyApp() {
		super("My App!");
		
		canvas = new MyCanvas();
		canvas.setBackground(Color.white);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.PAGE_AXIS));
		
		
		
		stateManager = new StateManager(canvas);
		med = canvas.getMediator();
		
		LineButton lineButton = new LineButton(stateManager);
		jp.add(lineButton);
		RectButton rectButton = new RectButton(stateManager);
		jp.add(rectButton);
		OvalButton ovalButton = new OvalButton(stateManager);
		jp.add(ovalButton);
		StarButton starButton = new StarButton(stateManager);
		jp.add(starButton);
		KochButton kochButton = new KochButton(stateManager);
		jp.add(kochButton);
//		StringButton stringButton = new StringButton(stateManager);
//		jp.add(stringButton);
		SelectedButton selectedButton = new SelectedButton(stateManager);
		selectedButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, selectedButton.getMinimumSize().height));
		jp2.add(selectedButton);
		ShadowedButton shadowedButton = new ShadowedButton(stateManager);
		shadowedButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, shadowedButton.getMinimumSize().height));
		jp2.add(shadowedButton);
		DeleteButton deleteButton = new DeleteButton(stateManager);
		deleteButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, deleteButton.getMinimumSize().height));
		jp2.add(deleteButton);
		CopyButton copyButton = new CopyButton(stateManager);
		copyButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, copyButton.getMinimumSize().height));
		jp2.add(copyButton);
		CutButton cutButton = new CutButton(stateManager);
		cutButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, cutButton.getMinimumSize().height));
		jp2.add(cutButton);
		PasteButton pasteButton = new PasteButton(stateManager);
		pasteButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, pasteButton.getMinimumSize().height));
		jp2.add(pasteButton);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		colorMenu = new JMenu("Fill Color");
		redItem = new FillColorMenu(stateManager, "Red", Color.red);
		blueItem = new FillColorMenu(stateManager, "Blue", Color.blue);
		greenItem = new FillColorMenu(stateManager, "Green", Color.green);
		whiteItem = new FillColorMenu(stateManager, "White", Color.white);
		blackItem = new FillColorMenu(stateManager, "Black", Color.black);
		yellowItem = new FillColorMenu(stateManager, "Yellow", Color.yellow);
		spotFillColor = new JMenuItem("Spot Color");
		otherFillColor = new JMenuItem("Other Colors");
		colorMenu.add(redItem);
		colorMenu.add(blueItem);
		colorMenu.add(greenItem);
		colorMenu.add(whiteItem);
		colorMenu.add(blackItem);
		colorMenu.add(yellowItem);
		colorMenu.add(spotFillColor);
		colorMenu.add(otherFillColor);
		otherFillColor.addActionListener(this);
		spotFillColor.addActionListener(this);
		menuBar.add(colorMenu);
		
		lineColorMenu = new JMenu("Line Color");
		lineRed = new LineColorMenu(stateManager, "Red", Color.red);
		lineBlue = new LineColorMenu(stateManager, "Blue", Color.blue);
		lineGreen = new LineColorMenu(stateManager, "Green", Color.green);
		lineWhite = new LineColorMenu(stateManager, "White", Color.white);
		lineBlack = new LineColorMenu(stateManager, "Black", Color.black);
		lineYellow = new LineColorMenu(stateManager, "Yellow", Color.yellow);
		spotLineColor = new JMenuItem("Spot Color");
		otherLineColor = new JMenuItem("Other Colors");
		lineColorMenu.add(lineRed);
		lineColorMenu.add(lineBlue);
		lineColorMenu.add(lineGreen);
		lineColorMenu.add(lineWhite);
		lineColorMenu.add(lineBlack);
		lineColorMenu.add(lineYellow);
		lineColorMenu.add(spotLineColor);
		lineColorMenu.add(otherLineColor);
		spotLineColor.addActionListener(this);
		otherLineColor.addActionListener(this);
		menuBar.add(lineColorMenu);
		
		lineWidthMenu = new JMenu("Line Width");
		width1 = new LineWidthMenu(stateManager, "1", 1);
		width2 = new LineWidthMenu(stateManager, "2", 2);
		width3 = new LineWidthMenu(stateManager, "3", 3);
		otherWidth = new JMenuItem("Other Width");
		lineWidthMenu.add(width1);
		lineWidthMenu.add(width2);
		lineWidthMenu.add(width3);
		lineWidthMenu.add(otherWidth);
		otherWidth.addActionListener(this);
		menuBar.add(lineWidthMenu);
		
		order = new JMenu("Change Order");
		oneBack = new OrderMenu(stateManager, "Move one position back");
		oneFront = new OrderMenu(stateManager, "Move one position to the front");
		allBack = new OrderMenu(stateManager, "Move to the background");
		allFront = new OrderMenu(stateManager, "Move to the surface");
		order.add(oneBack);
		order.add(oneFront);
		order.add(allBack);
		order.add(allFront);
		menuBar.add(order);
		
		IO = new JMenu("Save/Load");
		read = new IOMenu(stateManager, "Load File");
		load = new IOMenu(stateManager, "Save File");
		IO.add(load);
		IO.add(read);
		menuBar.add(IO);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jp, BorderLayout.NORTH);
		getContentPane().add(jp2, BorderLayout.WEST); 
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
		
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				stateManager.mouseUp(e.getX(), e.getY());
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
		
		if(med.getSelectedDrawing() == null || med.getSelectedDrawing().isSelected() == false)
			return;
		
		if(e.getSource() == otherFillColor) {
			Color color = JColorChooser.showDialog(this, "Choose color", Color.white);
			med.setColor(color);
		}
		else if(e.getSource() == otherLineColor) {
			Color color = JColorChooser.showDialog(this, "Choose color", Color.white);
			med.setLineColor(color);
		}
		else if(e.getSource() == spotFillColor) {
			stateManager.setState(new SpotState(stateManager, true));
		}
		else if(e.getSource() == spotLineColor) {
			stateManager.setState(new SpotState(stateManager, false));
		}
		else {
			String input = null;
			input = JOptionPane.showInputDialog("Choose Width (1~10)");
			if(input.matches("\\d+")) {
				//only accepting integers
				int width = Integer.parseInt(input);
				if(width >= 1 && width <= 10)
					med.setLineWidth(width);
			}
		}
	}
}