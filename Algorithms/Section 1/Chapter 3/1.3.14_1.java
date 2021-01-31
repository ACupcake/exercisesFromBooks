public class ResizingArrayQueueOfStrings {
	private String[] arr;
	private int last = 0;
	private int first = 0;
	private int size = 0;

	void ResizingArrayQueueOfStrings(int arrSize) {
		arr = new String[arrSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(String item) {
		if(size != arr.length) {
			if(last == arr.length)
				last = 0;
			arr[last++] = item;
			size++;
		}
	}

	public String dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		} else {
			size--;
			String item = arr[first];
			arr[first] = null;
			first++;
			if(first == arr.length)
				first = 0;
			return item;
		}
	}
}