package collection;

public class StackAdapter<Item> implements Stack<Item> {
    private java.util.Stack<Item> stack;
    
    public StackAdapter() {
        stack = new java.util.Stack<Item>(); 
    }
    
    @Override
    public Item pop() {
        return stack.pop();
    }

    @Override
    public void push(Item item) {
        stack.push(item);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Item peek() {
        return stack.peek();
    }
    
    @Override
    public int size() {
        return stack.size();
    }

}
