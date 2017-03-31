
public class Loop implements Runnable {

	private DisplayFrame frame;

	public Loop(DisplayFrame frame) {
		this.frame = frame;
	}

	public void run() {

		// The loop that just renders the canvas
		while (true) {
			frame.getBrushText().setText(Integer.toString(frame.getBrush().getValue()));
			frame.getCanvas().render();
		}
	}

}
