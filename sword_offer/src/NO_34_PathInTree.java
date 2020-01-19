import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NO_34_PathInTree {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) {
            return result;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        findPath(root, stack, target, 0);
        return result;
    }

    public void findPath(TreeNode root, LinkedList<Integer> stack, int target, int current) {
        stack.addLast(root.val);
        if((current + root.val) == target && root.left == null && root.right == null) {
            result.add(new ArrayList<>(stack));
            stack.removeLast();
            return;
        }
        if(root.left != null)
            findPath(root.left, stack, target, current + root.val);
        if(root.right != null)
            findPath(root.right, stack, target, current + root.val);
        stack.removeLast();
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
