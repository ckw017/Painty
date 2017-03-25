import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class DisplayFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static final String WINDOW_TITLE = "Discount MS Paint";
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;
    
    public static void main(String[] args){
        createAndShowGUI();
    }
    
    public static void createAndShowGUI(){
        
    }
    
    public DisplayFrame(DrawingCanvas dc){
        super();
        setLayout(new FlowLayout());
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(dc, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        requestFocus();
    }
}