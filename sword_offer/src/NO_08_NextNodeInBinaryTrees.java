public class NO_08_NextNodeInBinaryTrees {
    TreeLinkNode node;

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) {
            return null;
        }

        //有右子节点,中序遍历右子树的第一个值
        getFirst(pNode.right);
        if(node != null) {
            return node;
        }

        if(pNode.next == null) {
            return null;
        }

        //没有右子节点,且为父节点的左子树,父节点为下一节点
        if(pNode.right == null && judgePosition(pNode) == 0) {
            return pNode.next;
        }

        //没有右子节点,且为父节点的右子树,一直向上遍历父节点,直到找到自己是父节点的左子节点的节点,其父节点即为下一节点
        if(pNode.right == null && judgePosition(pNode) == 1) {
            TreeLinkNode parent = pNode.next;

            while(parent != null) {
                if(judgePosition(parent) == 0) {
                    return parent.next;
                }
                parent = parent.next;
            }
        }

        return null;
    }

    //中序遍历二叉树,只保留第一个遍历到的节点
    void getFirst(TreeLinkNode node) {
        if(node == null) {
            return;
        }
        getFirst(node.left);
        if(this.node == null) {
            this.node = node;
        }
        getFirst(node.right);
    }

    public int judgePosition(TreeLinkNode node) {
        if(node.next == null) {
            return -1;
        }
        TreeLinkNode parent = node.next;
        if(parent.left == node) {
            return 0;
        } else if(parent.right == node) {
            return 1;
        }
        return -1;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
