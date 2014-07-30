package collection;

import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Deque<Item>, Iterable<Item> {

	private static final int DEFAULT_SIZE = 4;
	private Item[] items;
	private int head;
	private int tail;
	private int length;
	
	public ResizingArrayDeque() {
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public ResizingArrayDeque(int size) {
		items = (Item[]) new Object[size];
	}
	
	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public void pushLeft(Item item) {
		if (length == items.length - 1) {
			resize(items.length * 2);
		}
		head = (head - 1 + items.length) % items.length;
		items[head] = item;
		length ++;
	}

	@Override
	public void pushRight(Item item) {
		if (length == items.length - 1) {
			resize(items.length * 2);
		}
		items[tail] = item;
		tail = (tail + 1) % items.length;
		length ++;
	}

	@Override
	public Item popLeft() {
		if (length == items.length / 4) {
			resize(items.length / 2);
		}
		Item item = items[head];
		items[head] = null;
		head = (head + 1) % items.length;
		length --;
		return item;
	}

	@Override
	public Item popRight() {
		if (length == items.length / 4) {
			resize(items.length / 2);
		}
		tail = (tail - 1 + items.length) % items.length;
		Item item = items[tail];
		items[tail] = null;
		length --;
		return item;
	}
	
	private void resize(int size) {
		@SuppressWarnings("unchecked")
		Item[] items2 = (Item[]) new Object[size];
		int index = 0;
		for (Item item : this) {
			items2[index++] = item;
		}
		items = items2;
		head = 0;
		tail = length;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator1();
	}
	
	private class Iterator1 implements Iterator<Item> {
		int cur = head;
		@Override
		public boolean hasNext() {
			return items[cur] != null;
		}

		@Override
		public Item next() {
			Item item = items[cur];
			cur = (cur + 1) % items.length;
			return item;
		}

		@Override
		public void remove() {
			
		}
	}
	
	@Override
	public String toString() {
		String info = "Deque:";
		for (Item item : this) {
			info += item + " ";
		}
//		info += Arrays.toString(items);
//		info += " head:" + head;
//		info += " tail:" + tail;
		return info;
	}
	
	

}
