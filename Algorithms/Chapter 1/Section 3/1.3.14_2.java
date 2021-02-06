public class ResizingArrayQueueOfStrings_2 extends ResizingArrayQueueOfStrings {
	private String[] arr;
	private int last = 0;
	private int first = 0;
	private int size = 0;

	void ResizingArrayQueueOfStrings_2(int arrSize) {
		arr = new String[arrSize];
	}

	public void resize(int newSize) {
		String[] copy = new String[newSize];
		
		for (int i = 0; i < size; i++)
			copy[i] = arr[(first + i) % arr.length];

		arr = copy;
		first = 0;
		last = size;
	}

	public void enqueue(String item) {
		if(last == arr.length) {
			resize(arr.length * 2);
		}
		if(last == arr.length)
			last = 0;
		arr[last++] = item;
		size++;
	}

	public String dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		} else {
			if(size > 0 && size == arr.length / 4) {
				resize(arr.length / 2);
			}

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