import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // int[] pairs = {1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2 ,5, 6, 7, 7, 8, 2, 1, 2, 4, 5};
        int[] pairs = {1,1,1,1};
        System.out.println(countPairs(pairs));
    }

    //O(n*log(n))
    public static int countPairs(int[] pairs) {
        int count = 0;
        int frequencyOfNumber = 1;

        Arrays.sort(pairs);

        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i - 1] == pairs[i]) {
                frequencyOfNumber++;
            } else {
                count += (frequencyOfNumber - 1) * frequencyOfNumber / 2;
                frequencyOfNumber = 1;
            }
        }

        count += (frequencyOfNumber - 1) * frequencyOfNumber / 2;
        return count;
    }

    //O(n)
    public static int countPairs2(int[] pairs) {
        int count = 0;
        Map<Integer, Integer> hashTable = new HashMap<>;

        for(int i = 0; i < pairs.length; i++) {
            int count = 0;
            if(hashTable.containsKey(pairs[i]))
                count = hashTable.get(pairs[i]);
            count++;
            hashTable.put(pairs[i], count);
        }

        for(int key: hashTable.keySet()) {
            if(hashTable.get(key) > 1) {
                int frequencyOfNumber = hashTable.get(key);
                count += (frequencyOfNumber - 1) * frequencyOfNumber / 2;
            }
        }
        return count;
    }

}