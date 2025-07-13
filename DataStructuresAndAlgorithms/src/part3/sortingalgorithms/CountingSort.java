package part3.sortingalgorithms;

import java.util.Arrays;

public class CountingSort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1];
        for (var item : array)
            counts[item]++;

        var k = 0;
        for (var i = 0; i < counts.length; i++)
            for (var j = 0; j < counts[i]; j++)
                array[k++] = i;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 10, 8, 3, 14, 2, 5};
        var sorter = new CountingSort();
        sorter.sort(numbers, 14);

        System.out.println(Arrays.toString(numbers));
    }
}
