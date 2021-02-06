public class CopyAQueue<Item>{
	public CopyAQueue(Queue<Item> r, Queue<Item> q) {
		for(Item item: q) {
			r.enqueue(item);
		}
	}
}