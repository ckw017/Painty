import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInputListener extends MouseAdapter{
	private boolean pressed;

	public boolean isPressed(){
		return pressed;
	}
	
	public void mouseReleased(MouseEvent e) {
		pressed = false;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		pressed = true;
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
}