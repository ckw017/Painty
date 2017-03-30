import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class DisplayFrame extends JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID = 1L;

	// Window Settings
	public static final String WINDOW_TITLE = "Painty";
	public static final int WINDOW_WIDTH = 680;
	public static final int WINDOW_HEIGHT = 600;

	// GUI input components
	public static DisplayFrame frame;
	public static DrawingCanvas canvas = new DrawingCanvas();
	public static JTextField brushText;
	public static JSpinner red;
	public static JSpinner blue;
	public static JSpinner green;
	public static JSlider brush;

	public DisplayFrame() {
		// Superclass constructor
		super();

		// Window properties
		this.setTitle(WINDOW_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		// Content pane properties
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(canvas, BorderLayout.CENTER);

		// User input properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.requestFocus();
	}

	public static void main(String[] args) {
		createAndShowGUI();
	}

	public static void createAndShowGUI() {
		frame = new DisplayFrame();
		Container controls = new Container();

		SpinnerNumberModel redModel = new SpinnerNumberModel(0, 0, 255, 16);
		SpinnerNumberModel blueModel = new SpinnerNumberModel(0, 0, 255, 16);
		SpinnerNumberModel greenModel = new SpinnerNumberModel(0, 0, 255, 16);
		brush = new JSlider(JSlider.HORIZONTAL, 1, 100, 10);
		brushText = new JTextField(Integer.toString(10), 3);

		controls.setLayout(new FlowLayout());
		controls.setPreferredSize(new Dimension(300, 75));

		red = addLabeledSpinner(controls, "Red:", redModel);
		blue = addLabeledSpinner(controls, "Blue:", blueModel);
		green = addLabeledSpinner(controls, "Green:", greenModel);
		controls.add(new JLabel("Brush Size:"));
		controls.add(brush);
		controls.add(brushText);

		JButton clearButton = new JButton("clear");
		clearButton.setActionCommand("clear");
		clearButton.addActionListener(frame);

		JButton backgroundColorButton = new JButton("Set Background");
		backgroundColorButton.setActionCommand("background");
		backgroundColorButton.addActionListener(frame);

		controls.add(clearButton);
		controls.add(backgroundColorButton);

		addColorButton(controls, "red", Color.RED, frame);
		addColorButton(controls, "orange", Color.ORANGE, frame);
		addColorButton(controls, "yellow", Color.YELLOW, frame);
		addColorButton(controls, "green", Color.GREEN, frame);
		addColorButton(controls, "blue", Color.BLUE, frame);
		addColorButton(controls, "magenta", Color.MAGENTA, frame);
		addColorButton(controls, "black", Color.BLACK, frame);
		addColorButton(controls, "white", Color.WHITE, frame);

		controls.setVisible(true);

		frame.getContentPane().add(controls, BorderLayout.NORTH);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.pack();

		new Thread(frame).start();
	}

	public static JButton addColorButton(Container c, String colorName, Color color, ActionListener al) {
		JButton colorButton = new JButton();
		colorButton.setPreferredSize(new Dimension(20, 20));
		colorButton.setBackground(color);
		colorButton.setBorderPainted(false);
		colorButton.setOpaque(true);
		colorButton.setActionCommand(colorName);
		colorButton.addActionListener(al);
		c.add(colorButton);
		return colorButton;
	}

	public static Color getColor() {
		int r = (int) red.getValue();
		int g = (int) green.getValue();
		int b = (int) blue.getValue();
		return new Color(r, g, b);
	}

	public static void setColor(Color c) {
		red.setValue(c.getRed());
		blue.setValue(c.getBlue());
		green.setValue(c.getGreen());
	}

	public static int getBrushSize() {
		return brush.getValue();
	}

	public static void setBrushSize(int brushSize) {
		brush.setValue(brushSize);
	}

	public static JSpinner addLabeledSpinner(Container c, String label, SpinnerModel model) {
		JLabel l = new JLabel(label);
		c.add(l);

		JSpinner spinner = new JSpinner(model);
		l.setLabelFor(spinner);
		c.add(spinner);

		return spinner;
	}

	@Override
	public void run() {
		while (true) {
			brushText.setText(Integer.toString(brush.getValue()));
			canvas.render();
		}
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "clear":
			canvas.clear();
			return;
		case "background":
			canvas.setBackground(getColor());
			canvas.render();
			System.out.println(canvas.getBackground());
			return;
		case "red":
			setColor(Color.RED);
			return;
		case "orange":
			setColor(Color.ORANGE);
			return;
		case "yellow":
			setColor(Color.YELLOW);
			return;
		case "green":
			setColor(Color.GREEN);
			return;
		case "blue":
			setColor(Color.BLUE);
			return;
		case "magenta":
			setColor(Color.MAGENTA);
			return;
		case "black":
			setColor(Color.BLACK);
			return;
		case "white":
			setColor(Color.white);
			return;
		}
	}
}
