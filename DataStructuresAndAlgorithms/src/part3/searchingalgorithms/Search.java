package part3.searchingalgorithms;

import java.util.Arrays;

public class Search {
    public int linearSearch(int[] array, int target) {
        for (var i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public int binarySearchRec(int[] array, int target) {
        return binarySearchRec(array, target, 0, array.length - 1);
    }

    private int binarySearchRec(int[] array, int target, int left, int right) {

        if (right < left)
            return -1;

        int middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if (target < array[middle])
            return binarySearchRec(array, target, left, middle - 1);

        return binarySearchRec(array, target, middle + 1, right);
    }

    public int binarySearch(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }

    public int ternarySearch(int[] array, int target) {
        return ternarySearch(array, target, 0, array.length - 1);
    }

    private int ternarySearch(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (array[mid1] == target)
            return mid1;

        if (array[mid2] == target)
            return mid2;

        if (target < array[mid1])
            return ternarySearch(array, target, left, mid1 - 1);

        if (target > array[mid2])
            return ternarySearch(array, target, mid2 + 1, right);

        return ternarySearch(array, target, mid1 + 1, mid2 - 1);
    }

    public int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while (start < array.length &&
                array[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

        for (var i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public int exponentialSearch(int[] array, int target) {
        int bound = 1;
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return binarySearchRec(array, target, left, right);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 10, 8, 3, 14, 2, 5};
        int[] numbersSorted = {1, 2, 3, 5, 8, 10, 14};

        System.out.println(Arrays.toString(numbers));
        System.out.println("=============");

        var search = new Search();

        System.out.println("Index of 10 using linear search: " + search.linearSearch(numbers, 10));
        System.out.println("Index of 11 using linear search: " + search.linearSearch(numbers, 11));
        System.out.println("=============");

        System.out.println("Sorted array: " + Arrays.toString(numbersSorted));
        System.out.println("=============");

        System.out.println("Index of 10 using binary search: " + search.binarySearch(numbersSorted, 10));
        System.out.println("Index of 11 using binary search: " + search.binarySearch(numbersSorted, 11));
        System.out.println("=============");

        System.out.println("Index of 10 using binary search(recursive): " + search.binarySearch(numbersSorted, 10));
        System.out.println("Index of 11 using binary search(recursive): " + search.binarySearch(numbersSorted, 11));
        System.out.println("=============");

        System.out.println("Index of 10 using ternary search: " + search.ternarySearch(numbersSorted, 10));
        System.out.println("Index of 11 using ternary search: " + search.ternarySearch(numbersSorted, 11));
        System.out.println("=============");

        System.out.println("Index of 10 using jump search: " + search.jumpSearch(numbersSorted, 10));
        System.out.println("Index of 11 using jump search: " + search.jumpSearch(numbersSorted, 11));
        System.out.println("=============");

        System.out.println("Index of 10 using exponential search: " + search.exponentialSearch(numbersSorted, 10));
        System.out.println("Index of 11 using exponential search: " + search.exponentialSearch(numbersSorted, 11));
        System.out.println("=============");
    }
}
