class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(checkTree(root));
    }

    public static int checkTree(TreeNode root) {
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        if (leftSum % 2 == 0 && rightSum % 2 != 0) {
            return 1;
        }
        return 0;
    }

    public static int sumTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sumTree(node.left) + sumTree(node.right);
    }
}