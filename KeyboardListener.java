import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {

	private DisplayFrame frame;

	public KeyboardListener(DisplayFrame frame) {
		this.frame = frame;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		// Decrease Brush Size when Pressed
		case KeyEvent.VK_BRACELEFT:
			frame.setBrushSize(frame.getBrushSize() - 1);
			return;
		case KeyEvent.VK_OPEN_BRACKET:
			frame.setBrushSize(frame.getBrushSize() - 1);
			return;

		// Increase Brush Size when Pressed
		case KeyEvent.VK_CLOSE_BRACKET:
			frame.setBrushSize(frame.getBrushSize() + 1);
			return;
		case KeyEvent.VK_BRACERIGHT:
			frame.setBrushSize(frame.getBrushSize() + 1);
			return;
		}
	}
}