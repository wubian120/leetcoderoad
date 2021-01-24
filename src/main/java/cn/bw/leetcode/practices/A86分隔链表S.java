package cn.bw.leetcode.practices;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/5/29 11:41
 */
public class A86分隔链表S {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 两个指针，  一个 小于 x, 一个大于 x。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head , int x){
        if(head ==null || head.next == null){
            return head;
        }
        ListNode beforeHead = new ListNode(0), before = beforeHead;
        ListNode afterHead = new ListNode(1), after = afterHead;

        while (head != null){

            if(head.val >= x){
                after.next = head;
                head = head.next;
                after = after.next;
                after.next = null;
            }else {

                before.next = head;
                head = head.next;
                before = before.next;
                before.next = null;
            }

        }
         // 前后两个链表 连起来 。
        before.next = afterHead.next;
        return beforeHead.next;

    }

}
