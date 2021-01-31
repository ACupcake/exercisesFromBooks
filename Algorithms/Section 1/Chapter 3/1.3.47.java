public class Catenable<Item> {
	public CircularLinkedList catenation(Queue<Item> a, Queue<Item> b) {
		CircularLinkedList<Item> linkedList = new CircularLinkedList<Item>();

		while(!a.isEmpty())
			linkedList.insert(a.dequeue());

		while(!b.isEmpty())
			linkedList.insert(b.dequeue());

		if(linkedList.isEmpty())
			return null;
		return linkedList;
	}

	public CircularLinkedList catenation(Stack<Item> a, Stack<Item> b) {
		CircularLinkedList<Item> linkedList = new CircularLinkedList<Item>();

		while(!a.isEmpty())
			linkedList.insert(a.pop());

		while(!b.isEmpty())
			linkedList.insert(b.pop());

		if(linkedList.isEmpty())
			return null;
		return linkedList
	}

	public CircularLinkedList catenation(Steque<Item> a, Steque<Item> b) {
		CircularLinkedList<Item> linkedList = new CircularLinkedList<Item>();
		
		while (!a.isEmpty()) {
            linkedListCircular.insert(a.pop());
        }

        while (!b.isEmpty()) {
            linkedListCircular.insert(b.pop());
        }

		if(linkedList.isEmpty())
			return null;
		return linkedList	
	}
}