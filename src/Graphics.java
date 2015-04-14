import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Graphics extends JFrame {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	
	public Graphics()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
			
	}
	
	public void drawCircle(int x, int y, int radius)
	{
		Graphics2D g = (Graphics2D) getGraphics();
		g.drawOval(x, y, radius/2, radius/2);
	}
	
	public void drawCircle(int x, int y, int radius, Color c)
	{
		Graphics2D g = (Graphics2D) getGraphics();
		g.setColor(c);
		g.fillOval(x, y, radius, radius);
	}
	
	public void drawSquare(int x, int y, int sideLength)
	{
		Graphics2D g = (Graphics2D) getGraphics();
		g.drawRect(x, y, sideLength, sideLength);
	}
	
	public void drawSquare(int x, int y, int sideLength, Color c)
	{
		Graphics2D g = (Graphics2D) getGraphics();
		g.setColor(c);
		g.fillRect(x, y, sideLength, sideLength);
	}
	
	public void addImage(int x, int y, String name)
	{
		BufferedImage image;
		try 
		{
			image = ImageIO.read(new File(name));
			Graphics2D g = (Graphics2D) getGraphics();
			g.drawImage(image, x, y, null);
			
		} 
		catch (IOException e) {
			System.out.println("That's not a valid file path. Make sure you put it in the project folder"
					+ ",but not in the src folder.");
		}
		
	}
	
	public void addImageFromInternet(int x, int y, String url)
	{
		
	}
	
	
	
	
	
	
	
}
