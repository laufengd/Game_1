import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Square {

	private int length = 160, width = 160, xpos, ypos;
	private int row, column;
	private char letter;
	private boolean selected;
	private Square left, right, up, down;
	
	public Square(int column, int row, char letter){
		this.row = row;
		this.column = column;
		this.letter = letter;
		this.selected = false;
		this.left = null; this.right = null; this.up = null; this.down = null;
	}
	
	public String toString(){
		String ret = row +", "+column+", " + letter;
		return ret;
	}
	
	public Square getLeft() {
		return left;
	}

	public void setLeft(Square left) {
		this.left = left;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Square getRight() {
		return right;
	}

	public void setRight(Square right) {
		this.right = right;
	}

	public Square getUp() {
		return up;
	}

	public void setUp(Square up) {
		this.up = up;
	}

	public Square getDown() {
		return down;
	}

	public void setDown(Square down) {
		this.down = down;
	}
		
	public void paint(Graphics g){
		int xpos = (column-1)*190 + 230;
		int ypos = (row-1)*190 + 230;
		
		g.setColor(Color.YELLOW);
		g.drawRect( xpos, ypos, length, width);
		g.fillRect(xpos, ypos, length, width);
		String x = "" + letter;
		
		Font myFont = new Font("Serif", Font.BOLD, 36);
		g.setFont(myFont);
		g.setColor(Color.BLUE);
		g.drawString(x, xpos+(length/2) - 18, ypos+(width/2)+18);
	}
	public char getLetter() {
		return letter;
	}
	
	public void moveUp(){
		row--;
	}
	public void moveDown(){
		row++;
	}
	public void moveRight(){
		column++;
	}
	public void moveLeft(){
		column--;
	}
	public void resetPosition(EmptySpace empty){
		setLeft(empty.getLeft());
		//left.setRight(this);
		setRight(empty.getRight());
		//right.setLeft(this);
		setUp(empty.getUp());
		//up.setDown(this);
		setDown(empty.getDown());
		//down.setUp(this);
	}
	
	
	
	
}