public class Main<Item> {
	Deque<Item> deque;
	int sizeRight = 0;
	int sizeLeft = 0;
	
	public Main() {
		deque = new Deque<Item>;
		sizeRight = 0;
		sizeLeft = 0;
	}

	public boolean isRightEmpty() {
		return sizeRight == 0;
	}

	public boolean isLeftEmpty() {
		return sizeLeft == 0;
	}

	public int sizeRight() {
		return sizeRight;
	}

	public int sizeLeft() {
		return sizeLeft;
	}

	public void pushLeft(Item item) {
		deque.pushLeft(item)
		sizeLeft++;
	}
	
	public void pushRight(Item item) {
		deque.pushRight(item);
		sizeRight++;
	}
	
	public Item popLeft() {
		if(sizeLeft == 0)
			return null

		sizeLeft--;
		return deque.popLeft();
	}
	
	public Item popRight() {
		if(sizeRight == 0)
			return null

		sizeRight--;
		return deque.popRight();
	}
}