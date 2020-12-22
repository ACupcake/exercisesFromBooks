import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
        int inputs = 0;
		int[] integer1 = new int[50];
		int[] integer2 = new int[50];
		String[] name = new String[50];
		Scanner scanner = new Scanner(System.in);

		for(int i = 0; scanner.hasNextLine(); i++) {
			name[i] = scanner.nextLine();
			String[] separate = name[i].split(" ");
			name[i] = separate[0];
			integer1[i] = Integer.parseInt(separate[1]);
			integer2[i] = Integer.parseInt(separate[2]);
			inputs++;
		}

		for(int i = 0; i < inputs; i++) {
			System.out.printf("%s %d %d %.3f\n", name[i], integer1[i], integer2[i], (double) integer1[i]/integer2[i]);
		}
	}
}