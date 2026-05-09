package frame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private String title;
	private int height;
	private int width;
	public static  JFrame frame;
	public static  Canvas canvas;
	public  Display(String title,int width,int height){
		this.title=title;
		this.height=height;
		this.width=width;
		CreatDisplay();
	}
	public void  CreatDisplay(){
		frame=new JFrame(title);
		frame.setSize(width,height);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    canvas=new Canvas();
	    canvas.setPreferredSize(new Dimension(width,height));
	    canvas.setBackground(Color.CYAN);
	    canvas.setFocusable(false);
	   frame.add(canvas);
	   frame.pack();
	   
	  
	  }
		
	public Canvas getCanvas() {
		return canvas;
	}
	
	
}
