import java.util.*;

public class Test {
    public static void main(String[] args) {
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int n = 0;
        List<List<Integer>> ans = new ArrayList();
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
        }
        return ans;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
