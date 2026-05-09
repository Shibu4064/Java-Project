package bullet;
import java.awt.Color;
import java.awt.Graphics;
public class Bullet {

	   private int x;
		private int y;
		private int speed;
		
	public Bullet(int x,int y) {
		this.x=x;
		this.y=y;
		speed=2;
		
		
	}
	public void tick() {
		y-=speed;
		
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public void render(Graphics graph) {
		graph.setColor(Color.WHITE);
		graph.fillRect(x,y,3,8);
		
	}

}