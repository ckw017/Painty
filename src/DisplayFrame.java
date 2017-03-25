import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class DisplayFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	//Window Settings
	public static final String WINDOW_TITLE  = "Painty";
    public static final int    WINDOW_WIDTH  = 800;
    public static final int    WINDOW_HEIGHT = 600;
    
    //GUI input components
    public static JSpinner red;
    public static JSpinner blue;
    public static JSpinner green;
    public static JSlider brush;
    
    public DisplayFrame(DrawingCanvas dc)
    {
    	//Superclass constructor
    	super();
    	
    	//Window properties
        this.setTitle(WINDOW_TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        //Content pane properties
        this.getContentPane().setBackground(Color.WHITE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(dc, BorderLayout.CENTER);
        
        //User input properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.requestFocus();
    }
    
    public static void main(String[] args){
    	createAndShowGUI();
    }
    
    public static void createAndShowGUI(){
    	DisplayFrame frame = new DisplayFrame(new DrawingCanvas());
    	Container controls = new Container();
    	
    	SpinnerNumberModel redModel = new SpinnerNumberModel(0, 0, 255, 20);
    	SpinnerNumberModel blueModel = new SpinnerNumberModel(0, 0, 255, 20);
    	SpinnerNumberModel greenModel = new SpinnerNumberModel(0, 0, 255, 20);
    	brush = new JSlider(JSlider.HORIZONTAL, 1, 100, 10);
    	
    	controls.setLayout(new FlowLayout());
    	
    	red = addLabeledSpinner(controls, "Red:", redModel);
    	blue = addLabeledSpinner(controls, "Blue:", blueModel);
    	green = addLabeledSpinner(controls, "Green:", greenModel);
    	controls.add(new JLabel("Brush Size:"));
    	controls.add(brush);
    	
    	controls.setVisible(true);
    	
    	frame.getContentPane().add(controls, BorderLayout.NORTH);
    	frame.pack();
    }
    
    public static Color getColor(){
    	int r = (int)red.getValue();
    	int g = (int)green.getValue();
    	int b = (int)blue.getValue();
    	return new Color(r, g, b);
    }
    
    public static int getBrushSize(){
    	return brush.getValue();
    }
    
    static protected JSpinner addLabeledSpinner(Container c, String label, SpinnerModel model) {
		JLabel l = new JLabel(label);
		c.add(l);
		
		JSpinner spinner = new JSpinner(model);
		l.setLabelFor(spinner);
		c.add(spinner);
		
		return spinner;
	}
}