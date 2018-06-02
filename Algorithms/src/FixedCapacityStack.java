import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FixedCapacityStack<Item> implements Iterable<Item> {
	private int size = 0;
	private Item str[];
	
	@SuppressWarnings("unchecked")
	FixedCapacityStack(int N) {
		str = (Item[]) new Object[N]; //Unchecked warning
	}
//to be or not to - be - - that - - - is
//to be not that or be (left 2 == first to && is);
	public static void main(String args[]) {
		FixedCapacityStack<String> fcs = new FixedCapacityStack<>(20);
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) { //ctrl + Z to break
			String s = in.next();
//			if(!s.trim().equals("-")) {//correct, kill space
			if(!s.equals("-")) {//cannot just use s != "-", cause space
				fcs.push(s);
			} else if(!fcs.isEmpty()) { //s.equals("-")
				System.out.print(fcs.pop() + " ");
			}
		}
		System.out.println("\n" + fcs.size() + " left"); //use size() to replace count
		in.close();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(Item s) {
		if(size == str.length) {
			resize(str.length*2);
		}
		str[size++] = s;
	}
	
	public Item pop() {
		if(size > 0 && size <= str.length/4) {
			resize(str.length/2);
		}
		Item t = str[--size];
		str[size] = null;
		return t;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int n) {
		Item[] t = (Item[]) new Object[n];
		for(int i = 0; i < size; i++) { //not i < str.length
			t[i] = str[i];
		}
		str = t;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		private int count = size;
		
		public boolean hasNext() {
			return size > 0;
		}

		public Item next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return str[--count];
		}
		
		public void remove() {
			ReverseArrayIterator.this.remove();
		}
		
	}
	
}
