public class GeneralizedQueue<Item>{
	Item[] arrayQueue;
	int numberOfItems;

	public GeneralizedQueue() {
		arrayQueue = (Item[]) new Object[1];
		numberOfItems = 0; 
	}

	public boolean isEmpty() {
		return numberOfItems == 0;
	}
	
	public void insert(Item x) {
		if(numberOfItems >= arrayQueue.length)
			resize(arrayQueue.length * 2);
		arrayQueue[numberOfItems++] = x;
	}

	public Item delete(int k) {
	    Item returnItem = null;
	    
		if(arrayQueue.length > 0 && numberOfItems == arrayQueue.length / 4)
			resize(arrayQueue.length / 2);

        if(numberOfItems <= 0)
            return null;

		if(k >= 0 && k <= numberOfItems) {
			returnItem = arrayQueue[k];
			arrayQueue[numberOfItems - k - 1] = null;
			for (int i = numberOfItems - k; i < numberOfItems; i++)
				arrayQueue[i - 1] = arrayQueue[i];
			numberOfItems--;
		}
		return returnItem;
	}

	public void resize(int size) {
		Item[] newArrayQueue = (Item[]) new Object[size];

		for(int i = 0; i < arrayQueue.length; i++)
			newArrayQueue[i] = arrayQueue[i];
		arrayQueue = newArrayQueue;
	}
}