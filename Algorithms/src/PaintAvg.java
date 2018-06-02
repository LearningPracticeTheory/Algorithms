import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class PaintAvg extends JFrame {
	
	public static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int DIAMETER = 5;
	int x, y, sum;
	private boolean flag = true;
	
	Random r = new Random();
	List<Integer> list = new ArrayList<>();
	List<Integer> avg = new ArrayList<>();
	
	public static void main(String args[]) {
		PaintAvg pa = new PaintAvg();
		new Thread(pa.new PaintThread()).start();
	}
	
	PaintAvg() {
		launchJFrame();
	}
	
	public void launchJFrame() {
		this.setTitle("Paint Average");
		this.setSize(WIDTH, HEIGHT);
//		this.setBackground(Color.black);
		this.getContentPane().setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
//给每个点起一个重画的线程显然不太理智，使用数组/集合，参照 Missiles
//使用集合更加简便
	public void paint(Graphics g) {
		super.paint(g);
//		x = y = 100;
		
		if(list.size() == WIDTH) { //不使用 return 直接一棒子打死
			flag = false;
		}
		
		y = r.nextInt(HEIGHT);
//System.out.print(y + "\t");
		list.add(y);
//一条线往前走，不断补全
		/*
		Color c = g.getColor();
		g.setColor(Color.GREEN);		
		for(int i = 0; i < list.size(); i++) {
			g.fillOval(x, list.get(i), DIAMETER, DIAMETER);
		}
		x++; //升级为成员变量
		*/
//paint point
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		for(int i = 0; i < list.size(); i++) {
			g.fillOval(i, list.get(i), DIAMETER, DIAMETER);
		}
//paint average
		g.setColor(Color.RED);
		sum += list.get(list.size() - 1);
		avg.add(sum / list.size());
//System.out.println(avg.get(avg.size() - 1));
		for(int i = 0; i < avg.size(); i++) {
			g.fillOval(i, avg.get(i), DIAMETER, DIAMETER);
		}
		
		g.setColor(c);
	}
	
	class PaintThread implements Runnable {
		public void run() {
			try {
				while(flag) {
					Thread.sleep(10);
					repaint();
				}
			} catch(InterruptedException e) {
				flag = false;
				e.printStackTrace();
			}
		}
	}
	
}