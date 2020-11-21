public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.addFirst(0);
        list.addLast(3);
        list.printList();
        System.out.println("size: " + list.size());
        System.out.println("contain 2: " + list.contains(2));
        System.out.println("index of 1: " + list.contains(1));
        list.remove(2);
        list.printList();
        System.out.println("size: " + list.size());
    }
}
