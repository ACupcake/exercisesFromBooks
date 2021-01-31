public class Main {
	public static void insertAfter(Node node1, Node node2) {
		if(node1 == null || node2 == null)
			return;

		node2.next = node1.next;
		node1.next = node2;
	}
}