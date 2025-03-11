package part1.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashTableTwoSumFinder {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Indices are: " + Arrays.toString(twoSumFinder(numbers, target)));
    }

    // O(n)
    public static int[] twoSumFinder(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(numbers[i], i);
        }

        return null;
    }
}
