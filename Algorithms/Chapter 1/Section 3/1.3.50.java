import java.util.ConcurrentModificationException
import java.util.Iterator;


public class Stack <Item> implements Iterable <Item> {
  private Node first; // top of stack (most recently added node)   
  private int N; // number of items   
  private int popCounter;
  private int pushCounter;
  private class Node { // nested class to define nodes  
    Item item;
    Node next;
  }
  public boolean isEmpty() {
    return first == null;
  }
  // Or: N == 0.  
  public int size() {
    return N;
  }
  public void push(Item item) {
    // Add item to top of stack.  
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
    pushCounter++;
  }
  public Item pop() {
    // Remove item from top of stack.    
    Item item = first.item;
    first = first.next;
    N--;
    popCounter++;
    return item;
  }

  public Iterator <Item> iterator() {
  return new ListIterator();
	}
	private class ListIterator implements Iterator <Item> {
	  private Node current = first;
	  private int savePopCounter = popCounter;
	  private int savePushCounter = pushCounter;

	  public boolean hasNext() {
	  	if(savePopCounter != popCounter || savePushCounter != pushCounter)
	  		throw new ConcurrentModificationException();
	    return current != null;
	  }
	  public void remove() {}
	  public Item next() {
	  	if(savePopCounter != popCounter || savePushCounter != pushCounter)
	  		throw new ConcurrentModificationException();
	    Item item = current.item;
	    current = current.next;
	    return item;
	  }
	}

}
