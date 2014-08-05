package collection;

public interface Stack<Item> {
    Item pop();
    Item peek();
    void push(Item item);
    boolean isEmpty();
    int size();
}   
