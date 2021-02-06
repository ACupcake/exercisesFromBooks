public class Main {
    //Beter approaches
    //http://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf
    //https://stackoverflow.com/questions/10063289/find-a-local-minimum-in-a-2-d-array
    //https://stackoverflow.com/questions/18525179/find-local-minimum-in-n-x-n-matrix-in-on-time/24461101#24461101



    //explanation why mine is O(n²) and how to do a O(n) version
    //https://www.baeldung.com/cs/local-minimum-in-n-x-n-matrix
    
    //New version O(n)
    public static int localMinimumMatrix2(int[][] arr) {
    	return Find_Local_Minimum(arr, 0, 0, arr.length, arr[0].length);
    }

    public static int Find_Local_Minimum(int[][] arr, int minRows, int minColumns, int maxRows, int maxColumns){
    	int middle_row = maxRows / 2;
    	int middle_column = maxColumns / 2;
    	
    	int min_in_row = Get_Min_In_Row(arr, middle_row, middle_column);
    	int min_in_column = Get_Min_In_Column(arr, middle_row, middle_column);

    	int min_cell = arr[min_in_row][min_in_column];
    	int next_cell = Get_Next_Cell(arr, min_in_row, min_in_column);

    	if(next_cell == min_cell) {
    		return min_cell;
    	}
    	else if(min_in_row < middle_row) {
    		if(min_in_column < middle_column)
    			return Find_Local_Minimum(arr, minRows, minColumns, middle_row, middle_column);
    		else
    			return Find_Local_Minimum(arr, minRows, middle_column, middle_row, maxColumns);
    	}
    	else {
    		if(min_in_column < middle_column)
    			return Find_Local_Minimum(arr, middle_row, minColumns, maxRows, middle_column);
    		else
    			return Find_Local_Minimum(arr, middle_row, middle_column, maxRows, maxColumns);
    	}
    }

    public static int Get_Min_In_Row(int arr[][], int middle_row, int middle_column) {
    	int min = arr[middle_row][middle_column];
    	int minRowIndex = middle_row;

    	for(int i = 0; i < arr[0].length; i++) {
    		if(arr[middle_row][i] < min) {
    			min = arr[middle_row][i];
    		}
    	}

    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i][middle_column] < min) {
    			min = arr[i][middle_column];
    			minRowIndex = i;
    		}
    	}

    	return minRowIndex;
    }

    public static int Get_Min_In_Column(int arr[][], int middle_row, int middle_column) {
    	int min = arr[middle_row][middle_column];
    	int minColumnIndex = middle_column;
    	
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i][middle_column] < min) {
    			min = arr[i][middle_row];
    		}
    	}

    	for(int i = 0; i < arr[0].length; i++) {
    		if(arr[middle_row][i] < min) {
    			min = arr[middle_row][i];
    			minColumnIndex = i;
    		}
    	}

    	return minColumnIndex;
    }


    public static int Get_Next_Cell(int[][] arr, int row, int column) {
    	int next = arr[row][column];
		
		if(row != 0 && next > arr[row-1][column])
			next = arr[row-1][column];
		
		if(row != arr.length-1 && next > arr[row+1][column])
			next = arr[row+1][column];

		if(column != 0 && next > arr[row][column-1])
			next = arr[row][column-1];
		
		if(column != arr.length-1 && next > arr[row][column+1])
			next = arr[row][column+1];
	
		return next;
    } 






//==========================================





    //Mine is O(n²) in worst case :(
    //Just find the smallest adjacent neighbor and follow it
	public static int localMinimumMatrix(int[][] arr) {
		int line = 0;
		int column = 0;

		if(arr == null)
			throw new RuntimeException("Matrix is null.");

		if(arr.length != arr[0].length)
			throw new RuntimeException("Matrix is not squared.");

		int iteracoes = 0;

		while(!isBorder(arr, line, column) && !isMinimum(arr, line, column)) {
			iteracoes++;
			if(column < arr.length - 1 && arr[line][column] > arr[line][column+1])
				column++;
			else if(line < arr.length - 1 && arr[line][column] > arr[line+1][column])
				line++;
			else if(column > 0 && arr[line][column] > arr[line][column-1])
				column--;
			else if(line > 0 && arr[line][column] > arr[line-1][column])
				line--;
		}
		return arr[line][column];
	}


	public static boolean isMinimum(int[][] arr, int line, int column) {
		//verify if in line is minimum 
		if(line != 0 && arr[line][column] > arr[line-1][column])
			return false;
		if(line != arr.length-1 && arr[line][column] > arr[line+1][column])
			return false;

		//verify if in column is minimum 
		if(column != 0 && arr[line][column] > arr[line][column-1])
			return false;
		if(column != arr.length-1 && arr[line][column] > arr[line][column+1])
			return false;
	
		return true;
	} 

	public static boolean isBorder(int[][] arr, int line, int column) {
		return line == arr.length && column == arr.length;
	}

}