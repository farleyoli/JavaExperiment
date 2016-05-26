import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyApplication extends JFrame {
	public MyApplication(){
		super("My Painter");
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout()); //sets the layout of the jpanel jp
		this.getContentPane().add(jp); //adds the jpanel jp to this jframe
		
		MyCanvas canvas = new MyCanvas(); //jpanel
		for(int i = 0; i <= 8; i++) {
			if(i % 3 == 0)
				canvas.addDrawing(new MyString("実験Java", 20 + i*80, 20 + i * 60));
			if(i % 3 == 1)
				canvas.addDrawing(new MyOval(20 + i * 80, 20 + i * 60, 200, 200, Color.blue, Color.red, 1));
			if(i % 3 == 2)
				canvas.addDrawing(new MyStar(20 + i*80, 20 + i * 60));
		}
		jp.add(BorderLayout.CENTER, canvas);
	
		//WindowsEventリスナーを設計（無名クラスを利用している）
		this.addWindowListener(
				new WindowAdapter() {
					//ウィンドウが閉じたら終了する
					public void windowClosing(WindowEvent e) {
						System.exit(1);
					}
				}
				);
	}
	
	public static void main(String[] args) {
		MyApplication app = new MyApplication();
		app.setSize(800, 600);
		app.setVisible(true);
	}
}
