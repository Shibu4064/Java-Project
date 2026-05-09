package gamemanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import creatplayer.player;
import enemy.Enemy;
import setup.GameSetUp;
import bullet.Bullet;

public class gamemanager {
	private player Player;
	public static ArrayList<Bullet>bullet;
    private ArrayList<Enemy>enemies;
    private long current;
    private long delay;
    private int health;
    private int score; 
	public gamemanager() {
		
	}
	public void init() {
		Player=new player((GameSetUp.gamewidth/2)+50,(GameSetUp.gameheight-60)+50);
		Player.init();
		bullet=new ArrayList<Bullet>();
		enemies=new ArrayList<Enemy>();
		current=System.nanoTime();
		delay=100;
		health=Player.geth();
		score=0;
		if(score>100)
		{
			int j=30;
			delay=200-j;
		}
		
	}
	public void tick() {
		Player.tick();
		for(int i=0;i<bullet.size();i++)
		{
			bullet.get(i).tick();
		}
		long breaks=(System.nanoTime()-current)/1000000;
		if(breaks>delay) {
		for(int i=0;i<2;i++) {
			Random rand=new Random();
			int randX=rand.nextInt(1000);
			int randY=rand.nextInt(1000);
			if(health>0) {
			enemies.add(new Enemy(randX,-randY));
			
		}
		}
		
		current=System.nanoTime();
		for(int i=0;i<enemies.size();i++) {
			
			enemies.get(i).tick();
		}
	}
	}
	public void render(Graphics graph) {
		Player.render(graph);
		for(int i=0;i<bullet.size();i++) {
			bullet.get(i).render(graph);
		}
		for(int i=0;i<bullet.size();i++)
		{
			if(bullet.get(i).getY()<=50)
			{
				bullet.remove(i);
				i--;
			}
		}
		
		//graph.fillRect(50, 50, 80);
		
		for(int i=0;i<enemies.size();i++) {
			if(!(enemies.get(i).getX()<=50||enemies.get(i).getX()>=500||enemies.get(i).getY()>=600||enemies.get(i).getY()<=50))
			{
				enemies.get(i).render(graph);
			}
			
		}
		for(int i=0;i<enemies.size();i++)
		{
			int ex=enemies.get(i).getX();
			int ey=enemies.get(i).getY();
			int py=Player.getY();
			int px=Player.getX();
			if((px<ex+50 && px+60>=ex && py<ey+50 && py+60>=ey)) {
			enemies.remove(i);
			i--;
			health--;
			if(health<=0)
			{
				Player.setHealth(0);
				enemies.removeAll(enemies);
			}
			
			
			
			}
			
			for(int j=0;j<bullet.size();j++) {
				int bx=bullet.get(j).getX();
				int by=bullet.get(j).getY();
				if(ex < bx +3 && ex+50 > bx && ey < by+3 && ey+50> by)
				{
					enemies.remove(i);
					i--;
					bullet.remove(j);
					j--;
					score+=2;
				}
				
				
			}
			graph.setColor(Color.blue);
			graph.setFont(new Font("arial",Font.BOLD,30));
			graph.drawString("Score: "+score,70,680);
		}
		
	}
}
