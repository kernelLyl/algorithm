import java.util.*;

public class NO_103_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int n = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> deque = new LinkedList();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if (n % 2 == 0) {
                    deque.addLast(node.val);
                } else {
                    deque.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add((List)deque);
            n ++;
        }
        return ans;

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
