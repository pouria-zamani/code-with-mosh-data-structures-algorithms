package part1.arrays;

public class Array {
    private int[] items;
    private int count = 0;

    public Array(int size) {
        items = new int[size];
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    public void insert(int item) {
        resizeIfRequired();

        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 && index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public int max() {
        int maxItem = items[0];

        for (int i = 0; i < count; i++) {
            if (items[i] > maxItem)
                maxItem = items[i];
        }

        return maxItem;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        return intersection;
    }

    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];

        items = newItems;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.removeAt(0);
        System.out.println("Array items: ");
        array.print();
        System.out.println("Index of Item 20: " + array.indexOf(20));
        System.out.println("Index of Item 5: " + array.indexOf(5));

        System.out.println("Max Item: " + array.max());

        var secondArray = new Array(4);
        secondArray.insert(10);
        secondArray.insert(20);
        secondArray.insert(25);
        secondArray.insert(35);
        System.out.println("Second Array items: ");
        secondArray.print();

        System.out.println("Common items in part1.arrays: ");
        array.intersect(secondArray).print();

        array.reverse();
        System.out.println("Reversed array: ");
        array.print();


        array.insertAt(34, 2);
        System.out.println("Array items after insertion at index 2: ");
        array.print();
    }
}
