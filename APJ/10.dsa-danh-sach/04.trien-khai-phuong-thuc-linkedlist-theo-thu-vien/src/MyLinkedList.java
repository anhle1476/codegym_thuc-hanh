public class MyLinkedList<E> {
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this(data);
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node<T> next() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private int numNodes = 0;

    public MyLinkedList() {}

    public MyLinkedList(E head) {
        addFirst(head);
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E object) {
        return indexOf(object) != -1;
    }

    private int indexOf(E object) {
        Node<E> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (object.equals(currentNode.getData())) return index;
            currentNode = currentNode.next();
            index++;
        }
        return -1;
    }

    public void addFirst(E element) throws IndexOutOfBoundsException{
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> prevHead = head;
            head = newNode;
            head.setNext(prevHead);
        }
        numNodes++;
    }

    public void addLast(E element) throws IndexOutOfBoundsException {
        add(numNodes, element);
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndexInRange(index, numNodes);
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            addFirst(element);
        } else {
            Node<E> prevNode = getNodeByIndex(index - 1);
            Node<E> nextNode = prevNode.next();
            prevNode.setNext(newNode);
            newNode.setNext(nextNode);
            numNodes++;
        }
    }

    private void checkIndexInRange(int index, int limit) throws IndexOutOfBoundsException {
        if (index < 0 || index > limit) throw new IndexOutOfBoundsException();
    }

    private Node<E> getNodeByIndex(int index) throws IndexOutOfBoundsException {
        checkIndexInRange(index, numNodes - 1);
        int count = 0;
        Node<E> currentNode = head;
        while (count < index && currentNode != null) {
            currentNode = currentNode.next();
            count++;
        }
        return currentNode;
    }

    public E remove(int index) throws IndexOutOfBoundsException{
        checkIndexInRange(index, numNodes - 1);
        Node<E> prevNode = getNodeByIndex(index - 1);
        Node<E> removingNode = prevNode.next();
        prevNode.setNext(removingNode.next());
        numNodes--;
        return removingNode.getData();
    }

    public E remove(E object) throws IndexOutOfBoundsException{
        int index = indexOf(object);
        if (index == -1) return null;
        return remove(index);
    }

    public void printList() {
        Node<E> currentNode = head;
        StringBuilder sb = new StringBuilder("LinkedList=[");
        while (currentNode != null) {
            sb.append(currentNode.getData().toString()).append(",");
            currentNode = currentNode.next();
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        System.out.println(sb.toString());
    }
}
