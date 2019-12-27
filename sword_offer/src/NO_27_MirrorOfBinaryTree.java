import java.util.LinkedList;

public class NO_27_MirrorOfBinaryTree {
    //递归
    public void Mirror(TreeNode root) {
        if(root == null) {
            return ;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //非递归,利用队列层次遍历,每弹出一个节点,交换其子节点,同时将其子节点入队列
    public void mirrorDeque(TreeNode root) {
        if(root == null) {
            return ;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null)
                queue.addLast(node.left);
            if(node.right != null)
                queue.addLast(node.right);
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
