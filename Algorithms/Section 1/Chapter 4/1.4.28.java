public class Main<Item> {
	Queue<Item> queue = new Queue<Item>;

	public static void push(Item item) {
		queue.enqueue(item);
	}

	public static Item pop() {
		if(queue.isEmpty()) {
			throw new RuntimeException("Stack underflow.");
		}

		int lastItem = queue.size() - 1;
		for(int i = 0; i < lastItem; i++) {
			queue.push(queue.dequeue());
		}
		return queue.dequeue();
	}
}