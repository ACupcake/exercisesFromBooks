public class Deque<Item> implements Iterable<Item>{
	private DoubleNode leftEnd;
	private DoubleNode rightEnd;
	private int size;

	public class DoubleNode {
		Item item;
		DoubleNode next;
		DoubleNode previous;
	}

	public Deque() {
		leftEnd = null;
		rightEnd = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void pushLeft(Item item) {
		DoubleNode node = new DoubleNode();
		node.item = item;
		node.next = leftEnd;
		node.previous = null;
		if(leftEnd != null)
			leftEnd.previous = node;
		leftEnd = node;
		size++
	}
	
	public void pushRight(Item item) {
		DoubleNode node = new DoubleNode();
		node.item = item;
		node.next = null;
		node.previous = rightEnd;
		if(rightEnd != null)
			rightEnd.next = node;
		rightEnd = node;
		size++;
	}
	
	public Item popLeft() {
		Item returnItem = leftEnd.item;
		if(leftEnd != null)
			leftEnd = leftEnd.next;
		if(leftEnd != null)
			leftEnd.previous = null;
		else
			rightEnd = null;
		size--;
		return returnItem;
	}
	
	public Item popRight() {
		Item returnItem = rightEnd.item;
		if(rightEnd != null)
			rightEnd = rightEnd.previous;
		if(rightEnd != null)
			rightEnd.next = null;
		else
			leftEnd = null;
		size--;
		return returnItem;
	}


}