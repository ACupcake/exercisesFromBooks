public class Main {
    public static void printIntsThatAppearBothArr(int[] arr1, int[] arr2) {
        int j = 0;
        for(int i = 0; i < arr1.length; i++) {
            while(i > 0 && arr1[i-1] == arr1[i])
                i++;
            while(j < arr2.length && i < arr1.length && arr2[j] <= arr1[i])
                j++;
            if(i < arr1.length && arr1[i] == arr2[j - 1])
                System.out.print(arr1[i] + " ");
            else if(j == 0 && arr1[i] == arr2[j])
                System.out.print(arr1[i] + " ");
        }
    }
}


    // public static void printIntsThatAppearBothArr(int[] arr1, int[] arr2) {
        // int arr1Index = 0;
        // int arr2Index = 0;
        // int temp = Integer.MAX_VALUE;
// 
        // while(arr1Index < arr1.length && arr2Index < arr2.length) {
            // if(arr1[arr1Index] < arr2[arr2Index]) {
                // arr1Index++;
            // } else if(arr1[arr1Index] > arr2[arr2Index]) {
                // arr2Index++;
            // } else {
                // if(arr1[arr1Index] != temp) {
                    // System.out.print(arr1[arr1Index] + " ");
                    // temp = arr1[arr1Index];
                // }
                // arr1Index++;
                // arr2Index++;        
            // }
        // }
    // }