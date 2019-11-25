import java.util.LinkedList;
import java.util.Queue;

public class NO_39_1_TreeDepth {
    public int TreeDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = TreeDepthRecursion(root.left);
        int right = TreeDepthRecursion(root.right);
        return left > right ? (left + 1) : (right + 1);
    }


    //非递归
    public int TreeDepth(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        //求深度,本质上还是需要广度遍历,所以需要用队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int depth = 0, count = 0, nextCount = 1;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }

            //count为这一层已经便利的个数, nextCount为这一层的节点个数, count == nextCount即代表这一层已被遍历完,深度可以+1
            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
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
