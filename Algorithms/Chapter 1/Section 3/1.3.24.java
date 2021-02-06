public class Main {
	public static void removeAfter(Node node) {
		if(node != null && node.next != null) {
			node.next = node.next.next;
			size--;
		}
	}

}