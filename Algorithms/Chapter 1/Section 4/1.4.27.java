public class Main<Item> {
	private Stack<Item> enqueueStack = new Stack<>(); 
	private Stack<Item> dequeueStack = new Stack<>(); 

	//O(1)
	public static void enqueue(Item item) {
		enqueueStack.push(item);
	}

	//O(n)
	public static void dequeue(Item item) {
		if(dequeueStack.isEmpty()) {
			while(!enqueueStack.isEmpty())
				dequeueStack.push(enqueueStack.pop());
		}
		return dequeueStack.pop();
	}
}