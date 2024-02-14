package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameManager extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH =700;
	public static final int HEIGHT = 700;
	UI ui = new UI(this);
	GamePlay gp = new GamePlay(this,ui);
	botPlay bot = new botPlay(this);
	pullButton pB = new pullButton(this);
	private boolean running= false;
	private Thread thread;
	

	public static void main(String[] args) {
		
		
		GameManager gm = new GameManager();
		gm.start();

	}
	public void setRunning() {
		running = false;
	}
	private synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	public GameManager() {
		
	}
	public int nub =0;
	
	public void run() {
		long lastTime = System.nanoTime();
		final double amountOfTick = 60.0;
		double ns = 1000000000 / amountOfTick;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			
			delta += (now-lastTime)/ns;
			lastTime = now;
			if(delta>=1) {
				delta--;
			}
			if(System.currentTimeMillis() - timer>1000) {
				timer+=1000;
				if(nub==3) {
					ui.setRound();
					nub =0;
				}
				nub++;
			}
		}
		stop();
	}
	
}

