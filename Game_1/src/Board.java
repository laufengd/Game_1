import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private int length, width;
	
	
	public Board(int length, int width){
		this.length = length;
		this.width = width;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawRect(200, 200, length, width);
		g.fillRect(200,  200, length, width);
	}
}
