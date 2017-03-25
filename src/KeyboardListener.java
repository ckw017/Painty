import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{
    private DrawingCanvas canvas;

    public KeyboardListener(DrawingCanvas dc) {
        this.canvas = dc;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key){
	        case KeyEvent.VK_C:
	        	this.canvas.clear();
	        	return;
        }
    }

    public void keyReleased(KeyEvent e) {
    	
    }
}