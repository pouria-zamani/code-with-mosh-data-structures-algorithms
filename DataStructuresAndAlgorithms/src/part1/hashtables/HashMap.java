package part1.hashtables;

import java.util.Arrays;

public class HashMap {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private Entry[] entries = new Entry[5];
    private int count;

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        if (isFull())
            throw new IllegalStateException();

        entries[getIndex(key)] = new Entry(key, value);
        count++;
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public void remove(int key) {
        var index = getIndex(key);
        if (index == -1 || entries[index] == null)
            return;

        entries[index] = null;
        count--;
    }

    public int size() {
        return count;
    }

    private Entry getEntry(int key) {
        var index = getIndex(key);
        return index >= 0 ? entries[index] : null;
    }

    private int getIndex(int key) {
        int steps = 0;

        while (steps < entries.length) {
            int index = index(key, steps++);
            var entry = entries[index];
            if (entry == null || entry.key == key)
                return index;
        }

        return -1;
    }

    private boolean isFull() {
        return count == entries.length;
    }

    private int index(int key, int i) {
        return (hash(key) + i) % entries.length;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    public static void main(String[] args) {
        HashMap hashTable = new HashMap();
        hashTable.put(6, "A");
        hashTable.put(8, "B");
        hashTable.put(11, "C");
        hashTable.put(6, "AA");

        System.out.println("value of 6: " + hashTable.get(6));

        hashTable.remove(6);
        System.out.println("value of 6 after remove: " + hashTable.get(6));

    }
}
