import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;

public class SimpleGraphics {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	static final JFrame frame = new JFrame();
	static boolean hasConfiguredJFrame = false;
	static HashMap<String, Color> colors = getColorsMap();
	

	
	
	private static HashMap<String, Color> getColorsMap()
	{
		HashMap<String, Color> colors = new HashMap<String, Color>();
		colors.put("blue", Color.blue);
		colors.put("pink", Color.pink);
		colors.put("red", Color.red);
		colors.put("magenta", Color.magenta);
		colors.put("grey", Color.gray);
		colors.put("gray", Color.gray);
		colors.put("black", Color.black);
		colors.put("white", Color.white);
		colors.put("green", Color.green);
		colors.put("yellow", Color.yellow);
		colors.put("orange", Color.orange);
		colors.put("purple", new Color(128, 0, 128));
		colors.put("sky", new Color(135, 206, 235));
		
		return colors;
	}
	
	public static void addText(int x, int y, String text)
	{
		configureJFrame();
		frame.getContentPane().add(new Text(x, y, text));
		frame.setVisible(true);
	}
	
	public static void addText(int x, int y, String text, int fontSize)
	{
		configureJFrame();
		frame.getContentPane().add(new Text(x, y, text, fontSize));
		frame.setVisible(true);
	}
	
	public static void addText(int x, int y, String text, String font)
	{
		configureJFrame();
		frame.getContentPane().add(new Text(x, y, text, font));
		frame.setVisible(true);
	}
	
	public static void addText(int x, int y, String text, String font, int fontSize)
	{
		configureJFrame();
		frame.getContentPane().add(new Text(x, y, text, fontSize, font));
		frame.setVisible(true);
	}
	
	public static void addTextWithColor(int x, int y, String text, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Text(x, y, text, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid color");
		}
	}
	
	public static void addTextWithColor(int x, int y, String text, int fontSize, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Text(x, y, text, fontSize,c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid color");
		}
	}
	
	public static void addTextWithColor(int x, int y, String text, String font, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Text(x, y, text, font, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid color");
		}
	}
	
	public static void addTextWithColor(int x, int y, String text, String font, int fontSize, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Text(x, y, text, fontSize, font, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid color");
		}
	}
	

	public static void drawCircle(int x, int y, int radius)
	{
		configureJFrame();
		Oval o = new Oval(x, y, radius *2, radius * 2);
		frame.getContentPane().add(new Oval(x, y, radius * 2, radius * 2));
		frame.setVisible(true);
	}

