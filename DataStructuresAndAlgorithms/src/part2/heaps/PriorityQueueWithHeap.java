package part2.heaps;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap();

    // O(log n)
    public void enqueue(int item) {
        heap.insert(item);
    }

    // O(log n)
    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        var priorityQueue = new PriorityQueueWithHeap();
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(2);

        System.out.println(priorityQueue.heap.toString());

        System.out.println(priorityQueue.dequeue());

        System.out.println(priorityQueue.heap.toString());
    }
}