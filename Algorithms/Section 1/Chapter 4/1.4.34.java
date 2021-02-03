public class HotOrCold {
	private int target;

	public static void main(String[] args) {
		HotOrCold hotOrCold = new HotOrCold();

		hotOrCold.setTarget(49);
		System.out.println(hotOrCold.findNumber(100));
	}

	//consider ]a,b[
	public int findNumber(int N) {
		int previousGuess = 1;
		int guess = 2;
		int min = 1;
		int max = N;

		while(guess != previousGuess) {
			if(isTarget(guess)) {
				return guess;
			}
			else if(isHot(guess, previousGuess)) {
				if(isHot(guess+1, guess)) {
					min = guess;
				} else {
					max = guess;
				}
			} else {
				if(guess > previousGuess) {
					max = guess;
				} else {
					min = guess;
				}
			}
			previousGuess = guess;
			guess = (max + min) / 2;
		}

		return -1;
	}

	public boolean isTarget(int guess) {
		return guess == this.target;
	}

	public boolean isHot(int guess, int previousGuess) {
		if(Math.abs(guess - this.target) < Math.abs(previousGuess - this.target))
			return true;
		return false;
	}

	public void setTarget(int target) {
		this.target = target;
	}
}