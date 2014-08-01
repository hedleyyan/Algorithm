package collection;

/**
 * Լɪ������
 * 
 * @author hedley
 *
 */
public class JosephusProblem {
	
	/**
	 * deal
	 * 
	 * @param offset ÿ��������ѡһ��
	 * @param length �ܹ�����
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
