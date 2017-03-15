import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{
    DrawingCanvas canvas;

    public KeyboardListener(DrawingCanvas dc) {
        this.canvas = dc;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}