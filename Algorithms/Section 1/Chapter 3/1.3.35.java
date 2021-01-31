import java.util.Iterator;

public RandomQueue<Item>{
	private Item[] arrayQueue;
	private int index;

	public RandomQueue() {
		arrayQueue = (Item[]) new Object[1];
		index = 0;
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void enqueue(Item item) {
		if(index == arrayQueue.length)
			resize(arrayQueue.length * 2);
		arrayQueue[index++] = item;
	}

	public Item dequeue() {
		if(isEmpty())
			throw new RuntimeException("Queue underflow.");

		Item pivot;
		int randomIndex = randomNumber(0, arrayQueue.length);
		
		if(index > 0 && index == arrayQueue.length / 4)
			resize(arrayQueue.length / 2);

		pivot = arrayQueue[randomIndex];
		arrayQueue[randomIndex] = arrayQueue[index];
		arrayQueue[index] = pivot;
		index--;

		return pivot;
	}

	public Item sample() {
		if(isEmpty())
			throw new RuntimeException("Queue underflow.");
		int randomIndex = randomNumber(0, arrayQueue.length);
		return arrayQueue[randomIndex];
	}

	public int randomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public void resize(int newSize) {
		Item[] newArray = (Item[]) new Object[newSize];

		for(int i = 0; i < arrayQueue.length; i++) {
			newArray[i] = arrayQueue[i];
		}
		arrayQueue = newArray;
	}
}