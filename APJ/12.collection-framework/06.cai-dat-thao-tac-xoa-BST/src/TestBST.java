public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Postorder: ");
        tree.postorderTraversal();
        System.out.println("The number of nodes is: " + tree.getSize());
        tree.printTree();
        // remove elements
        System.out.println("Remove Tom and George");
        tree.remove("Tom");
        tree.remove("George");
        System.out.println("Postorder: ");
        tree.postorderTraversal();
        System.out.println("The number of nodes is: " + tree.getSize());
        tree.printTree();
    }
}