import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class BarChart extends JFrame {

	private static final long serialVersionUID = 1L;
	private int array[];
	private int height, width;
	private static final int HEIGHT_MULTIPLE = 10;
	private static final int WIDTH_MULTIPLE = 20;
//	private static final int REFRESH_TIME = 10;
	private static final int REFRESH_TIME = 500;
	private static long startTime = System.currentTimeMillis();
	
	BarChart(int height, int width) { //initialized Frame
		this.height = height*HEIGHT_MULTIPLE;
		this.width = width*WIDTH_MULTIPLE;
		initializedFrame();
	}
	
	private void initializedFrame() {
		this.setSize(width, height);
		this.setTitle("Dynamic Sort on Bar Chart");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GRAY);
		this.setVisible(true);
	}
	
/*条状动态转换*/
	/*
	public void draw(int array[]) {
		this.array = array;
		refresh();
	}
	
	public void paint(Graphics g) {
		super.paint(g); //solved recover bar's problem
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		for(int i = 0; i < array.length; i++) {
			int barHeight = array[i]*HEIGHT_MULTIPLE;
			g.fillRect(i*WIDTH_MULTIPLE, height-barHeight, WIDTH_MULTIPLE, barHeight);
		}
		g.setColor(Color.BLACK);
		g.drawString("runTime:" + (System.currentTimeMillis()-startTime)/1000.0 + "s", 10, 50);
		g.setColor(c);
	}
	*/
	
	private boolean isCompares[] = null;
	
	public void draw(int array[], boolean isMoves[]) {
		this.array = array;
		this.isCompares = isMoves;
		refresh();
	}
	
/*显示一次外循环中参与比较的元素*/	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		for(int i = 0; i < array.length; i++) {
			int barHeight = array[i]*HEIGHT_MULTIPLE;
			if(isCompares[i]) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.GREEN);
			}
			g.fillRect(i*WIDTH_MULTIPLE, height-barHeight, WIDTH_MULTIPLE, barHeight);
		}
		g.setColor(Color.BLACK);
		g.drawString("runTime:" + (System.currentTimeMillis()-startTime)/1000.0 + "s", 10, 50);
		g.setColor(c);
	}

	private void refresh() {
		try {
			Thread.sleep(REFRESH_TIME);
			repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
