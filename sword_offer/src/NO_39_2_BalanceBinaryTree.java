public class NO_39_2_BalanceBinaryTree {
    int getHeight(TreeNode node){
        if(node == null)
            return 0;
        int left = getHeight(node.left); //求左子树的高度
        if(left == -1) return -1; //求左子树的高度的时候发现了该节点不平衡
        int right = getHeight(node.right);
        if(right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right); //求该节点的高度
    }
    boolean IsBalanced_Solution(TreeNode pRoot) {
        return getHeight(pRoot) != -1;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
