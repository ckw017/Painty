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
		
		// Decrease Brush Size when Pressed
		case KeyEvent.VK_BRACELEFT:
			DisplayFrame.setBrushSize(DisplayFrame.getBrushSize() - 1);
			return;
		case KeyEvent.VK_OPEN_BRACKET:
			DisplayFrame.setBrushSize(DisplayFrame.getBrushSize() - 1);
			return;

		// Increase Brush Size when Pressed
		case KeyEvent.VK_CLOSE_BRACKET:
			DisplayFrame.setBrushSize(DisplayFrame.getBrushSize() + 1);
			return;
		case KeyEvent.VK_BRACERIGHT:
			DisplayFrame.setBrushSize(DisplayFrame.getBrushSize() + 1);
			return;
	       
		case KeyEvent.VK_LEFT:
	        	return;
	        case KeyEvent.VK_RIGHT:
	        	return;
        }
    }

    public void keyReleased(KeyEvent e) {
    	
    }
}
