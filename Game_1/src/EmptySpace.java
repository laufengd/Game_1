
public class EmptySpace {
	private Square left, right, up, down;

	public EmptySpace(){
		left = null;
		right = null;
		up = null;
		down = null;
	}
	public EmptySpace(Square square){
		this.right = square.getRight();
		this.left = square.getLeft();
		this.up = square.getUp();
		this.down = square.getDown();
	}
	
	public EmptySpace(EmptySpace another){
		
		this.left = another.getLeft();
		this.right = another.getRight();
		this.up = another.getUp();
		this.down = another.getDown();
	}
	
	public EmptySpace copy(){
		EmptySpace ret = new EmptySpace(this);
		return ret;
	}



	public Square getLeft() {
		return left;
	}



	public void setLeft(Square left) {
		this.left = left;
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
}
