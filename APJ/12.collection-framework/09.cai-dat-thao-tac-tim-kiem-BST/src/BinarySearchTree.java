public class BinarySearchTree<E extends Comparable<E>> {
    private static class TreeNode<T> {
        protected T element;
        protected TreeNode<T> left;
        protected TreeNode<T> right;

        public TreeNode(T e) {
            element = e;
        }

        @Override
        public String toString() {
            return "{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private TreeNode<E> root;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void insert(E element) {
        TreeNode<E> newNode = new TreeNode<>(element);
        if (root == null)
            root = newNode;
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                parent = current;
                current = getNextNode(element, current);
            }

            choseBranchAndSetChildNode(parent, element, newNode);
        }
        size++;
    }

    private TreeNode<E> getNextNode(E element, TreeNode<E> current) {
        return (shouldGoRight(element, current.element)) ? current.right : current.left;
    }

    private boolean shouldGoRight(E element, E nodeElement) {
        return element.compareTo(nodeElement) > 0;
    }

    private void choseBranchAndSetChildNode(TreeNode<E> current, E elementToCompare, TreeNode<E> child) {
        if (shouldGoRight(elementToCompare, current.element)) {
            current.right = child;
        } else {
            current.left = child;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void remove(E element) {
        TreeNode<E> prev = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (current.element.equals(element)) break;
            prev = current;
            current = getNextNode(element, current);
        }
        handleRemoveNode(prev, current);
    }

    private void handleRemoveNode(TreeNode<E> parentNode, TreeNode<E> removingNode) {
        boolean nodeNotFount = removingNode == null;
        if (nodeNotFount) return;
        boolean removingNodeHasNoLeftChild = removingNode.left == null;
        if (removingNodeHasNoLeftChild) {
            handleRemovingNodeHasNoLeftChild(parentNode, removingNode);
        } else {
            handleRemovingNodeHasLeftChild(removingNode);
        }
        size--;
    }

    private void handleRemovingNodeHasNoLeftChild(TreeNode<E> parentNode, TreeNode<E> removingNode) {
        boolean isRemovingRootNode = parentNode == null;
        if (isRemovingRootNode) {
            root = removingNode.right;
        } else {
            choseBranchAndSetChildNode(parentNode, removingNode.element, removingNode.right);
        }
    }

    private void handleRemovingNodeHasLeftChild(TreeNode<E> removingNode) {
        TreeNode<E> parentNode = removingNode;
        TreeNode<E> rightmostNode = removingNode.left;
        while (rightmostNode.right != null) {
            parentNode = rightmostNode;
            rightmostNode = rightmostNode.right;
        }
        removingNode.element = rightmostNode.element;
        connectParentWithLeftChildOfRightMost(removingNode, parentNode, rightmostNode);
    }

    private void connectParentWithLeftChildOfRightMost(TreeNode<E> removingNode, TreeNode<E> parentNode, TreeNode<E> rightmostNode) {
        if (parentNode == removingNode) {
            parentNode.left = rightmostNode.left;
        } else {
            parentNode.right = rightmostNode.left;
        }
    }

    public void inorderTraversal() {
        if (!isEmpty()) inorderRecursion(root);
    }

    private void inorderRecursion(TreeNode<E> node) {
        if (node.left != null) inorderRecursion(node.left);
        System.out.println(node.element);
        if (node.right != null) inorderRecursion(node.right);
    }

    public void postorderTraversal() {
        if (!isEmpty()) postorderRecursion(root);
    }

    private void postorderRecursion(TreeNode<E> node) {
        if (node.left != null) postorderRecursion(node.left);
        if (node.right != null) postorderRecursion(node.right);
        System.out.println(node.element);
    }

    public void preorderTraversal() {
        if (!isEmpty()) preorderRecursion(root);
    }

    private void preorderRecursion(TreeNode<E> node) {
        System.out.println(node.element);
        if (node.left != null) preorderRecursion(node.left);
        if (node.right != null) preorderRecursion(node.right);
    }

    public boolean contains(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (current.element.equals(element)) return true;
            current = getNextNode(element, current);
        }
        return false;
    }

    public void printTree() {
        System.out.println("Tree structure: ");
        System.out.println(root);
    }
}
