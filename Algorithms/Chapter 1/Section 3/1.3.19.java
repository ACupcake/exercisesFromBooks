public class Main {	
	public static Node removeLastNode(Node first) {
		Node pivot = first;
		Node father = first;

		if(first != null) {
			while(pivot.next != null) {
				father = pivot;
				pivot = pivot.next;
			}

			if(father == pivot)
				father = null;
			else
				father.next = null;
			
			return pivot;
		} else {
			return null;
		}
	}
}