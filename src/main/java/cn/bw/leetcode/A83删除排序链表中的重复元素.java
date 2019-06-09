package cn.bw.leetcode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/9 17:26
 */
public class A83删除排序链表中的重复元素 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.next != null){

            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }
}
