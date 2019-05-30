package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/29 19:50
 */
public class A142环形链表IIs {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head){

        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head, slow = head;

        while (fast !=null && fast.next !=null){

            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null || fast.next == null){
            return null;
        }

        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

}
