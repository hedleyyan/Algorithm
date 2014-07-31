package collection;

/**
 * 约瑟夫环问题
 * 
 * @author hedley
 *
 */
public class JosephusProblem {
	
	/**
	 * deal
	 * 
	 * @param offset 每隔几个人选一人
	 * @param length 总共人数
	 */
	public static void deal (int offset, int length) {
		Queue<Integer> queue = new LinkedListQueue<Integer>();
		
		// initial
		for (int i=1; i<=length; i++) {
			queue.enqueue(i);
		}
		
		for (int i=0; i<length; i++) {
			for (int j=1; j<offset; j++) {
				queue.enqueue(queue.dequeue());
			}
			System.out.print(queue.dequeue() + " ");
		}
	}
	
	public static void main(String[] args) {
		deal (2, 7);
	}
	
}
