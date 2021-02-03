//https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter1/section4/Exercise31_DequeWith3Stacks.java
//Basically, we need to use the middle stack as a pivot.

public class Main<Item> {
	private Stack<Item> left = new Stack<Item>();
	private Stack<Item> middle = new Stack<Item>();
	private Stack<Item> right = new Stack<Item>();

	public int size() {
		return left.size()+middle.size()+right.size();
	}

	public boolean isEmpty() {
	 	return left.isEmpty() && middle.isEmpty() && right.isEmpty();
	}

	public void pushLeft(Item item) {
		left.push(item);
	}

	public void pushRight(Item item) {
		right.push(item);
	}

	public Item popLeft() {
        if (isEmpty())
            throw new RuntimeException("Deque underflow");
        Item item = null;

        if (!left.isEmpty()) {
            item = left.pop();
        } else {
            if (!right.isEmpty()) {
                moveHalfItems(right, left);
                item = left.pop();
            }
        }

        return item;
	}

   private void moveHalfItems(Stack<Item> fullStack, Stack<Item> emptyStack) {
        int fullStackHalfSize = fullStack.size() / 2;

        // Move half items from fullStack to middle stack
        for(int i = 0; i < fullStackHalfSize; i++) {
            middle.push(fullStack.pop());
        }

        // Move the other half items from fullStack to emptyStack
        while(!fullStack.isEmpty()) {
            emptyStack.push(fullStack.pop());
        }

        // Return all items from middle stack to fullStack
        while(!middle.isEmpty()) {
            fullStack.push(middle.pop());
        }
    }

	public Item popRight() {
        if (isEmpty())
            throw new RuntimeException("Deque underflow");
        Item item = null;

        if (!right.isEmpty()) {
            item = right.pop();
        } else {
            if (!left.isEmpty()) {
                moveHalfItems(left, right);
                item = right.pop();
            }
        }

        return item;
    }
}