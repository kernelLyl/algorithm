import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//从尾到头打印链表
public class NO_06_PrintListInReverseOrder {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();

        //推荐实现了Deque接口的LinkedList来充当栈
        Deque<Integer> deque = new LinkedList<>();
        while(listNode != null) {
            deque.offerFirst(listNode.val);
            listNode = listNode.next;
        }

        while(!deque.isEmpty()) {
            result.add(deque.pollFirst());
        }

        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
