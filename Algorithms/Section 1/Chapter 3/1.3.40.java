public class Main<Item> {
	Node first;

	public class Node {
		Item item;
		Node next;
	}

	public void insert(Character item) {
		Node current = first;
		Node father = first;
		Node node = new Node();
		node.item = item;
		node.next = first;

		if(first == null) {
			first = node;
		}

		while(current.next != null) {
			if(current.item == item) {
				if(father == current)
					father = father.next
				else
					father.next = current.next;
				break;
			}
			father = current;
			current = current.next;
		}

		first = node;
	}
}