public class Main {
	public static void main(String[] args) {
	}

	public static Date[] readDates(String date) {
		Queue<Date> dates = new Queue<Date>();
		In in = new In(date);

		while(!in.isEmpty())
			dates.enqueue(new Date(in.readString()));

		Date[] dateArr = new Date[dates.size()];

		int numberOfDates = dates.size();
		for(int i = 0; i < numberOfDates; i++)
			dateArr[i] = dates.dequeue();

		return dateArr;
	}

	public static int[] readInts(String name)
	{
		In in = new In(name);
		Queue<Integer> q = new Queue<Integer>();
		while (!in.isEmpty())
			q.enqueue(in.readInt());
		int N = q.size();
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = q.dequeue();
		return a;
	}
}