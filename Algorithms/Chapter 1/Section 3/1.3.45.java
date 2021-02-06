public class Main{
	public static boolean isStackPermutationValid(int[] numbers) {
		Stack<Integer> stack = new Stack<Integer>();
		int number = 0;
		int arrPos = 0;

		stack.push(number);

		while(number++ != numbers.length) {
			int temp = -1;

			if(!stack.isEmpty()) {
				temp = stack.pop();
				stack.push(temp);
			}

			if(temp == numbers[arrPos])
				stack.pop();
			else if(temp < numbers[arrPos])
				stack.push(number);
			else
				return false;
			arrPos++;
		}
		return true;
	}

	public static boolean stackWillUnderflow(String[] characters) {
		int count = 0;

		for(String character: characters) {
			if(character.equals("-"))
				count--;
			else
				count++;

			if(count < 0)
				return true;				
		}
		return false;
	}
}