import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item>{
	private int itemsInArray;
	private int arrayMaxSize;
	private Item[] array;
	private int arrBegin;
	private int arrEnd;

	public ResizingArrayDeque() {
		array = (Item[]) new Object[1];
		arrayMaxSize = 1;
		itemsInArray = 0;
		arrBegin = 1;
		arrEnd = 0;
	}

	public boolean isEmpty() {
		return itemsInArray == 0;
	}

	public int size() {
		return itemsInArray;
	}

	public void pushLeft(Item item) {
		if(itemsInArray >= arrayMaxSize - 1)
			resizeArray(arrayMaxSize * 2);

    	if(arrBegin > 0)
			arrBegin--;
		else
			arrBegin = arrayMaxSize - 1;

		array[arrBegin] = item;
		itemsInArray++;
	}

	public void pushRight(Item item) {
	    if(itemsInArray >= arrayMaxSize - 1)
			resizeArray(arrayMaxSize * 2);

	    if(arrEnd < arrayMaxSize - 1)
			arrEnd++;
		else
			arrEnd = 0;
		
		array[arrEnd] = item;
		itemsInArray++;

		for(int i = 0; i < arrayMaxSize; i++)
    		System.out.println(array[i]);
    	System.out.println();
	}
	
	public Item popLeft() {
	    Item returnItem = null;
	    
		if(itemsInArray > 0) {
		    returnItem = array[arrBegin];
			array[arrBegin] = null; /* For garbage collector */
			itemsInArray--;
			if(arrBegin < arrayMaxSize)
				arrBegin++;
			else
				arrEnd = 0;
		}

		if(itemsInArray > 0 && itemsInArray == arrayMaxSize / 4)
			resizeArray(arrayMaxSize / 2);
			
		return returnItem;
	}
	
	public Item popRight() {
	    Item returnItem = null;
	    
		if(itemsInArray > 0) {
		    returnItem = array[arrEnd];
			array[arrEnd] = null; /* For garbage collector */
			itemsInArray--;
			if(arrEnd > 0)
				arrEnd--;
			else
				arrEnd = arrayMaxSize - 1;
		}

		if(itemsInArray > 0 && itemsInArray == arrayMaxSize / 4)
			resizeArray(arrayMaxSize / 2);
			
		return returnItem;
	}

	public void resizeArray(int size) {
		Item[] newArr = (Item[]) new Object[size];
		int k = arrBegin;

		for(int i = 0; i < itemsInArray; i++) {
			if(k == arrayMaxSize)
				k = 0;
			newArr[i] = array[k++];
		}
		

		arrBegin = 0;
		arrEnd = itemsInArray - 1;
		array = newArr;
		arrayMaxSize = size;
	}

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        int index = arrBegin;

        @Override
        public boolean hasNext() {
            return index != arrEnd + 1;
        }

        @Override
        public Item next() {
            Item item = array[index];
            index++;
            if(index >= arrayMaxSize)
                index = 0;
            return item;
        }
    }
}