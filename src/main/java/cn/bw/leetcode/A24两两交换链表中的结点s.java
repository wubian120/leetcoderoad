package cn.bw.leetcode;

import java.util.List;

public class A24两两交换链表中的结点s {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode current = beforeHead;

        while (head != null && head.next != null) {
            current.next = head.next;
            head.next = current.next.next;
            current.next.next = head;

            current = current.next.next;
            head = current.next;
        }


        return beforeHead.next;
    }

}
