import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class CurveGraph extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int SIZE = 10;
	
	private int width;
	private int height;
	private int index = 0;
	private int heights[];
	
	public CurveGraph(int width, int height) {
		this.width = width;
		this.height = height;
		heights = new int[height];
		launchFrame();
	}

	public void launchFrame() {
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void draw(int n, int t) {
		heights[index++] = t;
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		for(int i = 0; i <= index; i++) {
			g.fillOval(i, height-heights[i], SIZE, SIZE);
		}
		g.setColor(c);
	}
	
}
