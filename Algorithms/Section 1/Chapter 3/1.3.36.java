import java.util.Iterator;
import java.util.StringJoiner;

public class Main<Item> implements Iterable<Item> {
	private Item[] arrayQueue;
	private int index;

	public Main() {
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

	@Override
	public Iterator<Item> iterator() {
		return new MainIterator();
	}

	public class MainIterator implements Iterator<Item> {
		int itemsCounter;
		
		public MainIterator() {
			itemsCounter = index - 1;
		}
		
		@Override
		public boolean hasNext() {
			return itemsCounter >= 0;
		}
		
		@Override
		public Item next() {
			int randomIndex = randomNumber(0, itemsCounter + 1);
			
			Item pivot = arrayQueue[randomIndex];
			arrayQueue[randomIndex] = arrayQueue[itemsCounter];
			arrayQueue[itemsCounter] = pivot;
			return arrayQueue[itemsCounter--];
		}
	}	
		public static void main(String[] args) {
			Main<Integer> randQueue = new Main<>();
			
			randQueue.enqueue(1);
			randQueue.enqueue(2);
			randQueue.enqueue(3);
			randQueue.enqueue(4);
			randQueue.enqueue(5);

            for(int num: randQueue)
			    System.out.print(Integer.toString(num) + " ");
		}
}