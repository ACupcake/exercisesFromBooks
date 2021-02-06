/* 
 *	Not completed, it's necessary to implement a array 
 *	to save the lines generated and verify if the 2d
 *	intervals are contained.
*/

public class Main {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Double min = Double.parseDouble(args[1]) / 10;
		Double max = Double.parseDouble(args[2]) / 10;
		double random1;
		double random2;		
		Interval2D[] intervals = new Interval2D[N];


		for(int i = 0; i < N; i++) {
			random1 = StdRandom.uniform(min, max);
			random2 = StdRandom.uniform(min, max);
			Interval1D firstInterval;
			Interval1D secondInterval;
			if(random1 > random2)
				firstInterval = new Interval1D(random2, random1);
			else
				firstInterval = new Interval1D(random1, random2);

			random1 = StdRandom.uniform(min, max);
			random2 = StdRandom.uniform(min, max);
			if(random1 > random2)
				secondInterval = new Interval1D(random2, random1);
			else
				secondInterval = new Interval1D(random1, random2);
			
			intervals[i] = new Interval2D(firstInterval, secondInterval);
			intervals[i].draw();
		}

		int intersects = 0;
		// int contains = 0;
		for(int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				else if(intervals[i].intersects(intervals[j]))
					intersects++;
			}
		}

		StdOut.println("Intersects: " + intersects);
		// StdOut.println("Contains: " + contains);


	}

}