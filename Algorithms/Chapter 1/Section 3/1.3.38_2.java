public class GeneralizedQueue<Item> {
	Node queueNode;

	public class Node {
		Item item;
		Node next;
	}

	public GeneralizedQueue() {
		queueNode = null;
	}

	public boolean isEmpty() {
		return queueNode == null;
	}
	
	public void insert(Item x) {
		Node current = queueNode;
		Node node = new Node();
		node.item = x;
		node.next = null;

		if(queueNode == null) {
			queueNode = node;
			return;
		}

		while(current.next != null)
			current = current.next;
		current.next = node;
	}

	public Item delete(int k) {
		Node current = queueNode;
		Node father = queueNode;

        /* Remove first element */
        if(queueNode == null)
            return null;
        else if(k == 1 && queueNode.next == null) {
            queueNode = null;
            return null;
        } else if(k == 1) {
            Item returnItem = queueNode.item;
            queueNode = queueNode.next;
            return returnItem;
        }


        /* Remove kth element */        
        while(k > 1 && current != null) {
            father = current;
            current = current.next;
            k--;
        }
        if(k == 1) {
            if(father == current)
                current = current.next;
            father.next = current.next;
            return current.item;
        }
        return null;
	}
}