	public static void fillCircle(int x, int y, int radius, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			Oval o = new Oval(x, y, radius *2, radius * 2);
			frame.getContentPane().add(new Oval(x, y, radius * 2, radius * 2, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid Color");
		}
		
	}

	public static void drawSquare(int x, int y, int sideLength)
	{
		configureJFrame();
		frame.getContentPane().add(new Rectangle(x, y, sideLength, sideLength));
		frame.setVisible(true);	
	}
	
	public static void fillSquare(int x, int y, int sideLength, String color)
	{
		configureJFrame();
		Color c = colors.get(color.toLowerCase());
		frame.getContentPane().add(new Rectangle(x, y, sideLength, sideLength, c));
		frame.setVisible(true);
	}
	
	public static void drawRectangle(int x, int y, int width, int height)
	{
		configureJFrame();
		frame.getContentPane().add(new Rectangle(x, y, width, height));
		frame.setVisible(true);	
	}
	
	public static void fillRectangle(int x, int y, int width, int height, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Rectangle(x, y, width, height, c));
			frame.setVisible(true);	
		}
		else
		{
			System.err.println("Invalid Color");
		}
		
	}

	

	public static boolean addImage(int x, int y, String name)
	{
		configureJFrame();
		boolean success = true;
		BufferedImage image;
		try 
		{
			image = ImageIO.read(new File(name));
			frame.getContentPane().add(new Image(x, y, image));
			frame.setVisible(true);	
		} 
		catch (IOException e) {
			System.out.println("That's not a valid file path. Make sure you put it in the project folder"
					+ ",but not in the src folder.");
			success = false;
		}
		return false;

	}


	public static boolean addImageFromInternet(int x, int y, String url)
	{
		configureJFrame();
		boolean success = true;
		try 
		{
			BufferedImage image = ImageIO.read(new URL(url));
			frame.getContentPane().add(new Image(x, y, image));
			frame.setVisible(true);	
		} 
		catch (IOException e) 
		{
			success = false;
		}
		return success;
	}


	public static void drawTriangle(int point1X, int point1Y, int point2X, int point2Y, int point3X, 
			int point3Y)
	{
				configureJFrame();
				int [] xCoordinates = {point1X, point2X, point3X};
				int [] yCoordinates = {point1Y, point2Y, point3Y};
				frame.getContentPane().add(new Polygon(xCoordinates, yCoordinates));
				frame.setVisible(true);
	}
	
	public static void drawTriangle(int point1X, int point1Y, int point2X, int point2Y, int point3X, 
			int point3Y, int thickness)
	{
				configureJFrame();
				int [] xCoordinates = {point1X, point2X, point3X};
				int [] yCoordinates = {point1Y, point2Y, point3Y};
				frame.getContentPane().add(new Polygon(xCoordinates, yCoordinates, thickness));
				frame.setVisible(true);
	}

	public static void fillTriangle (int point1X, int point1Y, int point2X, int point2Y, int point3X, 
			int point3Y, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			int [] xCoordinates = {point1X, point2X, point3X};
			int [] yCoordinates = {point1Y, point2Y, point3Y};
			frame.getContentPane().add(new Polygon(xCoordinates, yCoordinates, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid Color");
		}
				
	}

	public static void drawLine(int x1, int y1, int x2, int y2)
	{
		configureJFrame();
		frame.getContentPane().add(new Line(x1, y1, x2, y2));
		frame.setVisible(true);
	}
	
	public static void drawLine(int x1, int y1, int x2, int y2, int thickness)
	{
		configureJFrame();
		frame.getContentPane().add(new Line(x1, y1, x2, y2, thickness));
		frame.setVisible(true);
	}
	
	public static void drawLine(int x1, int y1, int x2, int y2, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Line(x1, y1, x2, y2, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid Color");
		}
		
	}
	
	public static void drawLine(int x1, int y1, int x2, int y2, int thickness, String color)
	{
		if(colors.containsKey(color.toLowerCase()))
		{
			Color c = colors.get(color.toLowerCase());
			configureJFrame();
			frame.getContentPane().add(new Line(x1, y1, x2, y2, thickness, c));
			frame.setVisible(true);
		}
		else
		{
			System.err.println("Invalid Color");
		}
		
	}


	private static void configureJFrame()
	{
		if(!hasConfiguredJFrame)
		{
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(WIDTH, HEIGHT);
			frame.setVisible(true);
			hasConfiguredJFrame = true;
		}

	}

	
	

}

//Shape Classes
//http://sanjaal.com/java/tag/java-list-of-all-font-names/
class Text extends JComponent
{
	static final String defaultFont = "TimesRoman";
	static final int defaultFontSize = 12;
	int x;
	int y;
	String text;
	int fontSize = 0;
	Color color = null;
	String font = null;
	
	public Text(int x, int y, String text)
	{
		this.x  = x;
		this.y = y;
		this.text = text;
	}
	
	public Text(int x, int y, String text, int fontSize)
	{
		this.x  = x;
		this.y = y;
		this.text = text;
		this.fontSize = fontSize;
				
	}
	
	public Text (int x, int y, String text, int fontSize, String font)
	{
		this.x  = x;
		this.y = y;
		this.text = text;
		this.fontSize = fontSize;
		this.font = font;
	}
	
	
	public Text (int x, int y, String text, String font)
	{
		this.x = x;
		this.y = y;
		this.text = text;
		this.font = font;
	}
	
	public Text(int x, int y, String text, Color c)
	{
		this.x  = x;
		this.y = y;
		this.text = text;
		this.color = c;
	}
	
	public Text(int x, int y, String text, int fontSize, Color c)
	{
		this.x  = x;
		this.y = y;
		this.text = text;
		this.fontSize = fontSize;
		this.color = c;
				
	}
	
	public Text (int x, int y, String text, int fontSize, String font, Color c)
	{
		this.x  = x;
		this.y = y;
		this.text = text;
		this.fontSize = fontSize;
		this.font = font;
		this.color = c;
	}
	
	
	public Text (int x, int y, String text, String font, Color c)
	{
		this.x = x;
		this.y = y;
		this.text = text;
		this.font = font;
		this.color = c;
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if(fontSize > 0 && font != null)
		{
			g2.setFont(new Font(font, Font.PLAIN, fontSize));
		}
		else if (fontSize > 0)
		{
			g2.setFont(new Font(defaultFont, Font.PLAIN, fontSize));
		}
		else if (font != null)
		{
			g2.setFont(new Font(this.font, Font.PLAIN, defaultFontSize));
		}
		else
		{
			g2.setFont(new Font(defaultFont, Font.PLAIN, defaultFontSize));
		}
		if(this.color != null)
		{
			g2.setColor(color);
		}
		g2.drawString(text, x, y);
	}
}

