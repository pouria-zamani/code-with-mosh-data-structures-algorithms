package part3.sortingalgorithms;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] array) {
        if (array.length < 2)
            return;

        var mid = array.length / 2;

        int[] left = new int[mid];
        for (int i = 0; i < mid; i++)
            left[i] = array[i];

        int[] right = new int[array.length - mid];
        for (int i = mid; i < array.length; i++)
            right[i - mid] = array[i];

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 10, 8, 3, 14, 2, 5};
        var sorter = new MergeSort();
        sorter.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
