package enemy;

import java.awt.Color;
import java.awt.Graphics;

import background_theme.images;

public class Enemy {
	private int x;
	private int y;
	public Enemy(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
	public void tick() {
		y+=1;
		
		
	}
	public void render(Graphics graph) {
		
		graph.drawImage(images.enemy,x, y, 50, 50,null);
		
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

