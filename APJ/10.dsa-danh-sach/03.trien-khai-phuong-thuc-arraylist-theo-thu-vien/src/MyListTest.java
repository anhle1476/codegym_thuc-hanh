public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("add 1->5: " + list);
        System.out.println("size: " + list.size());
        list.remove(1);
        System.out.println("remove index 1: " + list);
        System.out.println("size: " + list.size());
        System.out.println("get index 3: " + list.get(3));
        System.out.println("contain 5: " + list.contains(5));
        System.out.println("indexOf 5: " + list.indexOf(5));
        System.out.println("contain 6: " + list.contains(6));
        System.out.println("indexOf 6: " + list.indexOf(6));
        System.out.println("clone: " + list.clone());
        list.ensureCapacity(20);
        System.out.println("ensure capacity 20: \n" + list);
    }
}
