public class NO_24_SwapPairs {

    // 非递归
    public ListNode swapPairs(ListNode head) {


        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode end = temp.next.next;
            ListNode start = temp.next;
            start.next = end.next;
            temp.next = end;
            end.next = start;
            temp = start;
        }

        return dummyHead.next;
    }

    // 递归
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode end = head.next;

        head.next = swapPairs(end.next);

        end.next = head;

        return end;

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
