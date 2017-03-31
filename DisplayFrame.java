import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class DisplayFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// Window Settings
	public static final String WINDOW_TITLE = "Painty";
	public static final int WINDOW_WIDTH = 680;
	public static final int WINDOW_HEIGHT = 600;

	// GUI input components
	private DrawingCanvas canvas;
	private JTextField brushText;

	private JSpinner red;
	private JSpinner blue;
	private JSpinner green;
	private JSlider brush;

	public DisplayFrame() {
		// Superclass constructor
		super();

		canvas = new DrawingCanvas(this);

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

		createAndShowGUI();
	}

	private void createAndShowGUI() {
		ButtonListener buttonListener = new ButtonListener(this);

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
		clearButton.addActionListener(buttonListener);

		JButton backgroundColorButton = new JButton("Set Background");
		backgroundColorButton.setActionCommand("background");
		backgroundColorButton.addActionListener(buttonListener);

		controls.add(clearButton);
		controls.add(backgroundColorButton);

		addColorButton(controls, "red", Color.RED, buttonListener);
		addColorButton(controls, "orange", Color.ORANGE, buttonListener);
		addColorButton(controls, "yellow", Color.YELLOW, buttonListener);
		addColorButton(controls, "green", Color.GREEN, buttonListener);
		addColorButton(controls, "blue", Color.BLUE, buttonListener);
		addColorButton(controls, "magenta", Color.MAGENTA, buttonListener);
		addColorButton(controls, "black", Color.BLACK, buttonListener);
		addColorButton(controls, "white", Color.WHITE, buttonListener);

		controls.setVisible(true);

		this.getContentPane().add(controls, BorderLayout.NORTH);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.pack();

		new Thread(new Loop(this)).start();
	}

	private JButton addColorButton(Container c, String colorName, Color color, ActionListener al) {
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

	private JSpinner addLabeledSpinner(Container c, String label, SpinnerModel model) {
		JLabel l = new JLabel(label);
		c.add(l);

		JSpinner spinner = new JSpinner(model);
		l.setLabelFor(spinner);
		c.add(spinner);

		return spinner;
	}

	// Getters And Setters

	public Color getColor() {
		int r = (int) red.getValue();
		int g = (int) green.getValue();
		int b = (int) blue.getValue();
		return new Color(r, g, b);
	}

	public void setColor(Color c) {
		red.setValue(c.getRed());
		blue.setValue(c.getBlue());
		green.setValue(c.getGreen());
	}

	public int getBrushSize() {
		return brush.getValue();
	}

	public void setBrushSize(int brushSize) {
		brush.setValue(brushSize);
	}

	public DrawingCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(DrawingCanvas canvas) {
		this.canvas = canvas;
	}

	public JTextField getBrushText() {
		return brushText;
	}

	public void setBrushText(JTextField brushText) {
		this.brushText = brushText;
	}

	public JSlider getBrush() {
		return brush;
	}

	public void setBrush(JSlider brush) {
		this.brush = brush;
	}
}