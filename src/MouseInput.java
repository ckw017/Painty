import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput extends MouseAdapter implements MouseListener {
	private DrawingCanvas canvas;

	public MouseInput(DrawingCanvas dc) {
		this.canvas = dc;
	}

	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}