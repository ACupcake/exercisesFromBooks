public class Steque<Item> {
	Node firstNode;
	Node endNode;
	int size;

	public Steque() {
		firstNode = null;
		endNode = null;
		size = 0;
	}

	public class Node {
		Item item;
		Node next;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = null;

		if(firstNode == null) {
			firstNode = node;
			endNode = node;
		} else {
			node.next = firstNode;
			firstNode = node;
		}
		size++;
	}

	public Item pop() {
		Node returnNode = firstNode;
		
		if(size == 0)
			throw new RuntimeException("Steque underflow.");

		firstNode = firstNode.next;
		if(firstNode == null)
			endNode = null;
		size--;
		return returnNode.item;
	}

	public void enqueue(Item item) {
		Node current = firstNode;
		Node node = new Node();
		node.item = item;
		node.next = null;

		if(firstNode == null) {
			firstNode = node;
		} else {
			endNode.next = node;
		}
		endNode = node;
		size++;
	}
}