public class Main {
	public static void remove(Node node, String key) {
		Node current;
		Node father;

		if(node == null)
			return;

		/* Iterate until the first node is different from the key */
		while(node.item == key && node.next != null) {
			node = node.next;
		}

		current = node;
		father = node;

		/* Iterate if the first element is different from the key */
		while(current != null) {
			if(current.item == key)
				father.next = current.next;
			father = current;
			current = current.next;
		}
	}
}