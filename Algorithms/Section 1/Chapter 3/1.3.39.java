public class RingBuffer<Item>{
	private Queue<Item> overflowItems;
	private int dumpCount;
	private Item[] arrayBuffer;
	private int size;
	private int first;
	private int last;

	public RingBuffer(int N) {
		arrayBuffer = (Item[]) new Object[N];
		dumpCount = 0;
		overflowItems = new Queue<>();
		size = 0;
		first = 0;
		last = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void produce(Item item) {
		if (dumpCount > 0) {
            //There is data to be consumed
            System.out.print(item + " consumed.");
            dumpCount--;
            return;
        }

		if(size == arrayBuffer.length) {
			overflowItems.enqueue(item);
			return;
		}

		arrayBuffer[last++] = item;

		if(last == arrayBuffer.length)
			last = 0;
		size++;
	}

	public Item consume() {
		if(isEmpty()) {
			dumpCount++;
			return null;
		}

		Item returnItem = arrayBuffer[first];
		arrayBuffer[first++] = null;

		if(first == arrayBuffer.length)
			first = 0;
		size--;

		if(!overflowItems.isEmpty()) {
			produce(overflowItems.dequeue());
		}

		return returnItem;
	}
}