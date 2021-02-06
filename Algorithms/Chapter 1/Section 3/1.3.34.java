import java.util.Iterator;

public class randomBag<Item> implements Iterable<Item> {
	private Node first;
	private int size;

	public class Node {
		Item item;
		Node next;
	}

	public void randomBag() {
		first = new Node();
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void add(Item item) {
		Node current = first;
		Node node = new Node();
		node.item = item;
		node.next = null;

		if(size == 0) {
            size++;
			first = node;
			return;
		}

		int jumps = randomNumber(0, size);

        if(jumps == 0) {
            node.next = first;
            first = node;
        } else {
            while(jumps-- > 0)
	        		current = current.next;
            node.next = current.next;
	    	current.next = node;
        }
        size++;
	}

	public int randomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	@Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

	public class RandomBagIterator implements Iterator<Item> {
		Node node;
        int currentPosition;
        
        public RandomBagIterator() {
            node = first;
            currentPosition = 0;
        }

		@Override
		public boolean hasNext() {
			return currentPosition < size;
		}

        @Override
        public Item next() {
			if(node != null) {
				Item returnItem = node.item;
				node = node.next;
				currentPosition++;
				return returnItem;
			}
			return null;
		}
	}
}