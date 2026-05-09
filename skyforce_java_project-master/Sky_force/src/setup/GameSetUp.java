package setup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import background_theme.images;
import frame.Display;
import gamemanager.gamemanager;

public class GameSetUp implements Runnable {
	private String title;
	private int width;
	private int height;
	private Thread thread;
	private boolean running;
	private  Display display;
	private BufferStrategy buffer;
	private Graphics graph;
	//private int y;
	public static final int gamewidth=500;
	public static final int gameheight=600;
	private gamemanager manager;
	public GameSetUp(String title,int width,int height) {
		this.title=title;
		this.height=height;
		this.width=width;
		
	}
	public void init() {
		images.init();
		display =  new Display(title, width,height);
		manager=new gamemanager();
		
		manager.init();
		
		
	}
	public synchronized void start() {
		if(running)
			return ;
		running=true;
		if(thread==null) {
			
		
		thread=new Thread(this);
		thread.start();
		}
		
	}
	public synchronized void stop() {
		if(!running)
			return ;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void run() {
		init();
		int fps=50;
		double  timePerTick=1000000000/fps;
		double delta=0;
		long current=System.nanoTime();
		
		while(running) {
			delta=delta+(System.nanoTime()-current);
			current=System.nanoTime();
			if(delta>1) {
			
			tick();
		render();
		delta--;
			}
		}
		
	}
	public void tick() {
		manager.tick();
		
	}
	public void render() {
		buffer= display.getCanvas().getBufferStrategy();
		if(buffer==null) {
			display.getCanvas().createBufferStrategy(3);
			return ;
		}
		graph =buffer.getDrawGraphics();
		graph.clearRect(0, 0, width,height);
		//drawing
		
		graph.drawImage(images.image,50,50,gamewidth,gameheight,null);
	    graph.drawRect(50,50,gamewidth,gameheight);
        manager.render(graph);
		
		
		//end of drawing
		buffer.show();
		graph.dispose();
		
			
	}

}
