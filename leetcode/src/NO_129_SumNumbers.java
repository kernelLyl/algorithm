public class NO_129_SumNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }

        int val = preSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return val;
        } else {
            return dfs(root.left, val) + dfs(root.right, val);
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
