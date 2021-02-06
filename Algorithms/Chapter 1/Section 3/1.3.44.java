public class Main<Item> extends Stack<Item>{
	Stack<Item> primaryBuffer;
	Stack<Item> auxiliarBuffer;
	int size;

	public Main() {
		primaryBuffer = new Stack<Item>();
		auxiliarBuffer = new Stack<Item>();
		size = 0;
	}
	
	public void insert(Item c) {
		primaryBuffer.push(c);
		size++;
	}

	public Item delete() {
		if(size == 0)
			return null;
		size--;
		return auxiliarBuffer.pop();
	}

	public void left(int k) {
		while(primaryBuffer != null && k-- > 0)
			auxiliarBuffer.push(primaryBuffer.pop());
	}

	public void right(int k) {
		while(auxiliarBuffer != null && k-- > 0)
			primaryBuffer.push(auxiliarBuffer.pop());
	}

	public int size() {
		return size;
	}
}