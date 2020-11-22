public class CircularQueue<E> {
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> next() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private int size = 0;
    private Node<E> front = null;
    private Node<E> rear = null;

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        updateRearPointer();
        size++;
    }

    public E dequeue() {
        if (isEmpty()) return null;
        Node<E> holder = front;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next();
            updateRearPointer();
        }
        size--;
        return holder.getData();
    }


    private void updateRearPointer() {
        rear.setNext(front);
    }
}
