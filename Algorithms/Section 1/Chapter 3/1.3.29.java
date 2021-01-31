public class Main<Item> implements Iterable<Item>{
	Node last;
	int size = 0;

	public class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;

		if(last == null) {
			last = node;
			last.next = last;
			return;
		}

		node.next = last.next;
		last.next = node;
		last = node;
	}

	public void dequeue() {
		if(last == null)
			return;
		last.next = last.next.next;
	}
	
	public void show() {
	    Node pivot = last.next;
	    while(pivot != last) {
	        System.out.println(pivot.item);
	        pivot = pivot.next;
	    }
	    System.out.println(pivot.item);
	}

	public Iterador<Item> iterator() {
		return new IteradorQueue();
	}

	public class IteradorQueue implements Iterator<Item> {
		private Node current;

		public IteradorQueue() {
			current = last.next;
		}

		public Item next() {
			current = current.next;
		}

		public boolean hasNext() {
			return !(last == last.next);
		}
	}

	public static void main(String[] args) {
		Main linked = new Main();
		
		linked.enqueue(1);
		linked.enqueue(2);
		linked.enqueue(3);
		linked.enqueue(4);
		linked.enqueue(5);
		linked.dequeue();
		
		linked.show();
	}
}