 package background_theme;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class images {
	
	
	
	public static BufferedImage image;
	public static BufferedImage drawing;
	public static BufferedImage player,enemy;
	public static  void init() {
		image=imageLoader("/bla.jpg");
		drawing=imageLoader("/airplane.png");
		crop();
	}
	
	public static BufferedImage imageLoader(String path) {
		try {
			return ImageIO.read(images.class.getResource(path));
		} catch (IOException e) {
			
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	public static  void crop() {
		
		enemy=drawing.getSubimage(0, 0, 85, 95);
		player=drawing.getSubimage(85, 0, 115, 95);
	}
		
	

}
