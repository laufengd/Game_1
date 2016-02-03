import java.awt.Color;
import java.awt.Graphics;

public class Square {

	private int length = 140, width = 140;
	private int row, column;
	private char letter;
	private boolean selected;
	
	public Square(int row, int column, char letter){
		this.row = row;
		this.column = column;
		this.letter = letter;
		this.selected = false;
	}
		
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		g.drawRect(row*200, column*200, length, width);
		g.fillRect(row*200, column*200, length, width);
	}
	public char getLetter() {
		return letter;
	}
}