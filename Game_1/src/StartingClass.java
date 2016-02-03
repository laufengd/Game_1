
import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class StartingClass extends Applet implements Runnable, KeyListener {

	private Board board = new Board(600, 600);
	private Graphics g;
	private Square[] squares = new Square[8];
	private EmptySpace empty = new EmptySpace();

    @Override
    public void init() {
        setSize(1000, 1000);
        setBackground(Color.BLACK);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("WordSlide");
        addKeyListener(this);
    	squares = squareInit(squares);
    	empty.setLeft(squares[squares.length-1]);
    	empty.setUp(squares[squares.length-3]);
    	System.out.println(squares[5].toString());
    	System.out.println(squares[5].getLeft().toString());
    	System.out.println(empty.getLeft().toString());
        super.init();
    }

    @Override
    public void start() {
    	Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        super.stop();
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }
    
    @Override
    public void run() {
    	while (true) {
        	repaint();
       	
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 switch (e.getKeyCode()) {
		 case KeyEvent.VK_UP:
			 if(empty.getDown() != null){
	            	EmptySpace temp = empty.copy();
	            	
	            	empty.getDown().moveUp();
	            	
	            	empty.setUp(empty.getDown());
	            	empty.setLeft(empty.getDown().getLeft());
	            	empty.setRight(empty.getDown().getRight());
	            	empty.setDown(empty.getDown().getDown());
	            	
	            	
	            	
	            	
	            	empty.getUp().setLeft(temp.getLeft());
	            	empty.getUp().setRight(temp.getRight());
	            	empty.getUp().setUp(temp.getUp());
	            	empty.getUp().setDown(null);
	            	
	            	
	            	
	            	if(empty.getUp() != null)
		            	System.out.println(empty.getUp().toString());
		            	if(empty.getDown() != null)
		            	System.out.println(empty.getDown().toString());
		            	if(empty.getLeft() != null)
		            	System.out.println(empty.getLeft().toString());
		            	if(empty.getRight() != null)
		            	System.out.println(empty.getRight().toString());
		            	System.out.println("----------------------------");
	            }
	            break;

	        case KeyEvent.VK_DOWN:
	        	if(empty.getUp() != null){
	            	EmptySpace temp = empty.copy();
	            	
	            	empty.getUp().moveDown();
	            	
	            	empty.setDown(empty.getUp());
	            	empty.setLeft(empty.getUp().getLeft());
	            	empty.setRight(empty.getUp().getRight());
	            	empty.setUp(empty.getUp().getUp());
	            	
	            	
	            	
	            	
	            	empty.getDown().setLeft(temp.getLeft());
	            	empty.getDown().setRight(temp.getRight());
	            	empty.getDown().setDown(temp.getDown());
	            	empty.getDown().setUp(null);
	            	
	            	if(empty.getUp() != null)
	            	System.out.println(empty.getUp().toString());
	            	if(empty.getDown() != null)
	            	System.out.println(empty.getDown().toString());
	            	if(empty.getLeft() != null)
	            	System.out.println(empty.getLeft().toString());
	            	if(empty.getRight() != null)
	            	System.out.println(empty.getRight().toString());
	            	System.out.println("----------------------------");
	            }
	            break;

	        case KeyEvent.VK_LEFT:
	        	if(empty.getRight() != null){
	        		EmptySpace temp = empty.copy();
	            	
	            	empty.getRight().moveLeft();
	            	
	            	empty.setLeft(empty.getRight());
	            	empty.setDown(empty.getRight().getDown());
	            	empty.setUp(empty.getRight().getUp());
	            	empty.setRight(empty.getRight().getRight());
	            	
	            	
	            	
	            	
	            	empty.getLeft().setLeft(temp.getLeft());
	            	empty.getLeft().setRight(null);
	            	empty.getLeft().setDown(temp.getDown());
	            	empty.getLeft().setUp(temp.getUp());
	            	
	            	if(empty.getUp() != null)
		            	System.out.println(empty.getUp().toString());
		            	if(empty.getDown() != null)
		            	System.out.println(empty.getDown().toString());
		            	if(empty.getLeft() != null)
		            	System.out.println(empty.getLeft().toString());
		            	if(empty.getRight() != null)
		            	System.out.println(empty.getRight().toString());
		            	System.out.println("----------------------------");
	            }
	            break;

	        case KeyEvent.VK_RIGHT:
	        	if(empty.getLeft() != null){
	        		EmptySpace temp = empty.copy();
	            	
	            	empty.getLeft().moveRight();
	            	
	            	
	            	empty.setDown(empty.getLeft().getDown());
	            	empty.setUp(empty.getLeft().getUp());
	            	empty.setRight(empty.getLeft());
	            	empty.setLeft(empty.getLeft().getLeft());
	            	
	            	
	            	
	            	
	            	empty.getRight().setLeft(null);
	            	empty.getRight().setRight(temp.getRight());
	            	empty.getRight().setDown(temp.getDown());
	            	empty.getRight().setUp(temp.getUp());
	            	
	            	if(empty.getUp() != null)
		            	System.out.println(empty.getUp().toString());
		            	if(empty.getDown() != null)
		            	System.out.println(empty.getDown().toString());
		            	if(empty.getLeft() != null)
		            	System.out.println(empty.getLeft().toString());
		            	if(empty.getRight() != null)
		            	System.out.println(empty.getRight().toString());
		            	System.out.println("----------------------------");
	            }
	            break;

	        case KeyEvent.VK_SPACE:
	            System.out.println("Jump");
	            break;
		   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            System.out.println("Stop moving up");
            break;

        case KeyEvent.VK_DOWN:
            System.out.println("Stop moving down");
            break;

        case KeyEvent.VK_LEFT:
            System.out.println("Stop moving left");
            break;

        case KeyEvent.VK_RIGHT:
            System.out.println("Stop moving right");
            break;

        case KeyEvent.VK_SPACE:
            System.out.println("Stop jumping");
            break;

        }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            /*if(empty.getDown() != null){
            	EmptySpace temp = new EmptySpace(empty.getDown());
            	empty.getDown().moveUp();
            	empty.getDown().resetPosition(empty);
            	empty = temp.copy();
            	System.out.println(empty.getUp().toString());
            	System.out.println(empty.getDown().toString());
            }
            */
            break;

        case KeyEvent.VK_DOWN:
        	/*if(empty.getUp() != null){
        		EmptySpace temp = new EmptySpace(empty.getUp());
            	empty.getUp().moveDown();
            	empty.getUp().resetPosition(empty);
            	empty = temp.copy();
            	System.out.println(empty.getUp().toString());
            	System.out.println(empty.getDown().toString());
            }*/
            break;

        case KeyEvent.VK_LEFT:
        	/*if(empty.getRight() != null){
            	empty.getLeft().moveRight();
            }
            */
            break;

        case KeyEvent.VK_RIGHT:
        	/*if(empty.getDown() != null){
            	empty.getLeft().moveRight();
            }
            */
            break;

        case KeyEvent.VK_SPACE:
            System.out.println("Jump");
            break;
	   }
	}
	public void paint(Graphics g){
		//board.paint(g);
		for(Square square : squares){
			square.paint(g);
		}
	}
	public Square[] squareInit(Square[] squares){
		int row = 1, column = 1;

		for(int i = 0; i <= squares.length-1; i++){
	
			char letter = (char) ((((Math.random()) * 24) + 65));
			squares[i] = new Square(column, row, letter);
			 
			if(column%3 == 0){
				row++;
				column = 1;
			}else column++;
		}
	
		for(int i = 0; i <squares.length; i++){
			for(int j = 0; j<squares.length; j++){
				if(squares[i].getRow() != 1 && squares[j].getColumn() == squares[i].getColumn() && squares[j].getRow() == squares[i].getRow()-1){
					squares[i].setUp(squares[j]);
				}
				if(squares[i].getRow() != 3 && squares[j].getColumn() == squares[i].getColumn() && squares[j].getRow() == squares[i].getRow()+1){
					squares[i].setDown(squares[j]);
				}
				if(squares[i].getColumn() != 1 && squares[j].getRow() == squares[i].getRow() && squares[j].getColumn() == squares[i].getColumn()-1){
					squares[i].setLeft(squares[j]);
				}
				if(squares[i].getColumn() != 3 && squares[j].getRow() == squares[i].getRow() && squares[j].getColumn() == squares[i].getColumn()+1){
					squares[i].setRight(squares[j]);
				}
			}
		}	
		return squares;
	}

} 
