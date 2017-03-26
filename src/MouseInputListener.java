import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInputListener extends MouseAdapter{
	private boolean pressed;

	public boolean isPressed(){
		return pressed;
	}
	
	public void mouseReleased(MouseEvent e) {
		pressed = false;
	}

	public void mousePressed(MouseEvent e) {
		pressed = true;
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
        DisplayFrame.brush.setValue(DisplayFrame.brush.getValue() + e.getWheelRotation() * 3); 
	}
}