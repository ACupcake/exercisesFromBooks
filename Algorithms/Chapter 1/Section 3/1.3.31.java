public class Main<Item> {
	DoubleNode first;

	public class DoubleNode {
		Item item;
		DoubleNode next;
		DoubleNode previous;
	}

	public static void insertAtBeginning(Item item) {
		DoubleNode node = new DoubleNode();
		node.item = item;
		node.next = first;
		node.previous = null;

		if(first != null)
			first.previous = node;
		first = node;
	}

	public static void insertAtEnd(Item item) {
		DoubleNode current = first;
		DoubleNode node = new DoubleNode();
		node.item = item;
		node.next = null;
		node.previous = null;

		if(first == null)
			first = node;

		while(current.next != null)
			current = current.next;

		current.next = node;
		node.previous = current;
	}

	public static void removeFromBeginning() {
		if(first != null)
			first = first.next;
	}

	public static void removeFromEnd() {
		DoubleNode current = first;
		DoubleNode follow = first;

		if(first == null)
			return;

		if(first.next == null) {
			first = null;
			return;
		}

		while(current.next != null) {
			follow = current;
			current = current.next;
		}

		follow.next = null;
	}

	public static void insertBeforeNode(DoubleNode node, Item item) {
		DoubleNode current = first;
		
		if(first == null)
			first = node;

		while(current.next != node && current.next != null) {
			current = current.next;
		}

		if(current.next == node) {
			DoubleNode newNode = new DoubleNode();
			newNode.item = item;
			newNode.next = node;
			newNode.previous = current;

			current.next = newNode;
			node.previous = newNode;
		}
	}

	public static void insertAfterNode(DoubleNode node, Item item) {
		DoubleNode current = first;
		
		if(first == null)
			first = node;

		while(current != node && current != null) {
			current = current.next;
		}

		if(current == node && node != null) {
			DoubleNode newNode = new DoubleNode();
			newNode.item = item;
			newNode.next = node.next;
			newNode.previous = node;

			if(node.next != null)
				node.next.previous = newNode;
			node.next = newNode;
		}
	}

	public static void removeNode(DoubleNode node) {
		DoubleNode current = first;

		if(first == null)
			return;

		while(current.next != node && current.next != null) {
			current = current.next;
		}

		if(current.next == node)
			current.next = node.next;
	}
}