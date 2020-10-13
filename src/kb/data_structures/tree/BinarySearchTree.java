package kb.data_structures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * A classical implementation of BST. Supports the following operations: 
 * - {@link #insert(V)} 
 * - {@link #search(V)}
 * - {@link #delete(V)}
 * - {@link #rangeView(V, V)}
 * - {@link #postorderView()}
 * - {@link #postorderView()}
 * - {@link #inorderView()}
 * - {@link #isEmpty()}
 * - {@link #toString()}
 * 
 * @param <V>
 * 
 * @author dimcho.nedev
 */
public class BinarySearchTree<V extends Comparable<V>> {
    private TreeNode root = null;

    /*
     * Recursive structure that represents the Node of the tree. Contains a value
     * and references to the left and right subtree.
     */
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private V val;

        public TreeNode(V val) {
            this.val = val;
        }
    }

    /**
     * Inserts an element to the BST.
     * 
     * @param value the value to be inserted
     */
    public void insert(V value) {
        root = insertRecursively(root, value);
    }

    private TreeNode insertRecursively(TreeNode root, V value) {
        if (root == null)
            return new TreeNode(value);

        if (value.compareTo(root.val) < 0) {
            root.left = insertRecursively(root.left, value);
        } else if (value.compareTo(root.val) > 0)
            root.right = insertRecursively(root.right, value);

        return root;
    }

    /**
     * Searches for a certain value in the BST.
     * 
     * @param value
     * @return whether the value is found
     */
    public boolean search(V value) {
        return searchRecursively(root, value);
    }

    private boolean searchRecursively(TreeNode root, V value) {
        if (root == null)
            return false;

        if (root.val.equals(value))
            return true;

        if (value.compareTo(root.val) < 0)
            return searchRecursively(root.left, value);
        else if (value.compareTo(root.val) > 0)
            return searchRecursively(root.right, value);

        return false;
    }

    /**
     * Deletes a value from the BST
     * 
     * @param value a value to be deleted
     */
    public void delete(V value) {
        root = deleteNode(root, value);
    }

    private TreeNode deleteNode(TreeNode root, V value) {
        if (root == null || root.val == value && root.left == null && root.right == null) {
            // Case 1. The node is leaf
            return null;
        }
        if (root.val.compareTo(value) > 0)
            root.left = deleteNode(root.left, value);
        else if (root.val.compareTo(value) < 0)
            root.right = deleteNode(root.right, value);
        else if (root.right == null)
            // Case 2. the node has left child
            return root.left;
        else if (root.right == null)
            // Case 2. the node has right child
            return root.right;
        else {
            // Case 3. The node has two children
            TreeNode curr = root;
            curr = curr.right;
            // Finds the closest bigger node
            while (curr.left != null)
                if (curr.left != null)
                    curr = curr.left;
            // Assign the closest value and delete the closest node (Case 1 or Case 2)
            root.val = curr.val;
            root.right = deleteNode(root.right, curr.val);
        }

        return root;
    }

    /**
     * A {@link List} with sorted values that are in closed interval [from, to].
     * 
     * @param from lower bound
     * @param to   high bound
     * @return sorted {@link List}
     */
    private List<V> rangeView(V from, V to) {
        List<V> view = new ArrayList<>();
        calcRange(root, from, to, view);
        return view;
    }

    private void calcRange(TreeNode root, V from, V to, List<V> view) {
        if (root == null)
            return;

        calcRange(root.left, from, to, view);
        if (root.val.compareTo(to) <= 0 && root.val.compareTo(from) >= 0)
            view.add(root.val);
        calcRange(root.right, from, to, view);
    }

    /**
     * Creates an inorder view of the BST.
     * 
     * @return a {@link List} with inorder view
     */
    public List<V> inorderView() {
        List<V> view = new ArrayList<>();
        inorder(root, view);
        return view;
    }

    private void inorder(TreeNode root, List<V> view) {
        if (root != null) {
            inorder(root.left, view);
            view.add(root.val);
            inorder(root.right, view);
        }
    }

    /**
     * Creates an preorder view of the BST
     * 
     * @return a {@link List} with preorder view
     */
    public List<V> preorderView() {
        List<V> view = new ArrayList<>();
        preorder(root, view);
        return view;
    }

    private void preorder(TreeNode root, List<V> view) {
        if (root != null) {
            view.add(root.val);
            preorder(root.left, view);
            preorder(root.right, view);
        }
    }

    /**
     * Creates an postorder view of the BST
     * 
     * @return a {@link List} with postorder view
     */
    public List<V> postorderView() {
        List<V> view = new ArrayList<>();
        postorder(root, view);
        return view;
    }

    private void postorder(TreeNode root, List<V> view) {
        if (root != null) {
            preorder(root.left, view);
            preorder(root.right, view);
            view.add(root.val);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        // The default representation is the inorder view
        return inorderView().toString();
    }

}
