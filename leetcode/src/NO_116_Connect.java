import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class NO_116_Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> queue = new LinkedList<>();

        queue.addLast(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i ++) {
                Node temp = queue.removeFirst();

                if (i < size - 1) {
                    temp.next = queue.peekFirst();
                }

                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }

            }
        }
        return root;
    }

    public static final String REGEX_REALNAME = "^[\\u4e00-\\u9fa5]+(•[\\u4e00-\\u9fa5]*)*$|^[\\u4e00-\\u9fa5]+(·[\\u4e00-\\u9fa5]*)*$";

    public static void main(String[] args) {

        System.out.println(Pattern.matches(REGEX_REALNAME, "所"));


    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
