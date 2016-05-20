import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class MyMouseEventTest extends JFrame {
    MyMouseEventTest() {
        super("Mouse Event Test");
        addMouseListener(new MyMouseListener());
        setSize(600, 600);
    }

    public static void main(String[] args) {
        MyMouseEventTest myapp = new MyMouseEventTest();
        myapp.setVisible(true);
    }
}

class MyMouseListener extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked!");
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Don't press me like that, yo!");
    }
    public void mouseEntered(MouseEvent e) {
        System.out.println("The mouse has entered somewhere, but I don't know where, this is getX(): " + e.getX());
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("It seems like the mouse has left (exited)");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
    }
}