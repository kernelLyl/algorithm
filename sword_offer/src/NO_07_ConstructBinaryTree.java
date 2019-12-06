import java.util.Arrays;

public class NO_07_ConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int[] preLeft, preRight, inLeft, inRight;

        if(pre.length == 0 || in.length == 0) {
            return null;
        }

        int root = pre[0];

        TreeNode node = new TreeNode(root);


        for(int i = 0; i < in.length; i ++) {
            if(in[i] == root) {
                inLeft = Arrays.copyOfRange(in, 0, i);
                inRight = Arrays.copyOfRange(in, i+1, in.length);
                preLeft = Arrays.copyOfRange(pre, 1, i + 1);
                preRight = Arrays.copyOfRange(pre, i + 1, pre.length);
                node.left = reConstructBinaryTree(preLeft, inLeft);
                node.right = reConstructBinaryTree(preRight, inRight);
                break;
            }
        }
        return node;
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

