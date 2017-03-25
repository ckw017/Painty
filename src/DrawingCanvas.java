import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.awt.Rectangle;
import java.awt.*;

public class DrawingCanvas extends Canvas implements Runnable {
    private double currX;
    private double currY;
    private double prevX;
    private double prevY;
    private boolean prevAvailable = false;
    private static final long serialVersionUID = 1L;
    public static int WIDTH = DisplayFrame.WINDOW_WIDTH - 40;
    public static int HEIGHT = DisplayFrame.WINDOW_HEIGHT - 40;

    private boolean running = false;
    private Thread thread;

    public void init() {
        this.addKeyListener(new KeyboardListener(this));
        this.addMouseListener(new MouseInput(this));
    }

    public static void main(String args[]) {
        DrawingCanvas game = new DrawingCanvas();
        game.init();
        new DisplayFrame(game);
        game.start();
    }

    private synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run() {
        while (running) {
            render();
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(1);
            return;
        }
        if(((MouseInput)getMouseListeners()[0]).pressed == true){
            Graphics2D g = (Graphics2D)bs.getDrawGraphics();
            g.setColor(Color.BLUE);
            if(getMousePosition() != null){
                prevX = currX;
                prevY = currY;
                currX = getMousePosition().getX();
                currY = getMousePosition().getY();
            }
            g.fill(new Ellipse2D.Double(currX - 5, currY - 5, 10, 10));
            if(prevAvailable){
                g.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
                g.draw(new Line2D.Double(prevX, prevY, currX, currY));//add all of these into an array list
            }
            if(prevAvailable == false){
                prevAvailable = true;
            }
            bs.show();
        }
        else if(((MouseInput)getMouseListeners()[0]).pressed == false){
            prevAvailable = false;
        }
    }
    
    public void clear(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(1);
            return;
        }
        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fill(new Rectangle(1000, 1000));
    }
}