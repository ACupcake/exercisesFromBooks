//I did not manage to complete :/

public class Main {

	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8,9,10};

		int[] arr = binarySearchForFraction(array, 0.75);

		if(arr != null)
			System.out.println(arr[0] + " " + arr[1]);
		else
			System.out.println("nao");
	}

	public static int[] binarySearchForFraction(int[] arr, double fraction) {
		double p = arr[arr.length - 1];
		double q = arr[arr.length - 1];

		int pMax = arr.length - 1;
		int pMin = 0;
		int qMax = arr.length - 1;
		int qMin = 0;
		int pIndex = arr.length - 1;
		int qIndex = arr.length - 1;

		while(p/q > fraction) {
			int newPIndex = (pMin + pMax) / 2;
			System.out.println(p + " " + q);

			// if(newPIndex == pIndex)
				// return null;
			if(Math.abs(((double)arr[newPIndex])/q - fraction) <= Math.abs(p/q - fraction)) {
				pIndex = newPIndex;
				p = arr[newPIndex];
				pMin = newPIndex;
			}
			else {
				pMax = newPIndex;
			}

			//{1,2,3,4,5,6,7,8,9,10}; 4 2 1
			int newQIndex = (qMax + qMin) / 2;

			// if(newQIndex == qIndex) {
				// return null;
			// }
			if(Math.abs(p/((double)arr[newQIndex]) - fraction) <= Math.abs(p/q - fraction)) {
				qIndex = newQIndex;
				q = arr[newQIndex];
				qMin = newQIndex;
			}
			else {
				qMax = newQIndex;
			}
			// System.out.println(arr[pIndex] + " " + pIndex + " " + arr[qIndex] + " " + qIndex);
			// System.out.println(pMax + " " + pMin + " " + qMax + " " +  qMin);
			// System.out.println();
		}
	
		if(p / q == fraction) {
			int[] result = {(int) p, (int) q};
			return result;
		}
		return null;
	}

}
