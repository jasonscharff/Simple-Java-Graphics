import java.awt.Color;

public class GraphicsClient {
	
	public static void main(String[] args) 
	{
		SimpleGraphics.fillTriangle(100, 50, 80, 30, 20, 50, Color.black);
		SimpleGraphics.drawCircle(100, 100, 50);
		SimpleGraphics.drawLine(20, 20, 70, 70);
		SimpleGraphics.drawRectangle(100, 200, 100, 500);
		SimpleGraphics.drawSquare(50, 50, 200);
	}

}
