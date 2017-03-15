import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingCanvas extends Canvas implements Runnable {

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
		DisplayFrame frame = new DisplayFrame(game);
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
		long lastTime = System.nanoTime();
		final double amountOfTicks = 20.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		// Game loop
		// tick is 20 a second
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				delta--;
			}
			render();

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}

	private void tick() {
	    
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.dispose();
		bs.show();
	}
}