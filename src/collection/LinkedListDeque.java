package collection;

import java.util.Iterator;

public class LinkedListDeque<Item> implements Deque<Item>, Iterable<Item>{
    
    private class Node {
        Item item;
        Node previous;
        Node next;
    }
    
    private Node first;
    private Node last;
    private int length;
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void pushLeft(Item item) {
        Node n = new Node();
        n.item = item;
        if (!isEmpty()) {
            n.next = first;
            first.previous = n;
        } else {
            last = n;
        }
        first = n;
        length ++;
    }

    @Override
    public void pushRight(Item item) {
        Node n = new Node();
        n.item = item;
        if (!isEmpty()) {
            last.next = n;
            n.previous = n;
        } else {
            first = n;
        }
        last = n;
        length ++;
    }

    @Override
    public Item popLeft() {
        Item item = first.item;
        if (size() > 1) {
            // 防止内存泄露
            first.next.previous = null;
        }
        first = first.next;
        length --;
        return item;
    }

    @Override
    public Item popRight() {
        Item item = last.item;
        if (size() > 1) {
            last.previous.next = null;
        }
        last = last.previous;
        length --;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator1();
    }
    
    private class Iterator1 implements Iterator<Item> {
        
        Node cur = first;
        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            Item item = cur.item;
            cur = cur.next;
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
        return info;
    }
    
    
    public static void main(String[] args) {
        String str = "l1 l2 r3 r4 -l -l -r r5 l6 r7 -r -l ";
        testDeque(new LinkedListDeque<Integer>(), str);
//        testDeque(new ResizingArrayDeque<Integer>(), str);
    }
    
    private static void testDeque(Deque<Integer> q, String str) {
        String[] strs = str.split("\\s+");
        for (String subStr : strs) {
            if (subStr.equals("-l")) {
                q.popLeft();
            } else if (subStr.equals("-r")){
                q.popRight();
            } else if (subStr.startsWith("l")) {
                q.pushLeft((Integer.valueOf(subStr.substring(1))));
            } else if (subStr.startsWith("r")) {
                q.pushRight((Integer.valueOf(subStr.substring(1))));
            }
            System.out.printf("%-10s %-20s length:%d \n", subStr, q, q.size());
        }
    }

}