class Image extends JComponent
{
	BufferedImage image;
	int x;
	int y;
	
	public Image(int x, int y, BufferedImage image)
	{
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	public void paint (Graphics g)
	{
		g.drawImage(image, x, y, null);
	}
}



class Rectangle extends JComponent
{
	int x;
	int y;
	int width;
	int height;
	Color c = null;
	int thickness = 0;

	public Rectangle(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangle(int x, int y, int width, int height, Color c)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}

	public Rectangle(int x, int y, int width, int height, int thickness)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.thickness = thickness;
	}

	public void paint(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		if(c != null)
		{
			g.setColor(c);
			g2.fillRect(x, y, width, height);
		}
		else
		{
			if (thickness > 0)
			{
				g2.setStroke(new BasicStroke(thickness));
			}
			g2.drawRect(x, y, width, height);

		}

	}
}

	class Oval extends JComponent
	{
		int x;
		int y;
		int radius_w;
		int radius_h;
		Color c = null;
		int thickness = 0;

		public Oval(int x, int y, int radius_w, int radius_h)
		{
			this.x = x;
			this.y = y;
			this.radius_w = radius_w;
			this.radius_h = radius_h;
		}

		public Oval (int x, int y, int radius_w, int radius_h, Color c)
		{
			this.x = x;
			this.y = y;
			this.radius_w = radius_w;
			this.radius_h = radius_h;
			this.c = c;
		}

		public Oval (int x, int y, int radius_w, int radius_h, int thickness)
		{
			this.x = x;
			this.y = y;
			this.radius_w = radius_w;
			this.radius_h = radius_h;
			this.thickness = thickness;
		}


		public void paint(Graphics g) 
		{
			Graphics2D g2 = (Graphics2D) g;
			if(c != null)
			{
				g.setColor(c);
				g2.fillOval(x, y, radius_w * 2, radius_h * 2);
			}
			else
			{
				if (thickness > 0)
				{
					g2.setStroke(new BasicStroke(thickness));
				}
				g2.drawOval(x, y, radius_w, radius_h);

			}

		}
	}

		class Polygon extends JComponent
		{
			int [] xCoordinates;
			int [] yCoordinates;
			Color c = null;
			int thickness = 0;

			public Polygon(int [] xCoordinates, int [] yCoordinates)
			{
				this.xCoordinates = xCoordinates;
				this.yCoordinates = yCoordinates;
			}

						public Polygon(int [] xCoordinates, int [] yCoordinates, Color c)
						{
							this.xCoordinates = xCoordinates;
							this.yCoordinates = yCoordinates;
							this.c = c;
						}
			
						public Polygon(int [] xCoordinates, int [] yCoordinates, int thickness)
						{
							this.xCoordinates = xCoordinates;
							this.yCoordinates = yCoordinates;
							this.thickness = thickness;
						}

			public void paint(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				if(c != null)
				{
					g2.setColor(c);
					g2.fillPolygon(xCoordinates, yCoordinates, xCoordinates.length);
				}
				else
				{
					if (thickness > 0)
					{
						g2.setStroke(new BasicStroke(thickness));
					}
					g2.drawPolygon(this.xCoordinates, this.yCoordinates, this.xCoordinates.length);
				}


			}
		}
	
	class Line extends JComponent 
	{
		int x1, y1, x2, y2;
		Color c = null;
		int thickness = 0;

		public Line(int x1, int y1, int x2, int y2)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		public Line(int x1, int y1, int x2, int y2, int thickness)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.thickness = thickness;
		}
		public Line(int x1, int y1, int x2, int y2, int thickness, Color c)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.thickness = thickness;
			this.c = c;
		}

		public Line(int x1, int y1, int x2, int y2, Color c)
		{
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.c = c;
		}

		public void paint(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			if(c != null)
			{
				g.setColor(c);
			}
			if (thickness > 0)
			{
				g2.setStroke(new BasicStroke(thickness));
			}
			g2.drawLine(x1, y1, x2, y2);
		}
	}
