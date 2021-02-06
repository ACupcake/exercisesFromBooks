public class Main{
	public static void main(String[] args){
		boolean[][] array = {{true, false}, {false, true}};
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				if(array[i][j] == true)
					System.out.print("*");
				else
					System.out.print(" ");
			}
		}

	}

}