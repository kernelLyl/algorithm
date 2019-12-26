public class NO_23_EntryNodeInListLoop {
    //找到一快一满指针相遇处的节点，相遇的节点一定是在环内
    //为何相遇可以自己模拟一下,两个指针间隔一个,两个,相邻,各种情况试一遍,必然相遇
    public static ListNode meetingNode(ListNode head) {
        if(head==null)
            return null;

        ListNode slow = head.next;
        if(slow==null)
            return null;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if(slow==fast){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;

            if(fast!=slow){
                fast=fast.next;
            }
        }
        return null;
    }


    //先找到环的长度,然后再用两个指针从起点出发,一个指针先走一个环的长度,两个指针相遇的地方就是环的入口
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode=meetingNode(pHead);
        if(meetingNode==null)
            return null;
        //得到环中的节点个数
        int nodesInLoop=1;
        ListNode p1=meetingNode;
        while(p1.next!=meetingNode){
            p1=p1.next;
            ++nodesInLoop;
        }
        //移动p1
        p1=pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1=p1.next;
        }
        //移动p1，p2
        ListNode p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
