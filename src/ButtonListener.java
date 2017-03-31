import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	private DisplayFrame frame;

	public ButtonListener(DisplayFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "clear":
			// Clears Canvas
			frame.getCanvas().clear();
			return;
		case "background":
			// Sets Canvas Background
			frame.getCanvas().setBackground(frame.getColor());
			frame.getCanvas().render();
			return;

		// Sets the Colors
		case "red":
			frame.setColor(Color.RED);
			return;
		case "orange":
			frame.setColor(Color.ORANGE);
			return;
		case "yellow":
			frame.setColor(Color.YELLOW);
			return;
		case "green":
			frame.setColor(Color.GREEN);
			return;
		case "blue":
			frame.setColor(Color.BLUE);
			return;
		case "magenta":
			frame.setColor(Color.MAGENTA);
			return;
		case "black":
			frame.setColor(Color.BLACK);
			return;
		case "white":
			frame.setColor(Color.white);
			return;
		}
	}
}