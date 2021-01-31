public class Main {
	private static void showItems(Queue<String> queue, int k ) {
		int count = 0;

		for(String character: queue) {
			count++;
			if(count >= k)
				StdOut.print(character);
		}
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		String input = args[1];
		int k = Integer.parseInt(args[0]);
		String[] chars = input.split(" ");

		for(String character: chars)
			queue.enqueue(character);
	}
}