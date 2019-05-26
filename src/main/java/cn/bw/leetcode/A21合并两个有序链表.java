package cn.bw.leetcode;

/**
 * @description: 21 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @auther: bian.wu
 * @date: 2019/4/24 15:05
 */
public class A21合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ahead = new ListNode(0);
        ListNode n1 = l1, n2 = l2, current = ahead;

        while (n1!=null && n2!=null){
            if(n1.val<n2.val){
                current.next = new ListNode(n1.val);
                current = current.next;
                n1 = n1.next;
            }else {
                current.next = new ListNode(n2.val);
                current = current.next;
                n2 = n2.next;
            }
        }

        while (n1!=null){
            current.next = new ListNode(n1.val);
            current = current.next;
            n1 = n1.next;
        }

        while (n2!=null){
            current.next = new ListNode(n2.val);
            current = current.next;
            n2 = n2.next;
        }

        return ahead.next;
    }


}
