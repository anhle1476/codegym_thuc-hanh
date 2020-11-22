public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        System.out.println("is empty: " + queue.isQueueEmpty());
        System.out.println("add 1 -> 10");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enqueue " + i);
            queue.enqueue(i);
        }
        System.out.println("is full: " + queue.isQueueFull());
        System.out.println("Dequeue 1, 2 -> Enqueue 11, 12");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(11);
        queue.enqueue(12);

        while (!queue.isQueueEmpty()) {
            System.out.println("Dequeue " + queue.dequeue());
        }
    }
}
