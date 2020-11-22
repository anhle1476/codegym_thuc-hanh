public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue<String> queue = new CircularQueue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        queue.enqueue("five");
        System.out.println("Dequeue elements: ");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
