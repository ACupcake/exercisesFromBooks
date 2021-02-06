public class Main {
	public static void main(String[] args) {
	}

	public static Date[] readDates(String transaction) {
		Queue<Transaction> transactions = new Queue<Transaction>();
		In in = new In(transaction);

		while(!in.isEmpty())
			transactions.enqueue(new Transaction(in.readLine()));

		Transaction[] transactionArr = new Transaction[transactions.size()];

		int numberOfTransactions = transactions.size();
		for(int i = 0; i < numberOfTransactions; i++)
			transactionArr[i] = transactions.dequeue();

		return transactionArr;
	}
}