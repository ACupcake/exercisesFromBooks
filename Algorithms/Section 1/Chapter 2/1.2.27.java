public class Main {
	public static int max(Node node) {
		Node current = node;
		if(node == null)
			return 0;

		int maximum = (Integer) current.item;
		while(current != null) {
			if((Integer) current.item > maximum)
				maximum = (Integer) current.item;
			current = current.next;
		}
	}
}