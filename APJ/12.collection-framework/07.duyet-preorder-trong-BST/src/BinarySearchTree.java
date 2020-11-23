public class BinarySearchTree<E extends Comparable<E>> {
    private class TreeNode<T> {
        protected T element;
        protected TreeNode<T> left;
        protected TreeNode<T> right;

        public TreeNode(T e) {
            element = e;
        }
    }

    private TreeNode<E> root;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void insert(E data) {
        TreeNode<E> newNode = new TreeNode<>(data);
        if (root == null)
            root = newNode;
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                parent = current;
                if (shouldGoRight(data, current.element)) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }

            if (shouldGoRight(data, parent.element)) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
        size++;
    }

    private boolean shouldGoRight(E data, E nodeElement) {
        return data.compareTo(nodeElement) > 0;
    }

    public void postorderTraversal() {
        if (!isEmpty()) postorder(root);
    }

    private void postorder(TreeNode<E> node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        System.out.println(node.element);
    }

    public boolean isEmpty() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return true;
        }
        return false;
    }
}
