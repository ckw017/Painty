import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInputListener extends MouseAdapter{
	
	private boolean pressed;
	private DisplayFrame frame;
	
	public MouseInputListener(DisplayFrame frame){
		this.frame = frame;
	}
	
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
        frame.getBrush().setValue(frame.getBrush().getValue() + e.getWheelRotation() * 3); 
	}
}