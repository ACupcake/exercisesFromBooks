public class Main {
    public static int  minIndexBinarySearch(int[] arr, int key, int min, int max) {
        int mid;
        int index = -1;

        while(max >= min) {
            mid = (max - min) / 2 + min;
        
            if(arr[mid] >= key) max = mid - 1;
            else if(arr[mid] <= key) min = mid + 1;
        
            if(arr[mid] == key) {
                if(index == -1)
                    index = mid;
                else if(mid < index)
                    index = mid;
            }
        }

        // if(index > 0 && arr[index - 1] == key)
            // index = index - 1;

        return index;
    }
}