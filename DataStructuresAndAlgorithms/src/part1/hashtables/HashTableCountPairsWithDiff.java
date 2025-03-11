package part1.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTableCountPairsWithDiff {
    public static void main(String[] args) {
        int[] numbers = {1, 7, 5, 9, 2, 12, 3};
        System.out.println("Count of Pairs with Difference of 2 in array " + Arrays.toString(numbers) + " is: " + countPairsWithDiff(numbers, 2));
    }

    //O(n)
    public static int countPairsWithDiff(int[] numbers, int difference) {
        Set<Integer> set = new HashSet<>();
        for (var number : numbers)
            set.add(number);

        var count = 0;
        for (var number : numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }

        return count;
    }

}
