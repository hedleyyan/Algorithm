package collection;

public interface RandomQueue<Item> {
	boolean isEmpty();
	void enqueue(Item item);
	Item dequeue();
	Item sample();
}
