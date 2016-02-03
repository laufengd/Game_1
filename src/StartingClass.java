
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

    @Override
    public void init() {
        setSize(1000, 1000);
        setBackground(Color.BLACK);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("WordSlide");
        addKeyListener(this);
    	squares = squareInit(squares);   	
        super.init();
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        super.start();
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
        	paint(g);
        	System.out.println("Hello");
        	
            try {
                Thread.sleep(17);
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
	            System.out.println("Move up");
	            break;

	        case KeyEvent.VK_DOWN:
	            System.out.println("Move down");
	            break;

	        case KeyEvent.VK_LEFT:
	            System.out.println("Move left");
	            break;

	        case KeyEvent.VK_RIGHT:
	            System.out.println("Move right");
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
		
	}
	public void paint(Graphics g){
		board.paint(g);
		for(Square square : squares){
			square.paint(g);
		}
	}
	public Square[] squareInit(Square[] squares){
		int row = 1, column = 1, i = 0;

		for(i = 0; i <= squares.length-1; i++){
			char letter = (char) ((((Math.random()) * 24) + 65));
			squares[i] = new Square(row, column, letter);
			System.out.println(squares[i].getLetter());
			row++; column++;
		}
		return squares;
	}

} 
