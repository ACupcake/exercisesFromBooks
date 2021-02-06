public class QueueWithThreeStacks<Item> {
	Stack<Item> stack1;
	Stack<Item> stack2;
	Stack<Item> auxiliary;
	boolean lastPositionIsOne;
	int size;

	public QueueWithThreeStacks() {
		stack1 = new Stack<Item>();
		stack2 = new Stack<Item>();
		auxiliary = new Stack<Item>();
		lastPositionIsOne = false;
		size = 0;
	}

	public boolean isEmpty() {
		return stack1.isEmpty();
	}


	public void enqueue(Item item) {
		if(lastPositionIsOne)
			stack2.push(item);
		else
			stack1.push(item);

		if(lastPositionIsOne)
			lastPositionIsOne = false;
		else
			lastPositionIsOne = true;
	}

	public Item dequeue() {
		while(!stack1.isEmpty()) {
			if(lastPositionIsOne) {
				auxiliary.push(stack1.pop());
				if(!stack2.isEmpty())
					auxiliary.push(stack2.pop());
			} else {
				if(!stack2.isEmpty())
					auxiliary.push(stack2.pop());
				auxiliary.push(stack1.pop());
			}
		}

		Item returnItem = auxiliary.pop();

		while(!auxiliary.isEmpty()) {
			stack1.push(auxiliary.pop());
			if(!auxiliary.isEmpty())
				stack2.push(auxiliary.pop());
		}

		if(lastPositionIsOne)
			lastPositionIsOne = false;
		else
			lastPositionIsOne = true;

		return returnItem;
	}

	public static void main(String[] args) {
		Main que = new Main<>();

		que.enqueue(1);
		que.enqueue(2);
		que.enqueue(3);
		que.dequeue();
		que.enqueue(4);
		que.enqueue(5);
		que.enqueue(6);
		que.dequeue();

		while(!que.isEmpty())
			System.out.print(que.dequeue() + " ");

		// entrace order = 1 2 3 4 5 6
		// expected = 3 4 5 6
		// remove the two first elements
	}

}