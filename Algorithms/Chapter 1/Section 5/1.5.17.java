public class ErdosRenyi {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		System.out.println("Connections generated: " + count(N));
	}

	public static int count(int N) {
		int connections = 0;
		while(connections != N - 1) {
			int p = (int) Math.random() * N;
			int q = (int) Math.random() * N;
			if(!unionFind.connected(p, q)) {
				unionFind.union(p, q);
				connections++;
				System.out.println("connection " + connections);
			}
		}
		return connections;
	}
}