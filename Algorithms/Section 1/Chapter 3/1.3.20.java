public class Main {
	public static Node delete(int k, Node first) {
		Node pivot = first;
		Node father = first;
		int count = 0;

		for(int count = 0; count != k && pivot != null; count++) {
			father = pivot
			pivot = pivot.next;
		}

		if(pivot == null) {
			return null;
		} else if(count == k) {
			father.next = pivot.next;
			return pivot;
		} else {
			return null
		}
	}
}