package collection;

import java.util.Arrays;
import java.util.Random;

public class ResizingArrayRandomQueue<Item> implements RandomQueue<Item> {

	private static final int DEFAULT_SIZE = 4;
	private Item[] items;
	private int head;
	private int tail;
	private int length;
	
	public ResizingArrayRandomQueue() {
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public ResizingArrayRandomQueue(int size) {
		items = (Item[]) new Object[size];
	}
	
	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public void enqueue(Item item) {
		if (length == items.length - 1) {
			resize(items.length * 2);
		}
		items[tail] = item;
		tail = (tail + 1) % items.length;
		length ++;
	}

	@Override
	public Item dequeue() {
		if (length == items.length / 4) {
			resize(items.length / 2);
		}
		
		int randomIndex = getRandomIndex();
		Item temp = items[randomIndex];
		items[randomIndex] = items[head];
		
		items[head] = null;
		head = (head + 1) % items.length;
		length --;
		return temp;
	}
	
	private int getRandomIndex() {
		Random random = new Random();
		int offset = random.nextInt(length);
		return (head + offset) % items.length;
	}

	private void resize(int size) {
		@SuppressWarnings("unchecked")
		Item[] items2 = (Item[]) new Object[size];
		
		for (int i = head, j = 0; i != tail; i = (i + 1) % items.length, j++) {
			items2[j] = items[i];
		}
		
		items = items2;
		head = 0;
		tail = length;
	}

	@Override
	public Item sample() {
		return null;
	}

	@Override
	public String toString() {
		String info = "items:" + Arrays.toString(items);
		info += " head:" + head;
		info += " tail:" + tail;
		return info;
	}
	
	public static void main(String[] args) {
		String str = "1 2 3 5 - - - 6 7 - - 9 3 1 - - - ";
		testRandomQueue(new ResizingArrayRandomQueue<Integer>(), str);
	}
	
	private static void testRandomQueue(RandomQueue<Integer> q, String str) {
        String[] strs = str.split("\\s+");
        for (String subStr : strs) {
            if (subStr.equals("-")) {
                q.dequeue();
            } else {
                q.enqueue(((Integer.valueOf(subStr))));
            }
            System.out.println(subStr + " " + q);
	    }
	}
}
