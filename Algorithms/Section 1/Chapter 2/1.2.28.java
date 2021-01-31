public class Main {
	public static int max(Node node) {
		if(node == null)
			return 0;

		int maximum = (int) node.item;;
		int nextNumber = max(node.next);
		
		if(maximum > nextNumber)
			return maximum;
		return nextNumber;
	}
}