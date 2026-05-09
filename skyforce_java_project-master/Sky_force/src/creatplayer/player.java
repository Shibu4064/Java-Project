package creatplayer;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import background_theme.images;
import frame.Display;
import gamemanager.gamemanager;
import bullet.Bullet;
public  class player implements KeyListener {
	private int x;
	private int y;
	private boolean left,right;
	private boolean fire;
	private long current;
	private long delay;
	private int health;
	private int s;
	public player(int x,int y) {
		this.x=x;
		this.y=y;
		
		
	}
	public void init() {
		Display.frame.addKeyListener(this);
		current=System.nanoTime();
		delay=100;
		health=3;
		
	}
	
	public void tick() {
		if(!(health<=0)) {
			
		
		
		if(left) {
			if(x>=50)
			{
			x-=1;
		}
		}
		if(right) {
			if(x<508) {
			x+=1;
		}
			
		}
		
		
		
		if(fire) {
			long breaks= (System.nanoTime()-current)/90000;
			
			if(breaks>delay) {
			gamemanager.bullet.add(new Bullet(x+20,y));
		}
			current=System.nanoTime();
		}
		
		
		}
		
	}
	public void render(Graphics graph) {
		if(!(health<=0))
		{
		
		graph.drawImage(images.player,x,y,60,60,null);
		
		
	}
	
	}
	public void keyReleased(KeyEvent e) {
		int source=e.getKeyCode();
		if(source==KeyEvent.VK_LEFT) {
			left=false;
		}
		if(source==KeyEvent.VK_RIGHT) {
			right=false;
		}
		
		if(source==KeyEvent.VK_UP) {
			fire=false;
		}
		
		
	}

	private int getKeyCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void KeyTyped(KeyEvent e ) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		@Override
	public void keyPressed(KeyEvent e) {
		int source=e.getKeyCode();
		if(source==KeyEvent.VK_LEFT) {
			left=true;
		}
		if(source==KeyEvent.VK_RIGHT) {
			right=true;
		}
		if(source==KeyEvent.VK_UP) {
			fire=true;
		}
		
	}
	public  int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int geth()
	{
		return health;
	
	}
	public void setHealth(int health)
	{
		this.health=health;
	}

}
