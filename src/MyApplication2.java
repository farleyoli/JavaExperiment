import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyApplication2 extends JFrame {
    public MyApplication2() {
        super("My Painter");
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        MyCanvas canvas = new MyCanvas();

        
        jp.add(BorderLayout.CENTER, canvas);
        getContentPane().add(jp);

        MyMouseAdapter ma = new MyMouseAdapter(canvas);
        canvas.addMouseListener(ma);

        //test
        addWindowListener( 
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(1);
                    }
                });
    }

    public static void main(String[] args) {
        MyApplication2 ma = new MyApplication2();
        ma.setSize(400 * 3, 300 * 3);
        ma.setVisible(true);
    }
}

//A class that uses mouse events
class MyMouseAdapter extends MouseAdapter {
    private MyCanvas canvas;

    public MyMouseAdapter(MyCanvas canvas) {
        this.canvas = canvas;
    }

    //Write what happens when the mouse clicks in here
    public void mouseClicked(MouseEvent e) {
        canvas.addDrawing(new MyRectangle(e.getX(), e.getY()));

        //Instruction to repaint the Canvas
        canvas.repaint();
    }
}    