package cn.bw.leetcode.practices;

import javax.xml.stream.FactoryConfigurationError;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/29 19:39
 */
public class A141环形链表s {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next!= null){

            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;

    }

}
