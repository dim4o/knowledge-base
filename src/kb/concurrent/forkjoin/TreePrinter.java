package kb.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class TreePrinter extends RecursiveAction {

    private final TreeNode root;

    public TreePrinter(TreeNode root) {
        this.root = root;
    }

    @Override
    protected void compute() {
        if (root == null)
            return;
        TreePrinter left = new TreePrinter(root.left);
        TreePrinter right = new TreePrinter(root.right);
        left.fork();
        right.fork();
        System.out.println(root.val);
        left.join();
        right.join();
    }
    
    private static final class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n0.left = n1;
        n0.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;

        ForkJoinPool fjPool = new ForkJoinPool(4);
        TreePrinter forkJoinTask = new TreePrinter(n0);
        fjPool.submit(forkJoinTask).join();
    }

}
