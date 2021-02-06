public class RandomGrid {
	private class Connection {
		int p;
		int q;

		public Connection(int p, int q) {
			this.p = p; this.q = q;
		}
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Connection[] connections = generate(N);

		for(int i = 0; i < N; i++)
			System.out.println(connections[i].p + " " + connections[i].q);
	}

	public static Connection[] generate(int N) {
		RandomBag<Connection> randomConnection = new RandomBag<>();

		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				Connection connection = new Connection(i, j);
				randomConnection.add(connection);
			}
		}

        Connection[] connections = new Connection[randomBag.size()];

        int index = 0;
        for(Connection connection : randomBag) {
            connections[index++] = connection;
        }
        return connections;
	}
}