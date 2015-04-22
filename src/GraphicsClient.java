import java.awt.Color;

public class GraphicsClient {
	
	public static void main(String[] args) 
	{
	//	SimpleGraphics.fillTriangle(100, 50, 80, 30, 20, 50, Color.black);
		SimpleGraphics.fillCircle(20, 70,100, Color.blue);
		SimpleGraphics.drawLine(20, 20, 70, 70, 200, Color.red);
		SimpleGraphics.fillRectangle(100, 200, 100, 500, Color.yellow);
		SimpleGraphics.fillSquare(50, 50, 200, Color.pink);
		
	}

}
