import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput extends MouseAdapter implements MouseListener {
	private DrawingCanvas canvas;
	boolean pressed = false;

	public MouseInput(DrawingCanvas dc) {
		this.canvas = dc;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		pressed = true;
	}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}