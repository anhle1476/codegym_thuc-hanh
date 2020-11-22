public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = 0;
    private int currentSize = 0;

    public MyQueue(int queueSize) throws UnsupportedOperationException {
        if (queueSize <= 0) throw new UnsupportedOperationException("Capacity must be greater than 0!");
        this.capacity = queueSize;
        queueArr = new int[queueSize];
    }

    public boolean isQueueFull() {
        return currentSize == capacity;
    }

    public boolean isQueueEmpty() {
        return currentSize == 0;
    }

    public void enqueue(int num) throws IndexOutOfBoundsException{
        if (isQueueFull()) throw new IndexOutOfBoundsException("Queue is full. Please dequeue first!");
        queueArr[tail] = num;
        tail = nextIndex(tail);
        currentSize++;
    }

    public Integer dequeue() {
        if (isQueueEmpty()) return null;
        int holder = queueArr[head];
        head = nextIndex(head);
        currentSize--;
        return holder;
    }

    private int nextIndex(int index) {
        return (index + 1) % capacity;
    }
}
