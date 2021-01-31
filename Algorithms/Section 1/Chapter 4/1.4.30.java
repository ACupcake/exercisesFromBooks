public class Main<Item> {
	Steque<Item> steque = new Steque<Item>();
	Stack<Item> stack = new Stack<Item>();

	public boolean isEmpty() {
		return steque.isEmpty() && stack.isEmpty();
	}

	public int size() {
		return stack.size() + steque.size();
	}

	void pushLeft(Item item) {
		stack.push(item);
	}

	void pushRight(Item item) {
		steque.push(item);
	}

	Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque underflow");
        }
        if (stack.isEmpty()) {
            moveHalfStequeToStack();
        }
        return stack.pop();
	}

	//https://github.com/reneargento/algorithms-sedgewick-wayne/
    private void moveHalfStequeToStack() {
        int halfStequeSize = steque.size() / 2;
        int endHalfStequeSize = steque.size() - halfStequeSize;

        for (int i = 0; i < halfStequeSize; i++) {
            steque.enqueue(steque.pop());
        }

        for (int i = 0; i < endHalfStequeSize; i++) {
            stack.push(steque.pop());
        }
    }

	Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque underflow");
        }
        if (steque.isEmpty()) {
            while (!stack.isEmpty()) {
                steque.push(stack.pop());
            }
        }
        return steque.pop();
	}
}