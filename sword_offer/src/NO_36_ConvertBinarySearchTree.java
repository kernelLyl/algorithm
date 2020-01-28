public class NO_36_ConvertBinarySearchTree {
    TreeNode head = null;
    TreeNode tail = null;

    //相当于中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null)
            return null;

        Convert(pRootOfTree.left);

        if(head == null) {
            head = tail = pRootOfTree;
        }
        else {
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
            tail = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return head;
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