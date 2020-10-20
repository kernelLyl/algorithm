import java.util.Deque;
import java.util.LinkedList;

public class NO_143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Deque<ListNode> deque = new LinkedList<>();

        ListNode next = head.next;

        while (next != null) {
            deque.addLast(next);
            next = next.next;
        }

        while (!deque.isEmpty()) {
            head.next = deque.removeLast();
            head = head.next;

            if (!deque.isEmpty()) {
                head.next = deque.removeFirst();
                head = head.next;
            }
        }

        head.next = null;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
