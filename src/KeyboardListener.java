import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{
    DrawingCanvas canvas;

    public KeyboardListener(DrawingCanvas dc) {
        this.canvas = dc;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_C){
        	canvas.clear();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}