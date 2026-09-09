import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class findSuccesor {
    public TreeNode findSuccesor(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode cn = q.pollFirst();
            int cv = cn.val;
            if (cn.left != null) {
                q.addLast(cn.left);
            }
            if (cn.right != null) {
                q.addLast(cn.right);
            }
            if (cv == x) {
                return q.pollFirst();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        findSuccesor solution = new findSuccesor();

        TreeNode result1 = solution.findSuccesor(root, 2);
        System.out.println("Successor of 2: " + (result1 != null ? result1.val : "null"));

        TreeNode result2 = solution.findSuccesor(root, 3);
        System.out.println("Successor of 3: " + (result2 != null ? result2.val : "null"));

        TreeNode result3 = solution.findSuccesor(root, 5);
        System.out.println("Successor of 5: " + (result3 != null ? result3.val : "null"));
    }
}