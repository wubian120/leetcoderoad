package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/31 13:17
 */
public class A21_one {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode beforeHead = new ListNode(0);
        ListNode current = null;
        beforeHead = current;
        while (l1 != null && l2 != null){

            if(l1.val>=l2.val){
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }else {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            }
        }

        while (l1 !=null){
            current.next = new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null){
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }

        return beforeHead.next;
    }
}
