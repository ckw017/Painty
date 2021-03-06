import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;

public class DrawingCanvas extends Canvas{
	
	//Canvas settings
    private static final long serialVersionUID = 1L;
    public static int CANVAS_WIDTH = DisplayFrame.WINDOW_WIDTH;
    public static int CANVAS_HEIGHT = DisplayFrame.WINDOW_HEIGHT;
    
    //Cursor positions
    private double previousX = -1;
    private double previousY = -1;
    
    private DisplayFrame frame;
    
    //Constructor
    public DrawingCanvas(DisplayFrame frame){
    	this.frame = frame;
    	this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        this.addKeyListener(new KeyboardListener(frame));
        this.addMouseListener(new MouseInputListener(frame));
        this.addMouseWheelListener((MouseWheelListener) this.getMouseListeners()[0]);
    }

    //Render method for drawing
    public void render() {
        if(this.isDrawing()){
            Point currentPos = this.getMousePosition();
			if(currentPos != null){
				double currentX = currentPos.getX();
				double currentY = currentPos.getY();
				if(this.previousX != -1 && this.previousY != -1){
					this.drawStroke(previousX, previousY, currentX, currentY);
				}
				this.previousX = currentX;
				this.previousY = currentY;
			}
        }
        else{
        	this.previousX = -1;
        	this.previousY = -1;
        }
    }
    
    public void drawStroke(double x1, double y1, double x2, double y2){
    	int brushSize = frame.getBrushSize();
    	Graphics2D g2 = this.get2DGraphics();
    	g2.setColor(frame.getColor());
    	g2.fill(new Ellipse2D.Double(x1 - brushSize/2, y1 - brushSize/2, frame.getBrushSize(), brushSize));
    	g2.setStroke(new BasicStroke(frame.getBrushSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }
    
    public void clear(){
        Graphics2D g2 = this.get2DGraphics();
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle(CANVAS_WIDTH, CANVAS_HEIGHT));
    }
    
    public BufferStrategy getBufferStrategy()
    {
    	BufferStrategy bs = super.getBufferStrategy();
    	if(bs == null) //Check if a buffer strategy currently exists
    	{
    		//If not, creates a buffer strategy and returns it
    		createBufferStrategy(1);
    		return super.getBufferStrategy();
    	}
    	else
    	{
    		//Otherwise, returns the buffer strategy
    		return bs;
    	}
    }
    
    public Graphics2D get2DGraphics(){
    	BufferStrategy bs = this.getBufferStrategy();
    	Graphics g = bs.getDrawGraphics();
    	Graphics2D g2 = (Graphics2D)g;
    	return g2;
    }
    
    public boolean isDrawing(){
    	MouseListener[] mouseListeners = this.getMouseListeners();
    	MouseInputListener inputListener = (MouseInputListener)mouseListeners[0];
    	return inputListener.isPressed();
    }
}