package part1.linkedlists;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //addFirst
    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }

        size++;
    }

    //addLast
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    //removeFirst
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (head == tail)
            head = tail = null;
        else {
            var second = head.next;
            head.next = null;
            head = second;
        }

        size--;
    }

    //removeLast
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (head == tail)
            head = tail = null;
        else {
            tail = getPrevious(tail);
            tail.next = null;
        }

        size--;
    }

    //contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    //indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = head;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = head;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = head;
        var current = head.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        tail = head;
        tail.next = null;
        head = previous;
    }

    public int getKthFromEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = head;
        var b = head;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != tail) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        var slow = head;
        var fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == tail)
            System.out.println(slow.value);
        else
            System.out.println(slow.value + ", " + slow.next.value);
    }

    public boolean hasLoop() {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        var node = list.tail;

        list.addLast(40);
        list.addLast(50);

        list.tail.next = node;

        return list;
    }

    public static void main(String[] args) {
        var linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addFirst(11);
        linkedList.addLast(20);
        linkedList.addLast(30);

        System.out.println("index of 20: " + linkedList.indexOf(20));
        System.out.println("index of 11: " + linkedList.indexOf(11));
        System.out.println("index of 21: " + linkedList.indexOf(21));

        System.out.println("linkedlist contains 10: " + linkedList.contains(10));
        System.out.println("linkedlist contains 12: " + linkedList.contains(12));

        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println("index of 10 after removes: " + linkedList.indexOf(10));
        System.out.println("index of 20 after removes: " + linkedList.indexOf(20));

        System.out.println("size of the linkedlist: " + linkedList.size());

        System.out.println("array: " + Arrays.toString(linkedList.toArray()));

        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.reverse();
        System.out.println("reversed linkedlist after adding 30, 40: " + Arrays.toString(linkedList.toArray()));

        System.out.println("2th from the end: " + linkedList.getKthFromEnd(2));

        System.out.println("Middle items: ");
        linkedList.printMiddle();

        System.out.println("linked list has loop(t/f): " + linkedList.hasLoop());
        System.out.println("linked list has loop(t/f) (which has): " + LinkedList.createWithLoop().hasLoop());

    }
}
