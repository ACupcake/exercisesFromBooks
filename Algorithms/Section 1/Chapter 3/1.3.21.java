public class Main {
	public static boolean find(Node first, String key) {
		Node node = first;

		while(node != null) {
			if(node.item.equals(key))
				return true;
			node = node.next;
		}
		return false
	}
}