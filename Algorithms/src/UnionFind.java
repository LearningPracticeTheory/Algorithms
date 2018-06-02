import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class UnionFind extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int N = 5; 
	private static final int DIAMETER = 5;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 1000;
	private static int cost = 0;
	private static int total = 0;
	public int a[] = new int[N];
	private int weighted[] = new int[N];
	private int count;
	Random r = new Random();
	private ArrayList<Integer> listCost = new ArrayList<>();
	private ArrayList<Integer> listTotalAvg = new ArrayList<>();
	
	public static void main(String args[]) {
		new UnionFind();
	}
	
	UnionFind() {
		initialized();
		execute();
	}
	
	private void initialized() {
		cost = 0;
		total = 0;
		count = a.length;
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
			weighted[i] = 1;
		}
	}
	
	private void execute() {
		
		System.out.println("quick_find test");
		union(3, 4); 
		printArray(); 
		union(1, 2); 
		printArray();
		union(2, 3); 
		printArray();
		System.out.println("--------------------");
		System.out.println("quick_union test"); 
		initialized();
		quickUnion(3, 4); 
		printArray(); 
		quickUnion(1, 2);
		printArray();
		quickUnion(2, 3); 
		printArray();
		System.out.println("--------------------");
		System.out.println("weigthed_union test"); 
		initialized();
		weightedUnion(0, 1);
		printArray();
		weightedUnion(1, 2);
		printArray();
		weightedUnion(3, 4);
		printArray();
		weightedUnion(4, 0);
		printArray();
		System.out.println("--------------------");
		System.out.println("Delete(x) test"); 
		delete(4);
		printArray();
		delete(0);
		printArray();
		System.out.println("--------------------");
		initialized();
		weightedUnion(0, 1);
		printArray();
		weightedUnion(1, 2);
		printArray();
		weightedUnion(3, 4);
		printArray();
		weightedUnion(4, 0);
		printArray();
		System.out.println("--------------------");
		System.out.println("Delete(x, y) test");
		delete(0, 3);
		printArray();
		delete(0, 0);
		printArray();
		System.out.println("--------------------");
		System.out.println("weighted count"); 
		weightedPrint();
	
/*		
		a = new int[10];
		weighted = new int[10];
		System.out.println("--------------------");
		System.out.println("normal test from book"); 
		initialized();
		weightedUnion(4, 3);
		printArray();
		weightedUnion(3, 8);
		printArray();
		weightedUnion(6, 5);
		printArray();
		weightedUnion(9, 4);
		printArray();
		weightedUnion(2, 1);
		printArray();
		weightedUnion(8, 9);
		printArray();
		weightedUnion(5, 0);
		printArray();
		weightedUnion(7, 2);
		printArray();
		weightedUnion(6, 1);
		printArray();
		weightedUnion(1, 0);
		printArray();
		weightedUnion(6, 7);
		printArray();
		System.out.println("--------------------");
		System.out.println("weighted count"); 
		weightedPrint();
*/
/*
		System.out.println("--------------------");
		System.out.println("worst test from book"); 
		initialized();
		weightedUnion(0, 1);
		printArray();
		weightedUnion(2, 3);
		printArray();
		weightedUnion(4, 5);
		printArray();
		weightedUnion(6, 7);
		printArray();
		weightedUnion(0, 2);
		printArray();
		weightedUnion(4, 6);
		printArray();
		weightedUnion(0, 4);
		System.out.println("--------------------");
		System.out.println("weighted count"); 
		weightedPrint();
*/
//GUI display the times of access array and average
		
		a = new int[500];
		weighted = new int[a.length];
		initialized();
		display();
		PaintThread pt = new PaintThread();
		new Thread(pt).start();
		
	}
	
	public boolean delete(int x) {
		if(x < 0 || x > a.length) { //throw OutOfBounds
			return false;
		} else if(a[x] != x) { //!root
			changeUpsWeighted(x);
			count++;
			a[x] = x;
		} else { //root
			for(int i = 0; i < a.length; i++) {
				if(a[i] == x && i != x) {
					a[i] = i; //under root's elements all point to itself as root
					weighted[x] -= weighted[i]; //others no need change
					count++; //come back
				}
			}
		}
		return true;
	}
	
	public boolean delete(int x, int y) {
		if(x == y) {
			return this.delete(x);
		}
		int xRoot = findRoot(x);
		int yRoot = findRoot(y);
		if(xRoot != yRoot) {
			return false;
		} else if(weighted[x] < weighted[y]) { //weighted higher, closer root
			changeUpsWeighted(x);
		} else {
			changeUpsWeighted(y);
		}
		count++;
		return true;
	}
	
	private void changeUpsWeighted(int x) {
		int t = x;
		while(a[t] != t) {
			t = a[t];
			weighted[t] -= weighted[x]; //up elements all minus the weightedX
		}
		a[x] = x;
	}
	
 	private void display() {
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
	}

	private void randomNum() {
		int x = r.nextInt(a.length);
		int y = r.nextInt(a.length);
//		union(x, y); //重复连接时候，只需 find 数组 两次，其余均要遍历一遍
//		quickUnion(x, y); //归并数量越多，树越长，find 越昂贵
		weightedUnion(x, y); //稳定 log 级
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		randomNum();
		listCost.add(cost);
		total += cost;
		listTotalAvg.add(total);
		for(int i = 0; i < listCost.size(); i++) { //draw on middle
			g.fillOval(i, HEIGHT-10-listCost.get(i), DIAMETER, DIAMETER);
		}
		
		g.setColor(Color.RED);
		for(int i = 0; i < listTotalAvg.size(); i++) { //draw on middle
			g.fillOval(i, HEIGHT-10-listTotalAvg.get(i)/(i+1), DIAMETER, DIAMETER);
		}
		
		g.setColor(c);
	}

	class PaintThread implements Runnable {
		boolean flag = true;
		@Override
		public void run() {
			while(flag) {
				if(listCost.size() == WIDTH) {
					flag = false;
				}
				repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 数据处理放置在 归并过程
	public void union(int x, int y) { //遍历统一元素值
		cost = 0;
		int x_val = find(x);
		int y_val = find(y);
		if (x_val == y_val) {
			return;
		}
		for (int i = 0; i < a.length; i++) { // default use right as main element
			cost++;
			if (a[i] == x_val) {
				a[i] = y_val;
			}
		}
		count--;
	}

	// 数组模拟链表，链表带 root 形成树
	public void quickUnion(int x, int y) {
		cost = 0;
		int xRoot = findRoot(x);
		int yRoot = findRoot(y);
		if (xRoot == yRoot) {
			return;
		}
		a[xRoot] = yRoot;
		count--;
	}
	
	public void weightedUnion(int x, int y) {
		cost = 0;
		int xRoot = findRoot(x);
		int yRoot = findRoot(y);
		if (xRoot == yRoot) {
			return;
		} else if (weighted[xRoot] < weighted[yRoot]) {
			weighted[yRoot] += weighted[xRoot];
			a[xRoot] = yRoot;
		} else {
			weighted[xRoot] += weighted[yRoot];
			a[yRoot] = xRoot;
		}
		count--;
	}
	
	public int find(int t) {
		cost++;
		return a[t];
	}
	
	// 数据处理侧重在 find 过程
	public int findRoot(int t) {
		while (t != a[t]) {
			cost++;
			t = a[t];
		}
		return t;
	}

	public boolean connected(int x, int y) {
		return find(x) == find(y);
		// return a[x] == a[y];
		/*
		 if(a[x] == a[y]) { 
		 	return true; 
		 } 
		 return false;
		*/
	}

	public boolean connectedRoot(int x, int y) {
		return findRoot(x) == findRoot(y);
	}

	public int count() {
		return count;
	}

	private void printArray() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\ncount = " + count);
	}

	private void weightedPrint() {
		for(int i = 0; i < weighted.length; i++) {
			System.out.print(weighted[i] + " ");
		}
		System.out.println();
	}
	
}
