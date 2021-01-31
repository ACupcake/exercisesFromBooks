public class Main {
	public static Node destructivelyReverseList(Node node) {
		Node father = null;
		
		while(node != null) {
			Node pivot = node.next;
			node.next = father;
			father = node;
			node = pivot;
		}
		return father;
	}
}