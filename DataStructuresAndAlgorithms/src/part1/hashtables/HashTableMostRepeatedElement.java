package part1.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashTableMostRepeatedElement {
    public static void main(String[] args) {
        int[] items = {1,2,3,3,4,1,1,2,4,4,4};
        System.out.println("Most element repeated in array " + Arrays.toString(items) + " is: " + mostRepeatedElement(items));
    }

    // O(n)
    public static int mostRepeatedElement(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        return result;
    }
}
