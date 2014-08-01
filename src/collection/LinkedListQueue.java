package collection;

public class LinkedListQueue<Item> implements Queue<Item>{
	
	//  Adapter pattern
	private LinkedListDeque<Item> queue;
	
	public LinkedListQueue() {
		queue = new LinkedListDeque<Item>();
	}
	
	@Override
	public void enqueue(Item item) {
		queue.pushRight(item);
	}

	@Override
	public Item dequeue() {
		return queue.popLeft();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
