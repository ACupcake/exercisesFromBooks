public class Main {
	public static int twoEggsProblem(int[] building) {
		int buildingMaxFloor = building.length - 1;
		int floorJump = (int) Math.sqrt(buildingMaxFloor);
		int floor = floorJump;
		int eggThrows = 0;

		while(floor < buildingMaxFloor && building[floor] != 1){
			floor += floorJump;
			eggThrows++;
		}
		floor -= floorJump;

		while(building[floor] != 1) {
			eggThrows++;
			floor++;
		}

		System.out.println("Max tries expected: "+ (int)(2*Math.sqrt(buildingMaxFloor)) + " | in test: " + eggThrows);
		return floor;
	}

	public static int twoEggsProblem2(int[] building) {
		int buildingMaxFloor = building.length - 1;
		int floorJump = (int) Math.sqrt(buildingMaxFloor);
		int floor = floorJump;
		int eggThrows = 0;

		while(floor < buildingMaxFloor && building[floor] != 1){
			floor += floorJump + eggThrows;
			eggThrows++;
		}
		floor -= floorJump;

		while(building[floor] != 1) {
			eggThrows++;
			floor++;
		}

		System.out.println("Max tries expected: "+ (int)(2*Math.sqrt(buildingMaxFloor)) + " | in test: " + eggThrows);
		return floor;
	}
}