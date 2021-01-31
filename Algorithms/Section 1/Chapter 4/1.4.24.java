public class Main {
	//lg(N)
	public static int findFloorLogN(int[] building, int lowerBoundFloor, int upperBoundFloor) {
		int maxFloor = upperBoundFloor;
		final int WILL_BREAK = 1;
		final int NOT_FOUND = -1;

		while(lowerBoundFloor <= upperBoundFloor) {
			int floor = (upperBoundFloor + lowerBoundFloor) / 2;
			if(building[floor] == WILL_BREAK) upperBoundFloor = floor - 1; 
			else if(floor < maxFloor - 1  && building[floor+1] == 1) return floor+1;
			else lowerBoundFloor = floor + 1;
		}
		return NOT_FOUND;
	}

	//2*log(F)
	public static int findFloor2LogF(int[] building) {
		int floor = 0;
		int power2 = 1;

		while(building[floor] != 1 && floor < building.length) {
			floor = 1 << power2;
			power2++;
		}

		int safeFloor = floor / 2;
		if(floor > building.length - 1)
			floor = building.length - 1;
        int newFloor = findFloorLogN(building, safeFloor + 1, floor - 1);

        if (newFloor == -1) {
            return floor;
        } else {
            return newFloor;
        }

	}

}